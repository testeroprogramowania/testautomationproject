package pl.testeroprogramowania.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelImport {

    public static Object[][] readExcel(String fileName) throws IOException {

        File file = new File("src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExt = fileName.substring(fileName.indexOf("."));
        if(fileExt.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if(fileExt.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];

        for (int i=1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for(int j=0; j<columnCount; j++) {
                data[i-1][j] = row.getCell(j).getStringCellValue();
            }
        }
        return data;
    }
    public static void main(String[] args) throws IOException {
        readExcel("citiesData.xls");

    }
}
