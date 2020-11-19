package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumPages.LoginPage;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ClientAddPage extends BasePage {

    private BasePage basepage = new BasePage();
    private LoginPage loginPage = new LoginPage();

    public void accessLoginPage() {
        basepage.openURL();
    }

    public void doLogin() {
        loginPage.addLogin();
        loginPage.addPassword();
        loginPage.clickLogin();
    }

    public void accessClientAddPage() {
        WebElement qaLink = driver.findElement(By.linkText("QA"));
        action = new Actions(driver);
        action.moveToElement(qaLink).build().perform();
        WebElement clientLink = driver.findElement(By.linkText("Clientes"));
        action.moveToElement(clientLink).build().perform();
        driver.findElement(By.linkText("Incluir")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void addClientData() {
        String randomText = UUID.randomUUID().toString();
        driver.findElement(By.id("nome")).sendKeys(randomText);
        driver.findElement(By.id("cpf")).sendKeys("99999999999");
        Random decimalRandomNumber = new Random();
        driver.findElement(By.id("saldoCliente")).sendKeys(""+decimalRandomNumber);
    }

    public void clickSave() {
        driver.findElement(By.id("botaoSalvar")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void checkSuccessMsg() {
        if(driver.findElement(By.id("alertMessage")).isDisplayed()){
            System.out.println("Cadastro realizado com sucesso, mensagem de sucesso exibida");
        } else {
            System.out.println("Cadastro NÃO foi realizado com suceso");
        }
    }
}