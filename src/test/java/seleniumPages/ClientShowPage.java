package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ClientShowPage extends BasePage {

    public void accessClientShowPage() {
        WebElement qaLink = driver.findElement(By.linkText("QA"));
        action = new Actions(driver);
        action.moveToElement(qaLink).build().perform();
        WebElement clientLink = driver.findElement(By.linkText("Clientes"));
        action.moveToElement(clientLink).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Listar")).click();
    }

    public void clickSearch() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("j_idt20")).click();
    }

    public void clickView() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#formListarCliente > div > div > table > tbody > tr:nth-child(1) > td.text-center > a.btn.btn-sm.btn-primary")).click();
    }

    public String checkView() {
        return driver.findElement(By.tagName("label")).getText();
    }
}