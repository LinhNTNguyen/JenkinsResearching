package utils.excelutils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by USER on 10/4/2017.
 */
public class ExcelUtils {
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
}
