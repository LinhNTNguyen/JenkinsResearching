package pageobjectreader;

import pageobjectdto.AuthenticationDTO;
import utils.excelutils.BaseExcelDataReader;

/**
 * Created by USER on 10/4/2017.
 */
public class AuthenticationReader {
    public AuthenticationDTO readAuthenticationDTO(BaseExcelDataReader baseExcelDataReader){
        AuthenticationDTO authenticationDTO = new AuthenticationDTO();
        authenticationDTO.setEmailAddress(baseExcelDataReader.getValueByColumn("Email Address"));
        authenticationDTO.setEmail(baseExcelDataReader.getValueByColumn("Email"));
        authenticationDTO.setPassword(baseExcelDataReader.getValueByColumn("Password"));
        authenticationDTO.setLblAuthentication(baseExcelDataReader.getValueByColumn("LblAuthentication"));
        return authenticationDTO;
    }
}
