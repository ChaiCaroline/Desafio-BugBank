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

Cenário: Exibir mensagem de campo é obrigatório
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
E que o usuario nao tenha preenchido nenhum campo
Quando o usuario clicar em cadastrar
Então devera ser retornado em tela uma mensagem campo e obrigatorio

Esquema do Cenário: Exibir mensagem de erro ao preencher com e-mail inválido
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
Quando o usuario tiver preenchindo o campo de email com um email invalido "<email>"
Então devera ser exibida uma mensagem de erro
Exemplos:
        | email           |
        | email.com       |
        | email@email     |
        | @email.com      |

Cenário: Não exibir mensagem de erro ao preencher o campo de e-mail com um e-mail válido
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
Quando o usuario preencher o campo de email com um email valido 'teste@email.com'
Então nao deve ser retornado para o usuario nenhuma mensagem de erro

Cenário: Exibir uma mensagem de erro caso o campo nome esteja em branco
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
E o usuario digitou um email valido 'teste@email.com'
Quando o usuario clicar em cadastrar
Então devera ser exibido uma mensagem de campo nome obrigatorio

Cenário: Exibir uma mensagem de erro caso o campo de senha esteja em branco
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
E o usuario digitou um email valido 'teste@email.com'
E o usuario preencheu o nome
Quando o usuario clicar em cadastrar
Então devera ser exibido uma mensagem de campo obrigatorio

Cenário: Exibir uma mensagem de erro caso o campo de confirmação de senha esteja diferente do campo de senha
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
E o usuario digitou um email valido 'teste@email.com'
E o usuario preencheu o nome
E o usuario preencheu uma senha
E o usuario digitou uma senha diferente no campo de confirmacao de senha
Quando o usuario clicar em cadastrar
Então devera ser exibida uma mensagem de erro indicando que as senhas nao coincidem

Cenário: Funcionalidade do botão criar conta com saldo
Dado que o usuario esta na tela inicial do bugbank
E o usuario clica em registrar
Quando o usuario clicar no botao criar conta com saldo
Então o botao criar conta com saldo devera ser habilitado
