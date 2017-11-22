package com.marcastr0

import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}
import org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING

object ExcelReader {

  /**
    * Gets the sheets from an Excel workbook
    * @param workbook the Excel workbook
    * @return a list of sheets
    */
  def getSheets(workbook: XSSFWorkbook): List[XSSFSheet] = {
    val sheets = for {
      i <- 0 until workbook.getNumberOfSheets
    } yield workbook.getSheetAt(i)
    sheets.toList
  }

  /**
    * Gets the cells of the header row of an Excel sheet
    * @param sheet the Excel sheet
    * @return a list of strings with the cell contents
    */
  def getSheetHeaders(sheet: XSSFSheet): List[String] = {
    val headers = sheet.getRow(0)
    val cells = for {
      i <- 0 until headers.getPhysicalNumberOfCells
    } yield headers.getCell(i).toString
    cells.toList
  }

  /**
    * Gets the non header rows of an Excel sheet
    * @param sheet the Excel sheet
    * @return a list of cells, represented as lists
    */
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
