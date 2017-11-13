package com.marcastr0

import java.io.InputStream

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.scalatest.FlatSpec

class ExcelReaderSpec extends FlatSpec {
  val xlsxFile: InputStream = getClass.getResourceAsStream("/family.xlsx")
  val workbook = new XSSFWorkbook(xlsxFile)

  "getSheets" should "get every sheet in the Excel file" in {
    val sheets = ExcelReader.getSheets(workbook)
    assert(sheets.length == 3)
    assert(sheets.head.getSheetName == "parent")
    assert(sheets(1).getSheetName == "male")
    assert(sheets(2).getSheetName == "female")
  }

  "getSheetHeaders" should "return the header cells of the sheet" in {
    val sheets = ExcelReader.getSheets(workbook)
    assert(
      ExcelReader.getSheetHeaders(sheets.head).map(cell => cell.toString)
        == List("parentName", "childName")
    )
    assert(
      ExcelReader.getSheetHeaders(sheets(1)).map(cell => cell.toString)
        == List("name")
    )
    assert(
      ExcelReader.getSheetHeaders(sheets(2)).map(cell => cell.toString)
        == List("name")
    )
  }

  "getRows" should "return the rows as lists of strings" in {
    val sheets = ExcelReader.getSheets(workbook)
    assert(
      ExcelReader.getRows(sheets.head) ==
        List(List("david", "john"), List("john", "eliza"), List("suzie", "eliza"))
    )
    assert(
      ExcelReader.getRows(sheets(1)) ==
        List(List("david"), List("john"))
    )
    assert(
      ExcelReader.getRows(sheets(2)) ==
        List(List("eliza"), List("suzie"))
    )
  }

  it should "return the rows as lists of strings and numbers" in {
    val xlsxFile: InputStream = getClass.getResourceAsStream("/age.xlsx")
    val workbook = new XSSFWorkbook(xlsxFile)
    val sheets = ExcelReader.getSheets(workbook)
    assert(ExcelReader.getRows(sheets.head) == List(List("mario", 35.0)))
  }
}
