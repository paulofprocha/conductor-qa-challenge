package stepDefinitions;

import common.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumPages.*;

public class Steps {

    private BasePage basepage = new BasePage();
    private LoginPage loginpage = new LoginPage();
    private ClientAddPage clientaddpage = new ClientAddPage();
    private ClientShowPage clientshowpage = new ClientShowPage();
    private AddSalePage addsalepage = new AddSalePage();
    private ShowSalePage showsalepage = new ShowSalePage();

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
    }

    @Given("que o usuário acessou a página inicial da aplicação")
    public void que_o_usuario_acessou_a_pagina_inicial_da_aplicacao() {
        basepage.openURL();
    }

    @When("preencher o login")
    public void preencher_o_login() {
        loginpage.addLogin();
    }

    @When("preencher a senha")
    public void preencher_a_senha() {
        loginpage.addPassword();
    }

    @When("clicar em entrar")
    public void clicar_em_entrar() {
        loginpage.clickLogin();
    }

    @Then("o usuário irá acessar a página principal do sistema")
    public void o_usuario_ira_acessar_a_pagina_principal_do_sistema() {
        Assert.assertEquals("Bem vindo ao Desafio", loginpage.checkLoginIsSuccess());
        System.out.println("Login realizado com sucesso, mensagem 'Bem vindo ao Desafio' exibida");
    }

    @Given("que o usuário acessou a página de cadastrar cliente")
    public void que_o_usuario_acessou_a_pagina_de_cadastrar_cliente() throws InterruptedException {
        basepage.openURL();
        loginpage.doLogin();
        clientaddpage.accessClientAddPage();
    }

    @When("preencher todos os campos obrigatórios")
    public void preencher_todos_os_campos_obrigatorios() {
        clientaddpage.addClientData();
    }

    @When("clicar em salvar")
    public void clicar_em_salvar() {
        clientaddpage.clickSave();
    }

    @Then("o sistema deve apresentar mensagem de sucesso")
    public void o_sistema_deve_apresentar_mensagem_de_sucesso() {
        clientaddpage.checkSuccessMsg();
    }

    @Given("que o usuário acessou a página de listar cliente")
    public void que_o_usuario_acessou_a_pagina_de_listar_cliente() {
        basepage.openURL();
        loginpage.doLogin();
        clientshowpage.accessClientShowPage();
    }

    @When("clicar em pesquisar")
    public void clicar_em_pesquisar() {
        clientshowpage.clickSearch();
        clientshowpage.clickView();
    }

    @Then("deve ser exibido os dados do cliente")
    public void deve_ser_exibido_os_dados_do_cliente() {
        Assert.assertEquals("Visualizar Cliente", clientshowpage.checkView());
        System.out.println("Página de visualização exibida com sucesso");
    }

    @Given("que o usuário acessou a página de registrar venda")
    public void que_o_usuario_acessou_a_pagina_de_registrar_venda() {
        basepage.openURL();
        loginpage.doLogin();
        addsalepage.accessAddSalePage();
    }

    @When("o usuário selecionar o cliente")
    public void o_usuario_selecionar_o_cliente() {
        addsalepage.addSaleClient();
    }

    @When("informar o valor da transação")
    public void informar_o_valor_da_transacao() {
        addsalepage.addSaleValue();
    }

    @When("clicar no botao salvar")
    public void clicar_no_botao_salvar() {
        addsalepage.clickSave();
    }

    @Then("a aplicação deve apresentar mensagem de sucesso")
    public void a_aplicacao_deve_apresentar_mensagem_de_sucesso() {
        addsalepage.checkSuccessMsg();
    }

    @Given("que o usuário acessou a página de listar vendas")
    public void que_o_usuario_acessou_a_pagina_de_listar_vendas() {
        basepage.openURL();
        loginpage.doLogin();
        showsalepage.accessShowSalePage();
    }

    @When("clicar no botão pesquisar")
    public void clicar_no_botao_pesquisar() {
        showsalepage.clickSearch();
        showsalepage.clickView();
    }

    @Then("deve ser exibido as vendas cadastradas")
    public void deve_ser_exibido_as_vendas_cadastradas() {
        Assert.assertEquals("Visualizar Transacao", showsalepage.checkView());
        System.out.println("Página de visualização exibida com sucesso");
    }
}