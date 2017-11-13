package com.marcastr0

import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet, XSSFWorkbook}
import org.apache.poi.ss.usermodel.Cell.{CELL_TYPE_NUMERIC, CELL_TYPE_STRING}

object ExcelReader {

  def getSheets(workbook: XSSFWorkbook): List[XSSFSheet] = {
    val sheets = for {
      i <- 0 until workbook.getNumberOfSheets
    } yield workbook.getSheetAt(i)
    sheets.toList
  }

  def getSheetHeaders(sheet: XSSFSheet): List[XSSFCell] = {
    val headers = sheet.getRow(0)
    val cells = for {
      i <- 0 until headers.getPhysicalNumberOfCells
    } yield headers.getCell(i)
    cells.toList
  }

  def getRows(sheet: XSSFSheet): List[List[Any]] = {
    val rows = for {
      i <- 1 until sheet.getPhysicalNumberOfRows
    } yield sheet.getRow(i)
    rows.map { row => {
        for {
          i <- 0 until row.getPhysicalNumberOfCells
        } yield {
          row.getCell(i).getCellType match {
            case CELL_TYPE_STRING => row.getCell(i).toString
            case _ => row.getCell(i).getNumericCellValue
          }
        }
      }.toList
    }.toList
  }

}
