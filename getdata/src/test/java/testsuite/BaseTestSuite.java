package testsuite;

import keywords.commonkeywords.CommonKeywords;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by USER on 10/4/2017.
 */
public class BaseTestSuite {
    @BeforeSuite
    public void setup() throws IOException {
        //launch browser and naviagte to website
        CommonKeywords commonKeywords = new CommonKeywords();
        String browser = "chrome";
        commonKeywords.launchBrowser(browser);
        commonKeywords.navigateToWebsite();
    }

    @AfterSuite
    public void tearDown(){
        CommonKeywords commonKeywords = new CommonKeywords();
        commonKeywords.tearDown();
    }
}
