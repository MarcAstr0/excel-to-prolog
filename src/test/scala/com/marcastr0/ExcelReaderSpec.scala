package com.marcastr0

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.scalatest.FlatSpec

class ExcelReaderSpec extends FlatSpec {
  val xlsxFile = getClass.getResourceAsStream("/family.xlsx")
  val workbook = new XSSFWorkbook(xlsxFile)

  "getSheets" should "get every sheet in the Excel file" in {
    val sheets = ExcelReader.getSheets(workbook)
    assert(sheets.length == 3)
    assert(sheets(0).getSheetName() == "parent")
    assert(sheets(1).getSheetName() == "male")
    assert(sheets(2).getSheetName() == "female")
  }

  "getSheetHeaders" should "return the header cells of the sheet" in {
    val sheets = ExcelReader.getSheets(workbook)
    assert(
      ExcelReader.getSheetHeaders(sheets(0)).map(cell => cell.toString)
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
}
