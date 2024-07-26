# language: pt

@registro
Funcionalidade: Exibição do formulário de registro
Cenário: Usuário clica no botão de registro
Dado que o usuario esta na tela inicial do bugbank
Quando o usuario clicar no botao de registrar
Então devera ser exibido o formulario para o registro da conta do usuario

Cenário: Exibir saldo inicial ao acessar a conta
Dado que o usuario esta na tela inicial do bugbank
E o usuario cria uma conta com o opcao de saldo ativada
Quando o usuario preencher os campos de email e senha da conta recem criada
Então devera ser exibida na tela inicial do bugbank com um saldo inicial de '1.000,00'

Cenário: Exibir saldo inicial ao acessar a conta
Dado que o usuario esta na tela inicial do bugbank
E o usuario cria uma conta com a opcao de saldo desativado
Quando o usuario preencher os campos de email e senha da conta recem criada
Entao devera ser exibida na tela inicial do bugbank com um saldo inicial zerado '0,00'
