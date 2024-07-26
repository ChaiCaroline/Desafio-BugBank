package com.bugbank.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bugbank.utils.PageObject;

public class LoginPage extends PageObject {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> checkInputLogin(String email, String password) {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return Arrays.asList(inputEmail, inputPassword);
    }

    public WebElement inputLogin(String email) {
        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys(email);

        return inputEmail;
    }

    public WebElement inputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys(password);

        return inputPassword;
    }

    public WebElement inputPasswordInformation() {
        WebElement inputPassword = driver.findElement(By.name("password"));
        return inputPassword;
    }

    public void clickButtonAcessar() {
        driver.findElement(By.xpath("//div[@class='login__buttons']/button")).click();
    }

    public void clickEyePassword() {
        driver.findElement(By.className("login__eye")).click();
    }

    public WebElement imageEyeInputPassword() {
        return driver.findElement(By.xpath("//button[@class='login__eye']//img[@decoding='async']"));
    }

    public WebElement nameUser() {
        return driver.findElement(By.id("textName"));
    }

    public WebElement formUserLogin() {
        return driver.findElement(By.className("card__login"));
    }

    public WebElement modalErrorLogin() {
        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Usuário ou senha inválido.')]")));
    }
}
