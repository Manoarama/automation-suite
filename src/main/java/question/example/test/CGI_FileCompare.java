package question.example.test;

import java.io.*;

public class CGI_FileCompare {
    public static void main(String[] args) throws IOException {

        String expectedFilePath = "expected.txt";
        String actualFilePath = "actual.txt";

        compareFiles(expectedFilePath, actualFilePath);
       /* String query="";
        try {
            getAzureconnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

       /* try {
            try {
                //String token="";401,403 bearer token
                ResquestSpecification specification=Requet.bearer("token").get("").when().then();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

    }



    public static void compareFiles(String expectedPath, String actualPath) throws IOException {
        BufferedReader expectedReader = new BufferedReader(new FileReader(expectedPath));
        BufferedReader actualReader = new BufferedReader(new FileReader(actualPath));

        String expectedLine;
        String actualLine;
        int lineNum = 1;
        boolean isMatching = true;

        while ((expectedLine = expectedReader.readLine()) != null
                | (actualLine = actualReader.readLine()) != null) {

            if (expectedLine == null) expectedLine = "";
            if (actualLine == null) actualLine = "";

            if (!expectedLine.equals(actualLine)) {
                System.out.println("❌ Mismatch at line " + lineNum);
                System.out.println("Expected: " + expectedLine);
                System.out.println("Actual  : " + actualLine);
                isMatching = false;
            }
            lineNum++;
        }

        expectedReader.close();
        actualReader.close();

        if (isMatching) {
            System.out.println("✅ Files match exactly. Test PASSED.");
        } else {
            System.out.println("❌ Files do not match. Test FAILED.");
        }
    }
}


