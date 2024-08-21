package com.bugbank.steps;

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
        extratoPage.createLocalStorage("chaiene@email.com", "123");
        loginPage.checkInputLogin("chaiene@email.com", "123");
        loginPage.clickButtonAcessar();
    }

    @E("esteja na tela inicial")
    public void esteja_na_tela_inicial() {
        System.out.println(extratoPage.currentPage());
    }

}
