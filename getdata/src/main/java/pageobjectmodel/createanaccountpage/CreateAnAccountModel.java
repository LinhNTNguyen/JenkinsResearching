package pageobjectmodel.createanaccountpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by USER on 10/1/2017.
 */
public class CreateAnAccountModel {
    public static WebElement lblYourPersonalInformation(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'account-creation_form\']/div[1]/h3"));
        return webElement;
    }
}
