package keywords.commonkeywords;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.excelutils.ExcelDataReader;

import java.io.*;
import java.util.Properties;

import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 * Created by USER on 10/4/2017.
 */
public class CommonKeywords {
    Properties prop = new Properties();
    Thread currentThread = Thread.currentThread();
    ClassLoader contextClassLoader = currentThread.getContextClassLoader();
    InputStream input = null;
    InputStreamReader inputStreamReader;
    String pathDriver = null;

    public static WebDriver webDriver = null;

    //get browser to launch
    public void launchBrowser(String browser) throws IOException {
        String environmentPath = System.getProperty("user.dir") + "\\src\\main\\java\\utils\\config\\Environment.properties";
        input = new FileInputStream(environmentPath);
        inputStreamReader = new InputStreamReader(input, "UTF-8");
        prop.load(input);
        try {
            if (browser.equalsIgnoreCase(prop.getProperty("CHROME_BROWSER"))) {
                pathDriver = System.getProperty("user.dir") + "\\src\\main\\java\\driver\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", pathDriver);
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
            } else {
                if (browser.equalsIgnoreCase(prop.getProperty("FF_BROWSER"))) {
                    pathDriver = System.getProperty("user.dir") + "\\src\\main\\java\\driver\\geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", pathDriver);
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    if (browser.equalsIgnoreCase(prop.getProperty("IE_BROWSER"))) {
                        pathDriver = System.getProperty("user.dir") + "\\src\\main\\java\\driver\\IEDriverServer.exe";
                        System.setProperty("webdriver.ie.driver", pathDriver);
                        webDriver = new InternetExplorerDriver();
                        webDriver.manage().window().maximize();
                    } else {
                        pathDriver = System.getProperty("user.dir") + "\\src\\main\\java\\driver\\MicrosoftWebDriver.exe";
                        System.setProperty("webdriver.edge.driver", pathDriver);
                        webDriver = new EdgeDriver();
                        webDriver.manage().window().maximize();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(">>> Message from LaunchBrowser: " + e.getMessage());
        }
    }

    public void navigateToWebsite() throws IOException {
        String environmentPath = System.getProperty("user.dir") + "\\src\\main\\java\\utils\\config\\Environment.properties";
        input = new FileInputStream(environmentPath);
        inputStreamReader = new InputStreamReader(input, "UTF-8");
        prop.load(input);
        try {
            webDriver.navigate().to(prop.getProperty("URL"));
        } catch (Exception e) {
            System.out.println(">>> Message from NavigateToWebsite: " + e.getMessage());
        }
    }

    public void tearDown() {
        try {
            webDriver.close();
            webDriver.quit();
        } catch (Exception e) {
            System.out.println(">>> Message from Teardown: " + e.getMessage());
        }

    }

    public void click(WebElement webElement) {
        try {
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                webElement.click();
            }else{
                //Do nothing
            }
        } catch (Exception e) {
            System.out.println(">>> Message from keyword Click: " + e.getMessage());
        }

    }

    public void sendKeys(WebElement webElement, String value){
        try{
            if(value != null && webElement.isDisplayed() && webElement.isEnabled()){
                webElement.sendKeys(value);
            }else{
                //do nothing
            }
        }catch (Exception e){
            System.out.println(">>> Message from keyword SendKeys: " + e.getMessage());
        }

    }

    public Boolean verifyEquals(WebElement webElement, String value){
        Boolean equal = true;
        try{
            if(value != null){
                if(webElement.getText().equalsIgnoreCase(value)){
                    System.out.println(">>> Actual value: " + webElement.getText() + " = Expected value: " + value);
                }else{
                    System.out.println(">>> Actual value: " + webElement.getText() + " != Expected value: " + value);
                    equal = false;
                }
            }
        }catch (Exception e){
            System.out.println(">>> Message from keyword Verify Existence: " + e.getMessage());
        }
        return equal;
    }

    public Boolean verifyPopulated(WebElement webElement){
        Boolean populated = true;
        try{
                if(webElement.getAttribute("value") != null){
                    System.out.println(">>> The value is populated: " + webElement.getAttribute("value"));
                }else{
                    System.out.println(">>> The value is not populated: " + webElement.getAttribute("value"));
                    populated = false;
                }
        }catch (Exception e){
            System.out.println(">>> Message from keyword Verify Existence: " + e.getMessage());
        }
        return populated;
    }
}
