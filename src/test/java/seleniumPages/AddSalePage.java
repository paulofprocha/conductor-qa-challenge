package seleniumPages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSalePage extends BasePage {

    public void accessAddSalePage(){
        WebElement qaLink = driver.findElement(By.linkText("QA"));
        action = new Actions(driver);
        action.moveToElement(qaLink).build().perform();
        WebElement saleLink = driver.findElement(By.linkText("Transações"));
        action.moveToElement(saleLink).build().perform();
        driver.findElement(By.linkText("Incluir")).click();
    }

    public void addSaleClient(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cliente")));
        WebElement combo = driver.findElement(By.id("cliente"));
        select = new Select(combo);
        select.selectByIndex(1);
    }

    public void addSaleValue() {
        driver.findElement(By.id("valorTransacao")).sendKeys("1");
    }

    public void clickSave(){
        driver.findElement(By.id("botaoSalvar")).click();
    }

    public void checkSuccessMsg(){
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