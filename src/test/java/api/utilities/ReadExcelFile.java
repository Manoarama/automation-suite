package api.utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    public static String[][] getCellValue(String filename, String sheetName, int startRow, int startCol) {
        try (FileInputStream fis = new FileInputStream(filename);
             Workbook workbook = getWorkbook(fis, filename)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " not found in " + filename);
            }

            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Adjust array size based on given startRow/startCol
            int rowsToRead = totalRows - startRow;
            int colsToRead = totalCols - startCol;

            String[][] data = new String[rowsToRead][colsToRead];
            DataFormatter formatter = new DataFormatter();

            for (int i = startRow; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = startCol; j < totalCols; j++) {
                    Cell cell = (row != null) ? row.getCell(j) : null;
                    data[i - startRow][j - startCol] =
                            (cell != null) ? formatter.formatCellValue(cell) : "";
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
    }


    public static int getRowCount(String filename, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filename);
             Workbook workbook = getWorkbook(fis, filename)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in " + filename);
            }
            return sheet.getPhysicalNumberOfRows();

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
    }

    // Get column count
    public static int getColumnCount(String filename, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filename);
             Workbook workbook = getWorkbook(fis, filename)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null || sheet.getPhysicalNumberOfRows() == 0) {
                return 0;
            }
            return sheet.getRow(0).getPhysicalNumberOfCells();

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
    }
    private static Workbook getWorkbook(FileInputStream fis, String filename) throws IOException {
        if (filename.toLowerCase().endsWith(".xlsx")) {
            return new XSSFWorkbook(fis);
        } else if (filename.toLowerCase().endsWith(".xls")) {
            return new HSSFWorkbook(fis);
        } else {
            throw new IllegalArgumentException("Invalid file format: " + filename);
        }
    }


}