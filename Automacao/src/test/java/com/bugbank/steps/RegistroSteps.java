package com.bugbank.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bugbank.hooks.Hook;
import com.bugbank.pages.LoginPage;
import com.bugbank.pages.RegistroPage;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class RegistroSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegistroPage registroPage;
    private String urlBugBank = "https://bugbank.netlify.app/";

    // Cenario 1
    @Dado("que o usuario esta na tela inicial do bugbank")
    public void que_o_usuario_esta_na_tela_inicial_do_bugbank() {
        this.driver = Hook.getDriver(); // Obtém o WebDriver dos hooks
        this.loginPage = new LoginPage(driver); // Passa o WebDriver para o LoginPage
        loginPage.openUrl(urlBugBank);
        this.registroPage = new RegistroPage(driver);
    }

    @Quando("o usuario clicar no botao de registrar")
    public void o_usuario_clicar_no_botao_de_registrar() {
        registroPage.buttonRegister().click();
    }

    @Então("devera ser exibido o formulario para o registro da conta do usuario")
    public void devera_ser_exibido_o_formulario_para_o_registro_da_conta_do_usuario() {
        assertTrue(registroPage.formRegister().isDisplayed());
    }

    // Cenario 2
    @E("o usuario cria uma conta com o opcao de saldo ativada")
    public void o_usuario_cria_uma_conta_com_o_opcao_de_saldo_ativada() {
        registroPage.buttonRegister().click();
        registroPage.registerForm("Chaiene", "chaiene@email.com", "123", true);
    }

    @Quando("o usuario preencher os campos de email e senha da conta recem criada")
    public void o_usuario_preencher_os_campos_de_email_e_senha_da_conta_recem_criada() {
        registroPage.buttonClosedModal().click();
        loginPage.checkInputLogin("chaiene@email.com", "123");
        loginPage.clickButtonAcessar();
    }

    @Então("devera ser exibida na tela inicial do bugbank com um saldo inicial de {string}")
    public void devera_ser_exibida_na_tela_inicial_do_bugbank_com_um_saldo_inicial_de(String value) {
        assertTrue(registroPage.balance().contains(value));
    }

    // Cenario 3
    @E("o usuario cria uma conta com a opcao de saldo desativado")
    public void o_usuario_cria_uma_conta_com_a_opcao_de_saldo_desativado() {
        registroPage.buttonRegister().click();
        registroPage.registerForm("Chaiene", "chaiene@email.com", "123", false);

    }

    @Entao("devera ser exibida na tela inicial do bugbank com um saldo inicial zerado {string}")
    public void devera_ser_exibida_na_tela_inicial_do_bugbank_com_um_saldo_inicial_zerado(String value) {
        assertTrue(registroPage.balance().contains(value));
    }

    // Cenario 4
    @E("o usuario clica em registrar")
    public void o_usuario_clica_em_registrar() {
        registroPage.buttonRegister().click();
    }

    @Dado("que o usuario nao tenha preenchido nenhum campo")
    public void que_o_usuario_nao_tenha_preenchido_nenhum_campo() {
        registroPage.registerForm("", "", "", false);
    }

    @Quando("o usuario clicar em cadastrar")
    public void o_usuario_clicar_em_cadastrar() {

    }

    @Então("devera ser retornado em tela uma mensagem campo e obrigatorio")
    public void devera_ser_retornado_em_tela_uma_mensagem_campo_e_obrigatorio() {
        assertTrue(registroPage.messageError("É campo obrigatório").isDisplayed());
    }

    // Cenario 5
    @Quando("o usuario tiver preenchindo o campo de email com um email invalido {string}")
    public void o_usuario_tiver_preenchindo_o_campo_de_email_com_um_email_invalido(String emailInvalid) {
        registroPage.registerForm("Chaiene", emailInvalid, "123", false);
    }

    @Então("devera ser exibida uma mensagem de erro")
    public void devera_ser_exibida_uma_mensagem_de_erro() {
        assertTrue(registroPage.messageError("Formato inválido").isDisplayed());
    }

    // Cenario 6
    @Quando("o usuario preencher o campo de email com um email valido {string}")
    public void o_usuario_preencher_o_campo_de_email_com_um_email_valido(String email) {
        registroPage.registerForm("chaiene", email, "", false);
    }

    @Então("nao deve ser retornado para o usuario nenhuma mensagem de erro")
    public void nao_deve_ser_retornado_para_o_usuario_nenhuma_mensagem_de_erro() {
        assertNull(registroPage.messageError("Formato inválido"));
    }

    // Cenario 7
    @E("o usuario digitou um email valido {string}")
    public void o_usuario_digitou_um_email_valido(String email) {
        registroPage.registerForm("", email, "123", false);
    }

    @Então("devera ser exibido uma mensagem de campo nome obrigatorio")
    public void devera_ser_exibido_uma_mensagem_de_campo_nome_obrigatorio() {
        assertTrue(registroPage.modalMessageName().isDisplayed());
    }

    // Cenario 8
    @E("o usuario preencheu o nome")
    public void o_usuario_preencheu_o_nome() {

    }

    @Então("devera ser exibido uma mensagem de campo obrigatorio")
    public void devera_ser_exibido_uma_mensagem_de_campo_obrigatorio() {

    }

    // // Cenario 9
    // @E("o usuario preencheu uma senha")
    // public void o_usuario_preencheu_uma_senha() {
    // }

    // @E("o usuario digitou uma senha diferente no campo de confirmacao de senha")
    // public void
    // o_usuario_digitou_uma_senha_diferente_no_campo_de_confirmacao_de_senha() {
    // }

    // @Então("devera ser exibida uma mensagem de erro indicando que as senhas nao
    // coincidem")
    // public void
    // devera_ser_exibida_uma_mensagem_de_erro_indicando_que_as_senhas_nao_coincidem()
    // {
    // }

    // // Cenario 10
    // @Quando("o usuario clicar no botao criar conta com saldo")
    // public void o_usuario_clicar_no_botao_criar_conta_com_saldo() {
    // }

    // @Então("o botao criar conta com saldo devera ser habilitado")
    // public void o_botao_criar_conta_com_saldo_devera_ser_habilitado() {
    // }
}
