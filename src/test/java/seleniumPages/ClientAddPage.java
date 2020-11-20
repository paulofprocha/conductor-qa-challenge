package seleniumPages;

import common.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ClientAddPage extends BasePage {

    public void accessClientAddPage() {
        WebElement qaLink = driver.findElement(By.linkText("QA"));
        action = new Actions(driver);
        action.moveToElement(qaLink).build().perform();
        WebElement clientLink = driver.findElement(By.linkText("Clientes"));
        action.moveToElement(clientLink).build().perform();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.findElement(By.linkText("Incluir")).click();
    }

    //Prenche todos os campos obritórios do cliente

    public void addClientData() {
        String randomText = UUID.randomUUID().toString();
        driver.findElement(By.id("nome")).sendKeys(randomText);
        driver.findElement(By.id("cpf")).sendKeys("99999999999");
        Random decimalRandomNumber = new Random();
        driver.findElement(By.id("saldoCliente")).sendKeys(""+decimalRandomNumber);
    }

    public void clickSave() {
        driver.findElement(By.id("botaoSalvar")).click();
    }

    public void checkSuccessMsg() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
          .withTimeout(Duration.ofSeconds(30))
          .pollingEvery(Duration.ofSeconds(5))
          .ignoring(NoSuchElementException.class);

        WebElement alertMessage = wait.until(new Function<WebDriver, WebElement>() {
          public WebElement apply (WebDriver driver) {
            return driver.findElement(By.id("alertMessage"));
          }
        });

        String messageText = alertMessage.getText();
        System.out.println(messageText);
    }
}