# language: pt

@extrato
Funcionalidade: Validar funcionalidade extrato

Contexto:
    Dado que usuario esta na tela inicial do Bugbank
    E o usuario tenha preenchido os campos de email e senha validos
    E esteja na tela inicial

Cenário: Redirecionamento ao clicar no botão "Extrato"
    Quando o usuario clicar no botao de Extrato
    Entao devera ser redirecionado para a tela de extrato

Cenário: Exibição de transferências na tela de extrato após uma transferência realizada
    E o usuario ja tenha realizado uma transferencia para outra conta
    Quando o usuario clicar no botao de Extrato
    Entao deverao ser exibidas na tela todas as transferencias realizadas pelo usuario

Cenário: Exibição de transferências na tela de extrato após recebimento de uma transferência
    E o usuario ja tenha recebido uma transferencia
    Quando o usuario clicar no botao de Extrato
    Entao deverão ser exibidas na tela todas as transferencias recebidas pelo usuario