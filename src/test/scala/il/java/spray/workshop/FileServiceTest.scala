package il.java.spray.workshop

import java.io.File

import org.scalatest.{OptionValues, FlatSpec, Matchers}

class FileServiceTest extends FlatSpec with Matchers with OptionValues {

  class Context {
    val fileService = new FileService
    val videoFileName = "VideoFile"
    val file1 = new File(videoFileName)
    val file2 = new File("SomeOtherFile")
    val videosFolder = "Videos"
  }

  "A FileService" should "Save a file" in new Context {
    fileService.add(file1, file2)

    fileService.fileSet.size shouldBe 2
  }

  it should "return a file by name" in new Context {
    fileService.add(file1, file2)

    fileService.fileByName(videoFileName).value should be(file1)
  }

  it should "return None if no such file was added" in new Context {
    fileService.add(file1, file2)

    fileService.fileByName("Bla") should be(None)
  }

  it should "add a file to a folder" in new Context {
    fileService.add(file1, file2)
    fileService.addToFolder(file1, videosFolder)

    fileService.filesInFolder(videosFolder) should be(Set(file1))
  }

  it should "remove a file from a folder" in new Context {
    fileService.add(file1, file2)
    fileService.addToFolder(file1, videosFolder)
    fileService.addToFolder(file2, videosFolder)
    fileService.removeFromFolder(file1)

    fileService.filesInFolder(videosFolder) should be(Set(file2))
  }

  it should "delete a file" in new Context {
    fileService.add(file1, file2)
    fileService.addToFolder(file1, videosFolder)

    fileService.deleteFile(file1)

    fileService.fileSet should be(Set(file2))
    fileService.filesInFolder(videosFolder)
  }

}
