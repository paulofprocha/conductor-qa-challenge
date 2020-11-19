@ManipularClienteVenda
Feature: Realizar login, cadastrar/listar um cliente e uma venda
  This funcionalidade realiza o login no sistema, cadastra e lista um cliente e uma venda

  Background:
    Given que o navegador da web está na página inicial da aplicação

  @RealizarLogin
  Scenario: Realizar o login na página inicial
    Given que o usuário acessou a página inicial da aplicação
    When preencher o login
    And preencher a senha
    And clicar em entrar
    Then o usuário irá acessar a página principal do sistema

  Scenario: Realizar o cadastro do cliente
    Given que o usuário acessou a página de cadastrar cliente
    When preencher todos os campos obrigatórios
    And clicar em salvar
    Then o sistema deve apresentar mensagem de sucesso

  Scenario: Exibir o cliente na listagem
    Given que o usuário acessou a página de listar cliente
    When clicar em pesquisar
    Then deve ser exibido os dados do cliente

  Scenario: Realizar o registro da venda
    Given que o usuário acessou a página de registrar venda
    When o usuário selecionar o cliente
    And informar o valor da transação
    And clicar no botao salvar
    Then a aplicação deve apresentar mensagem de sucesso

  Scenario: Exibir a venda na listagem
    Given que o usuário acessou a página de listar vendas
    When clicar no botão pesquisar
    Then deve ser exibido as vendas cadastradas