package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    public void addLogin() {
        driver.findElement(By.name("username")).sendKeys("admin");
    }

    public void addPassword() {
        driver.findElement(By.name("password")).sendKeys("admin");
    }

    public void clickLogin() {
        driver.findElement(By.tagName("button")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String checkLoginIsSuccess() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public void doLogin() {
        addLogin();
        addPassword();
        clickLogin();
    }
}