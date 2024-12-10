package com.insta.qa.util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;


    public static String TestDataPath = "C:\\Users\\DELL\\IdeaProjects\\POM_Automation\\src\\main\\java\\com\\insta\\qa\\testData\\DataDrivenInsta.xls";

    static Workbook book;
    public static org.apache.poi.ss.usermodel.Sheet sheet;

    public static Object[][] getTestData(String SheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TestDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(SheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;

    }
}
