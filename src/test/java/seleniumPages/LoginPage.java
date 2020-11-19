package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public void checkLoginIsSuccess() {
        if(driver.findElement(By.tagName("h1")).isDisplayed()) {
            System.out.println("Login realizado com sucesso, mensagem 'Bem vindo ao Desafio' exibida");
        } else {
            System.out.println("Login NÂO foi realizado com sucesso");
        }
    }
}