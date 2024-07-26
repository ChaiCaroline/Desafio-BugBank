# language: pt

@login
Funcionalidade: Validação dos Campos de Login no BugBank
    Verificar os campos de login e senha na tela inicial do site BugBank

    # Contexto:
    # Dado que o usuario esta na tela inicial do BugBank

    Cenário: Exibir mensagem de erro ao tentar acessar sem preencher com e-mail e senha
    Dado que o usuario esta na tela inicial do BugBank
    E que o usuario nao tenha preenchido o email e a senha
    Quando o usuario ao clicar no botao de acessar
    Entao devera ser exibida uma mensagem de erro com o texto preencha os campos


    Esquema do Cenário: Exibir mensagem de erro ao preencher com e-mail inválido
        Dado que o usuario esta na tela inicial do BugBank
        Quando o usuario preencher o campo de email com um email invalido '<email>'
        Então devera ser exibida uma mensagem de erro com o texto email invalido

        Exemplos:
        | email           |
        | email.com       |
        | email@email     |
        | @email.com      |

    Cenário: Não exibir mensagem de erro ao preencher o campo de e-mail com um e-mail válido
    Dado que o usuario esta na tela inicial do BugBank
    E o usuario tenha preenchido com um email valido 'email@email.com'
    Quando o usuario ao clicar no botao de acessar
    Então nao deve ser retornado para o usuario nenhuma mensagem de erro no campo email

    Cenário: Exibir mensagem de erro, quando não preencher o campo de senha
    Dado que o usuario esta na tela inicial do BugBank
    E o usuario tenha preenchido com um email valido 'email@email.com'
    E nao tenha preenchido nenhuma senha
    Quando o usuario ao clicar no botao de acessar
    Entao devera ser apresentado ao usuario uma mensagem de erro com o texto campo senha obrigatorio
    E o usuario deve permanecer na tela de login

    Cenário: Exibir o texto digitado ao clicar no ícone no campo de senha.
    Dado que o usuario esta na tela inicial do BugBank
    E o usuario tenha preenchido com um email valido 'email@email.com'
    E tenha preechido com uma senha
    Quando o usuario clicar no ícone de olho no campo de senha
    Entao devera ser exibido para o usuario a senha digitada
    E devera ser alterado o ícone de olho no campo de senha

    Cenário: Redirecionar o usuário ao logar no sistema
    Dado que o usuario esta na tela inicial do BugBank
    E que o usuario tenha preenchido com um 'teste@email.com' e a '123' valido
    Quando o usuario ao clicar no botao de acessar
    Entao o usuario devera ser redirecionado para a tela inicial BugBank
    E deve ser apresentado as informacoes relacionadas ao usuario

    Cenário: Acessar a página inicial sem estar logado.
    Dado que o usuario esta na tela inicial do BugBank
    E o usuario nao esta logado no BugBank
    Quando o usuario tentar acessar a pagina atraves da url 'https://bugbank.netlify.app/home'
    Entao o usuario deve permanecer na tela inicial pois nao esta logada

    Cenário: Exibir um texto de erro, ao tentar logar com credenciais incorretas
    Dado que o usuario esta na tela inicial do BugBank
    E o usuario digitou um email nao cadastrado
    E tenha preechido com uma senha
    Quando o usuario ao clicar no botao de acessar
    Entao devera ser exibida ao usuario uma mensagem de email ou senha invalidos