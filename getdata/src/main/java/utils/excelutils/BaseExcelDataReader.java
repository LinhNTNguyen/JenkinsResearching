package utils.excelutils;


/**
 * Created by USER on 10/4/2017.
 */
public class BaseExcelDataReader {
    public String getValueByColumn(String columnName){return null;}

    public Boolean getBooleanValueByColumn(String columnName){
        String value = getValueByColumn(columnName);
        if(value == null){
            return null;
        }

        if("Oui".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value) || "Yes".equalsIgnoreCase(value)){
            return true;
        }
        if("Non".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value) || "No".equalsIgnoreCase(value)){
            return false;
        }

        return null;
    }
}
