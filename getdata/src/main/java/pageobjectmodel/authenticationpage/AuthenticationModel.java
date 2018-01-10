package pageobjectmodel.authenticationpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by USER on 10/1/2017.
 */
public class AuthenticationModel {
    public static WebElement btnHome(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i"));
        return webElement;
    }
    public static WebElement lblAuthentication(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//div[@id=\'center_column\']/h1[contains(.,'Authentication')]"));
        return webElement;
    }
    public static WebElement lblCreateAnAccount(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'create-account_form\']/h3"));
        return webElement;
    }
    public static WebElement txtEmailAddress(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.id("email_create"));
        return webElement;
    }
    public static WebElement btnCreateAnAccount(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'SubmitCreate\']/span"));
        return webElement;
    }
    public static WebElement lblAlreadyRegistered (WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'login_form\']/h3"));
        return webElement;
    }
    public static WebElement txtEmail(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.id("email"));
        return webElement;
    }
    public static WebElement txtPwd(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.id("passwd"));
        return webElement;
    }
    public static WebElement btnSignIn(WebDriver webDriver){
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'SubmitLogin\']/span"));
        return webElement;
    }
}
