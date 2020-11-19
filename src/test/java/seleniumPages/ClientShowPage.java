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
        driver.findElement(By.linkText("Listar")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void clickSearch() {
        driver.findElement(By.name("j_idt20")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickView() {
        driver.findElement(By.cssSelector("#formListarCliente > div > div > table > tbody > tr:nth-child(1) > td.text-center > a.btn.btn-sm.btn-primary")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String checkView() {
        return driver.findElement(By.tagName("label")).getText();
    }
}