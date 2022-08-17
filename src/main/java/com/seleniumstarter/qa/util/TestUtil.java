package com.seleniumstarter.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class TestUtil {

    public static Workbook book;
    public static Sheet sheet;
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;
    public static String TEST_DATA_SHEET_PATH = "/Users/mwine/workspace/seleniumstarterproject"
            + "/src/main/resources/com/seleniumstarter/qa/base/testdata.xlsx";

    public static Object[][] getTestData( String sheetName ) {

        FileInputStream file = null;
        try {

            file = new FileInputStream( TEST_DATA_SHEET_PATH );
        }
        catch ( FileNotFoundException e ) {

            throw new RuntimeException( "file path not found", e );
        }
        try {

            book = WorkbookFactory.create( file );
        }
        catch ( EncryptedDocumentException e ) {

            throw new RuntimeException( "testdata.xlsx is encrypted", e );
        }
        catch ( IOException e ) {

            throw new RuntimeException( "testdata.xlsx is missing", e );
        }
        sheet = book.getSheet( sheetName );
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow( 0 ).getLastCellNum()];
        for ( int i = 0; i < sheet.getLastRowNum(); i++ ) {

            for ( int k = 0; k < sheet.getRow( 0 ).getLastCellNum(); k++ ) {

                data[i][k] = sheet.getRow( i + 1 ).getCell( k ).toString();
            }
        }
        return data;
    }
}
