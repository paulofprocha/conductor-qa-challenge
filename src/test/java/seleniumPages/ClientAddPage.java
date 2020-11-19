package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ClientAddPage extends BasePage {

    public void accessClientAddPage() {
        WebElement qaLink = driver.findElement(By.linkText("QA"));
        action = new Actions(driver);
        action.moveToElement(qaLink).build().perform();
        WebElement clientLink = driver.findElement(By.linkText("Clientes"));
        action.moveToElement(clientLink).build().perform();
        driver.findElement(By.linkText("Incluir")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //Prenche todos os campos obritórios do cliente

    public void addClientData() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
        wait = new WebDriverWait(driver, 10);
        By element = By.id("alertMessage");
        String text = driver.findElement(By.id("alertMessage")).getText();
        if(wait.until(ExpectedConditions.textToBePresentInElementLocated(element, text))){
            System.out.println(""+text);
        } else {
            System.out.println("Erro ao exibir mensagem de sucesso");
        }
    }
}