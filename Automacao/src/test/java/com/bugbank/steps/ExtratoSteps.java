package com.bugbank.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.bugbank.hooks.Hook;
import com.bugbank.pages.ExtratoPage;
import com.bugbank.pages.LoginPage;

import io.cucumber.java.pt.*;

public class ExtratoSteps {
    private LoginPage loginPage;
    private ExtratoPage extratoPage;

    // Contexto

    @Dado("que usuario esta na tela inicial do Bugbank")
    public void que_usuario_esta_na_tela_inicial_do_Bugbank() {
        this.loginPage = new LoginPage(Hook.getDriver());
        this.extratoPage = new ExtratoPage(Hook.getDriver());
        extratoPage.openUrl(extratoPage.urlBugBank);
    }

    @E("o usuario tenha preenchido os campos de email e senha validos")
    public void o_usuario_tenha_preenchido_os_campos_de_email_e_senha_validos() {
        extratoPage.createLocalStorage("chaiene@email.com", "123", "850-4");
        extratoPage.createLocalStorage("terezinha@email.com", "123", "101-2");
        loginPage.checkInputLogin("chaiene@email.com", "123");
        loginPage.clickButtonAcessar();
    }

    @E("esteja na tela inicial")
    public void esteja_na_tela_inicial() {
        loginPage.nameUser();
        assertTrue(extratoPage.currentPage().equals("https://bugbank.netlify.app/home"));
    }

    // Cenario 1

    @Quando("o usuario clicar no botao de Extrato")
    public void o_usuario_clicar_no_botao_de_extrato() {
        extratoPage.clickButtonExtract();
    }

    @Entao("devera ser redirecionado para a tela de extrato")
    public void devera_ser_redirecionado_para_a_tela_de_extrato() {

        extratoPage.extract();
        assertTrue(extratoPage.currentPage().equals("https://bugbank.netlify.app/bank-statement"));
    }

    // Cenario 2
    @E("o usuario ja tenha realizado uma transferencia para outra conta")
    public void o_usuario_ja_tenha_realizado_uma_transferencia_para_outra_conta() {
        extratoPage.clickButtonTransfer();
        extratoPage.transfer("101", "2", "100");
        extratoPage.buttonClosedModalExtract();
        extratoPage.buttonBackHome();
    }

    @Entao("deverao ser exibidas na tela todas as transferencias realizadas pelo usuario")
    public void deverao_ser_exibidas_na_tela_todas_as_transferencias_realizadas_pelo_usuario() {
        assertTrue(extratoPage.lastTransfer().contains("100"));
    }

    // Cenario 3
    @E("o usuario ja tenha recebido uma transferencia")
    public void o_usuario_ja_tenha_recebido_uma_transferencia() {
        extratoPage.createTransfer("chaiene@email.com", "100");
    }

    @Entao("deverão ser exibidas na tela todas as transferencias recebidas pelo usuario")
    public void deverão_ser_exibidas_na_tela_todas_as_transferencias_recebidas_pelo_usuario() {
        assertTrue(extratoPage.lastTransfer().contains("100"));
        assertEquals("input", extratoPage.lastTransferElement());
    }

}
