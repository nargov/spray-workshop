package il.java.spray.workshop

import java.io.File

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class FileService() {
  def deleteFile(file: File) = {
    removeFromFolder(file)
    fileBuffer -= file
  }

  def removeFromFolder(file: File) = folders.remove(file)

  private val folders: mutable.Map[File, String] = mutable.Map.empty

  def filesInFolder(folderName: String): Set[File] = folders.filter(_._2 == folderName).keySet.toSet

  private val fileBuffer = new ArrayBuffer[File]()

  def fileSet: Set[File] = this.fileBuffer.toSet

  def add(files: File*): Unit = files.foreach(this.fileBuffer += _)

  def fileByName(name: String): Option[File] = fileBuffer.find(_.getName == name)

  def addToFolder(file: File, folderName: String) = folders.put(file, folderName)
}
