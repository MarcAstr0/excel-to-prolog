package com.marcastr0

import java.io.InputStream

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.scalatest.FlatSpec

class ExcelToPrologSpec extends FlatSpec {
  val xlsxFile: InputStream = getClass.getResourceAsStream("/family.xlsx")
  val workbook = new XSSFWorkbook(xlsxFile)
  val sheets = ExcelReader.getSheets(workbook)

  "createKnowledgeBase" should "create a knowledge base of facts" in {
    assert(ExcelToProlog.createKnowledgeBase(sheets.head) ==
      """|% parent(parentName,childName).
        |parent("david","john").
        |parent("john","eliza").
        |parent("suzie","eliza").""".stripMargin)
  }
}
