package com.seleniumstarter.qa.util;

import java.io.IOException;
import java.io.InputStream;

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

    public static Object[][] getTestData( String sheetName ) {

        InputStream file = null;
        file = TestUtil.class.getResourceAsStream( "testdata.xlsx" );
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
