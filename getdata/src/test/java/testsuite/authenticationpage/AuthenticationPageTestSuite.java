package testsuite.authenticationpage;

import keywords.commonkeywords.CommonKeywords;
import org.testng.annotations.Test;
import pageobjectdto.AuthenticationDTO;
import pageobjectmodel.authenticationpage.AuthenticationModel;
import pageobjectmodel.homepage.HomePageModel;
import pageobjectreader.AuthenticationReader;
import testsuite.BaseTestSuite;
import utils.excelutils.BaseExcelDataReader;
import utils.excelutils.ExcelDataReader;
import static keywords.commonkeywords.CommonKeywords.webDriver;

/**
 * Created by USER on 10/4/2017.
 */
public class AuthenticationPageTestSuite extends BaseTestSuite {
    @Test
    public void testTheUIofAuthenticationPage() throws Exception {
        AuthenticationModel authenticationModel = new AuthenticationModel();
        HomePageModel homePageModel = new HomePageModel();
        CommonKeywords commonKeywords = new CommonKeywords();
        String excelData = System.getProperty("user.dir") + "\\src\\main\\java\\data\\AuthenticationData.xlsx";
        BaseExcelDataReader baseExcelDataReader = new ExcelDataReader(excelData, "UI", 1);
        //Click on 'Signin' button from Home Page
        commonKeywords.click(homePageModel.btnSignIn(webDriver));
        //Verify the Authentication Page
        AuthenticationReader authenticationReader = new AuthenticationReader();
        AuthenticationDTO authenticationDTO = authenticationReader.readAuthenticationDTO(baseExcelDataReader);
        Boolean authenPageOrNot = commonKeywords.verifyEquals(
                authenticationModel.lblAuthentication(webDriver), authenticationDTO.getLblAuthentication());
        if(authenPageOrNot){
            System.out.println("The Authentication Page is open");
        }else{
            System.out.println("System may throw the incorrect page (Not Authentication Page)");
        }
        //Enter value into the Email Address field
        baseExcelDataReader = new ExcelDataReader(excelData, "CreateAnValidAccount", 1);
        authenticationDTO = authenticationReader.readAuthenticationDTO(baseExcelDataReader);
        commonKeywords.sendKeys(authenticationModel.txtEmailAddress(webDriver), authenticationDTO.getEmailAddress());
        commonKeywords.verifyPopulated(authenticationModel.txtEmailAddress(webDriver));
        //Click on Create An Account button
        commonKeywords.click(authenticationModel.btnCreateAnAccount(webDriver));

    }

}
