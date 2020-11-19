package stepDefinitions;

import common.BasePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumPages.ClientAddPage;
import seleniumPages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

public class Steps {

    private BasePage basepage = new BasePage();
    private LoginPage loginpage = new LoginPage();
    private ClientAddPage clientaddpage = new ClientAddPage();

    @Before
    public void setupChrome() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @After
    public void closeChrome() {
        basepage.driver.quit();
    }

    @Given("que o navegador da web está na página inicial da aplicação")
    public void que_o_navegador_da_web_esta_na_pagina_inicial_da_aplicacao() {
        basepage.initBrowser();
        //throw new cucumber.api.PendingException();
    }

    @Given("que o usuário acessou a página inicial da aplicação")
    public void que_o_usuario_acessou_a_pagina_inicial_da_aplicacao() {
        basepage.openURL();
//        throw new cucumber.api.PendingException();
    }

    @When("preencher o login")
    public void preencher_o_login() {
        loginpage.addLogin();
        //throw new cucumber.api.PendingException();
    }

    @When("preencher a senha")
    public void preencher_a_senha() {
        loginpage.addPassword();
        //throw new cucumber.api.PendingException();
    }

    @When("clicar em entrar")
    public void clicar_em_entrar() {
        loginpage.clickLogin();
        //throw new cucumber.api.PendingException();
    }

    @Then("o usuário irá acessar a página principal do sistema")
    public void o_usuario_ira_acessar_a_pagina_principal_do_sistema() {
        loginpage.checkLoginIsSuccess();
        //throw new cucumber.api.PendingException();
    }

    @Given("que o usuário acessou a página de cadastrar cliente")
    public void que_o_usuario_acessou_a_pagina_de_cadastrar_cliente() throws InterruptedException {
        clientaddpage.accessLoginPage();
        clientaddpage.doLogin();
        clientaddpage.accessClientAddPage();
//        throw new cucumber.api.PendingException();
    }

    @When("preencher todos os campos obrigatórios")
    public void preencher_todos_os_campos_obrigatorios() {
        clientaddpage.addClientData();
        //throw new cucumber.api.PendingException();
    }

    @When("clicar em salvar")
    public void clicar_em_salvar() {
        clientaddpage.clickSave();
        // throw new cucumber.api.PendingException();
    }

    @Then("o sistema deve apresentar mensagem de sucesso")
    public void o_sistema_deve_apresentar_mensagem_de_sucesso() {
        clientaddpage.checkSuccessMsg();
        //throw new cucumber.api.PendingException();
    }

    @Given("que o usuário acessou a página de listar cliente")
    public void que_o_usuario_acessou_a_pagina_de_listar_cliente() {
        System.out.println("Agora vai");
//        throw new cucumber.api.PendingException();
    }

    @When("clicar em pesquisar")
    public void clicar_em_pesquisar() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @Then("deve ser exibido os dados do cliente")
    public void deve_ser_exibido_os_dados_do_cliente() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @Given("que o usuário acessou a página de registrar venda")
    public void que_o_usuario_acessou_a_pagina_de_registrar_venda() {
        System.out.println("Agora vai");
//        throw new cucumber.api.PendingException();
    }

    @When("o usuário selecionar o cliente")
    public void o_usuario_selecionar_o_cliente() {
        System.out.println("Agora vai");
        //Select atividade = new Select(driver.findElement(By.id("cboAtividade")));
        //    atividade.selectByIndex(3);
        //throw new cucumber.api.PendingException();
    }

    @When("informar o valor da transação")
    public void informar_o_valor_da_transacao() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @When("clicar no botao salvar")
    public void clicar_no_botao_salvar() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @Then("a aplicação deve apresentar mensagem de sucesso")
    public void a_aplicacao_deve_apresentar_mensagem_de_sucesso() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @Given("que o usuário acessou a página de listar vendas")
    public void que_o_usuario_acessou_a_pagina_de_listar_vendas() {
        System.out.println("Agora vai");
       // throw new cucumber.api.PendingException();
    }

    @When("clicar no botão pesquisar")
    public void clicar_no_botao_pesquisar() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }

    @Then("deve ser exibido as vendas cadastradas")
    public void deve_ser_exibido_as_vendas_cadastradas() {
        System.out.println("Agora vai");
        //throw new cucumber.api.PendingException();
    }


    //    public WebDriverWait wait;

//    @Before
//    public void setup (){
//        String pathToChromeDriver = "driver/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
//        wait = new WebDriverWait(driver,10);
//    }

//    @After
//    public void close(){
//        driver.quit();
//    }

//    @Test
//    public void main() {
//        driver.manage().window().maximize();
//    }
}