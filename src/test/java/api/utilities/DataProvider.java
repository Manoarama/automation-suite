package api.utilities;

import java.util.Arrays;

public class DataProvider {

    public String[][] allDataProvider() {
            String testdataFileName = "/src/test/resources/testdata/TestData.xlsx";
            String filename = System.getProperty("user.dir") + testdataFileName;
            int rowCount = ReadExcelFile.getRowCount(filename, "Sheet1"); // get actual rows
            int columnCount = ReadExcelFile.getColumnCount(filename, "Sheet1"); // get actual columns

            String[][] userData = new String[rowCount - 1][columnCount]; // -1 if skipping header row
            for (int rowNumber = 1; rowNumber < rowCount; rowNumber++) { // start from 1 to skip header
                for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                    userData[rowNumber - 1][columnNumber] =
                            Arrays.toString(ReadExcelFile.getCellValue(filename, "Sheet1", rowNumber, columnNumber));
                }
            }
            return userData;
        }

}