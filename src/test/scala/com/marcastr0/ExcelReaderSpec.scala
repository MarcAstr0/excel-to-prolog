package com.marcastr0

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.scalatest.FlatSpec

class ExcelReaderSpec extends FlatSpec {

  "ExcelReader" should "get every sheet in the Excel file" in {
    val xlsxFile = getClass.getResourceAsStream("/family.xlsx")
    val workbook = new XSSFWorkbook(xlsxFile)
    val sheets = ExcelReader.getSheets(workbook)
    assert(sheets.length == 3)
    assert(sheets(0).getSheetName() == "parent")
    assert(sheets(1).getSheetName() == "male")
    assert(sheets(2).getSheetName() == "female")
  }
}
