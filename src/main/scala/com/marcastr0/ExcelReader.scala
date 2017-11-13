package com.marcastr0

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet, XSSFWorkbook}

object ExcelReader {

  def getSheets(workbook: XSSFWorkbook): List[XSSFSheet] = {
    val sheets = for {
      i <- 0 to workbook.getNumberOfSheets - 1
    } yield workbook.getSheetAt(i)
    sheets.toList
  }

  def getSheetHeaders(sheet: XSSFSheet): List[XSSFCell] = {
    val headers = sheet.getRow(0)
    val cells = for {
      i <- 0 to headers.getPhysicalNumberOfCells - 1
    } yield headers.getCell(i)
    cells.toList
  }

}
