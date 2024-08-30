package com.bugbank.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bugbank.hooks.Hook;
import com.bugbank.pages.LoginPage;

import io.cucumber.java.pt.*;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    // Cenário 1
    @Dado("que o usuario esta na tela inicial do BugBank")
    public void que_o_usuario_esta_na_tela_inicial_do_bug_bank() {
        this.driver = Hook.getDriver(); // Obtém o WebDriver dos hooks
        this.loginPage = new LoginPage(driver); // Passa o WebDriver para o LoginPage
        loginPage.openUrl(loginPage.urlBugBank);
    }

    @E("que o usuario nao tenha preenchido o email e a senha")
    public void que_o_usuario_nao_tenha_preenchido_o_email_e_a_senha() {
        List<WebElement> dataInputs = loginPage.checkInputLogin("", "");
        assertTrue(dataInputs.get(0).getText().isEmpty());
        assertTrue(dataInputs.get(1).getText().isEmpty());
    }

    @Quando("o usuario ao clicar no botao de acessar")
    public void o_usuario_ao_clicar_no_botao_de_acessar() {
        loginPage.clickButtonAcessar();
    }

    @Entao("devera ser exibida uma mensagem de erro com o texto preencha os campos")
    public void devera_ser_exibida_uma_mensagem_de_erro_com_o_texto_preencha_os_campos() {
        assertTrue(loginPage.elementQuantity("//p[contains(text(), 'É campo obrigatório')]") > 1);
    }

    // Cenário 2
    @Quando("o usuario preencher o campo de email com um email invalido {string}")
    public void oUsuarioPreencherOCampoDeEmailComUmEmailInvalido(String email) {
        loginPage.checkInputLogin(email, "");
    }

    @Então("devera ser exibida uma mensagem de erro com o texto email invalido")
    public void devera_ser_exibida_uma_mensagem_de_erro_com_o_texto_email_invalido() {
        assertTrue(loginPage.elementQuantity("//p[contains(text(), 'Formato inválido')]") == 1);
    }

    // Cenário 3
    @E("o usuario tenha preenchido com um email valido {string}")
    public void o_usuario_tenha_preenchido_com_um_email_valido(String email) {
        loginPage.inputLogin(email);
    }

    @Então("nao deve ser retornado para o usuario nenhuma mensagem de erro no campo email")
    public void nao_deve_ser_retornado_para_o_usuario_nenhuma_mensagem_de_erro_no_campo_email() {
        assertTrue(loginPage.elementQuantity("//p[contains(text(), 'É campo obrigatório')]") == 1);
    }

    // Cenário 4
    @E("nao tenha preenchido nenhuma senha")
    public void nao_tenha_preenchido_nenhuma_senha() {
        loginPage.inputPassword("");
    }

    @Entao("devera ser apresentado ao usuario uma mensagem de erro com o texto campo senha obrigatorio")
    public void devera_ser_apresentado_ao_usuario_uma_mensagem_de_erro_com_o_texto_campo_senha_obrigatorio() {
        assertTrue(loginPage.elementQuantity("//p[contains(text(), 'É campo obrigatório')]") == 1);
    }

    @Entao("o usuario deve permanecer na tela de login")
    public void o_usuario_deve_permanecer_na_tela_de_login() {
        loginPage.currentPage().equals(loginPage.urlBugBank);
    }

    // Cenário 5
    @E("tenha preechido com uma senha")
    public void tenha_preechido_com_uma_senha() {
        loginPage.inputPassword("123");
    }

    @Quando("o usuario clicar no ícone de olho no campo de senha")
    public void o_usuario_clicar_no_ícone_de_olho_no_campo_de_senha() {
        loginPage.clickEyePassword();
    }

    @Entao("devera ser exibido para o usuario a senha digitada")
    public void devera_ser_exibido_para_o_usuario_a_senha_digitada() {
        loginPage.inputPasswordInformation().getAttribute("type").equals("text");
    }

    @E("devera ser alterado o ícone de olho no campo de senha")
    public void devera_ser_alterado_o_ícone_de_olho_no_campo_de_senha() {
        loginPage.imageEyeInputPassword().getAttribute("alt").equals("Icon Open Eye");
    }

    // Cenário 6
    @E("que o usuario tenha preenchido com um {string} e a {string} valido")
    public void que_o_usuario_tenha_preenchido_com_uma_email_e_a_senha_valido(String email, String password) {
        loginPage.createLocalStorage(email, password, "850-4");
        loginPage.checkInputLogin(email, password);
    }

    @Entao("o usuario devera ser redirecionado para a tela inicial BugBank")
    public void o_usuario_devera_ser_redirecionado_para_a_tela_inicial_bug_bank() {
        loginPage.currentPage().equals("https://bugbank.netlify.app/home");
    }

    @E("deve ser apresentado as informacoes relacionadas ao usuario")
    public void deve_ser_apresentado_as_informacoes_relacionadas_ao_usuario() {
        assertTrue(loginPage.nameUser().isDisplayed());
    }

    // Cenário 7
    @E("o usuario nao esta logado no BugBank")
    public void o_usuario_nao_esta_logado_no_bug_bank() {
        assertTrue(loginPage.formUserLogin().isDisplayed());
    }

    @Quando("o usuario tentar acessar a pagina atraves da url {string}")
    public void o_usuario_tentar_acessar_a_pagina_atraves_da_url(String url) {
        loginPage.openUrl(url);
    }

    @Entao("o usuario deve permanecer na tela inicial pois nao esta logada")
    public void o_usuario_deve_permanecer_na_tela_inicial_pois_nao_esta_logada() {
        assertTrue(loginPage.currentPage().equals(loginPage.urlBugBank));
    }

    // Cenario 8
    @E("o usuario digitou um email nao cadastrado")
    public void o_usuario_digitou_um_email_nao_cadastrado() {
        loginPage.inputLogin("emailinvalido@email.com");
    }

    @Entao("devera ser exibida ao usuario uma mensagem de email ou senha invalidos")
    public void devera_ser_exibida_ao_usuario_uma_mensagem_de_email_ou_senha_invalidos() {
        assertTrue(loginPage.modalErrorLogin().isDisplayed());
    }
}
