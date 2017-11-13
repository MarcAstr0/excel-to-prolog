package com.marcastr0

import java.io.{File, FileInputStream, InputStream, PrintWriter}

import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}

object ExcelToProlog {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("Must receive an Excel file as input.")
    } else {
      val excelFile = args(0)
      val fileStream: InputStream = new FileInputStream(excelFile)
      val workbook = new XSSFWorkbook(fileStream)
      val sheets = ExcelReader.getSheets(workbook)
      for (sheet <- sheets) {
        val writer = new PrintWriter(new File(sheet.getSheetName + ".pl"))
        writer.write(createKnowledgeBase(sheet))
        writer.close()
      }
    }
  }

  def createKnowledgeBase(sheet: XSSFSheet): String = {
    val header = PrologWriter.writeExplanation(sheet.getSheetName, ExcelReader.getSheetHeaders(sheet)) + "\n"
    val rows = ExcelReader.getRows(sheet) map {
      row => PrologWriter.writeFact(sheet.getSheetName, row)
    }
    header + rows.mkString("\n")
  }
}
