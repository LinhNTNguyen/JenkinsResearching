package utils.excelutils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by USER on 10/29/2017.
 */
public class ExcelDataReader extends BaseExcelDataReader{
    private XSSFWorkbook wb;
    private String sheetName;
    private int row;
    private String prefix;

    public void setRowIndex(int row){
        this.row = row;
    }

    public void setSheetName(String sheetName){
        this.sheetName = sheetName;
    }

    public ExcelDataReader(String fileName, String sheetName, int row) throws Exception {
        this.wb = new XSSFWorkbook(fileName);
        this.sheetName = sheetName;
        this.row = row;
    }

    public ExcelDataReader(String fileName, String sheetName, int row, String prefix) throws Exception {
        this.wb = new XSSFWorkbook(fileName);
        this.sheetName = sheetName;
        this.row = row;
        this.prefix = prefix;
    }

    public String getValueByColumn(String columnName) {
        String result = ExcelUtils.getValueByColumn(wb, sheetName, (prefix == null?"":prefix) + columnName, row);
        return result == null ? result : result.trim();
    }
}