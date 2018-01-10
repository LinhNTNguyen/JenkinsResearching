import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Linh Nguyen on 9/26/2017.
 */
public class GetData {
    /**
     * Get data from row and column
     */
    public static String getValueByColumn(XSSFWorkbook wb, String sheetName, String columnName, int row){

        String value = "";
        XSSFSheet sheet = null;
        try {
            if(sheetName == null || sheetName.equals(""))
                sheet = wb.getSheetAt(0);
            else
                sheet = wb.getSheet(sheetName);

            XSSFRow header = sheet.getRow(0);
            for (int col = 0; col <= header.getPhysicalNumberOfCells(); col++) {
                if (header.getCell(col).getStringCellValue().trim().equals(columnName)) {
                    value = sheet.getRow(row).getCell(col).getStringCellValue();
                    break;
                }
            }
        }catch (Exception ex){value = null;}
        return value;
    }
    @Test
    public void main() throws IOException {
        /*String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\data\\AuthenticationData.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        String sheetName = "CreateAnValidAccount";
        String columnName = "Email Address";
        String value = getValueByColumn(xssfWorkbook, sheetName, columnName, 1);
        System.out.println(">>>>>> Value:   " + value);
*/
        String pathDriver = null;
        WebDriver webDriver = null;
        //launch browser
        pathDriver = System.getProperty("user.dir") + "\\src\\main\\java\\driver\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", pathDriver);
        webDriver = new InternetExplorerDriver();
        webDriver.get("https://www.facebook.com/");

    }

}
