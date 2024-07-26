package com.bugbank.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class RegistroSteps {
    // Cenario 1
    @Dado("que o usuario esta na tela inicial do bugbank")
    public void que_o_usuario_esta_na_tela_inicial_do_bugbank() {
    }

    @Quando("o usuario clicar no botao de registrar")
    public void o_usuario_clicar_no_botao_de_registrar() {
    }

    @Então("devera ser exibido o formulario para o registro da conta do usuario")
    public void devera_ser_exibido_o_formulario_para_o_registro_da_conta_do_usuario() {
    }

    // Cenario 2
    @E("o usuario cria uma conta com o opcao de saldo ativada")
    public void o_usuario_cria_uma_conta_com_o_opcao_de_saldo_ativada() {

    }

    @Quando("o usuario preencher os campos de email e senha da conta recem criada")
    public void o_usuario_preencher_os_campos_de_email_e_senha_da_conta_recem_criada() {

    }

    @Então("devera ser exibida na tela inicial do bugbank com um saldo inicial de {string}")
    public void devera_ser_exibida_na_tela_inicial_do_bugbank_com_um_saldo_inicial_de(String string) {

    }

    // Cenario 3
    @E("o usuario cria uma conta com a opcao de saldo desativado")
    public void o_usuario_cria_uma_conta_com_a_opcao_de_saldo_desativado() {

    }

    @Entao("devera ser exibida na tela inicial do bugbank com um saldo inicial de zerado {string}")
    public void devera_ser_exibida_na_tela_inicial_do_bugbank_com_um_saldo_inicial_de_zerado(String string) {

    }
}
