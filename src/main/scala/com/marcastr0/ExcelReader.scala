package com.marcastr0

import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}

object ExcelReader {

  def getSheets(workbook: XSSFWorkbook): List[XSSFSheet] = {
    val sheets = for {
      i <- 0 to workbook.getNumberOfSheets - 1
    } yield workbook.getSheetAt(i)
    return sheets.toList
  }

}
