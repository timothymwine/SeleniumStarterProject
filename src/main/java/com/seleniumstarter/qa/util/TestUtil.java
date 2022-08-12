package com.seleniumstarter.qa.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

    public static XSSFWorkbook workbook;
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;

    public static void getRowCount() throws IOException {

        String dataPath =
                "/Users/mwine/workspace/seleniumstarterproject/src/main/resources/com/"
                        + "seleniumstarter/qa/testdata/testdata.xlsx";

        workbook = new XSSFWorkbook( dataPath );
        XSSFSheet sheet = workbook.getSheet( "Sheet1" );
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println( "number of rows is :" + rowCount );
    }
}
