package pageobjectmodel.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by USER on 10/1/2017.
 */
public class HomePageModel {

    public static WebElement btnSignIn(WebDriver webDriver) {
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a"));
        return webElement;
    }
}
