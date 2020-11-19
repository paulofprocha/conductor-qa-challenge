package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public String baseURL = "http://provaqa.marketpay.com.br:9082/desafioqa";
    public static Actions action;
    public static WebDriverWait wait;

    public void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openURL() {
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //public WebDriverWait wait;

    //public BasePage(){
        //this.wait = new WebDriverWait(driver, 10);
    //}
}