package com.bugbank.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bugbank.utils.PageObject;

public class RegistroPage extends PageObject {
    private WebDriver driver;

    public RegistroPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement buttonRegister() {
        return driver.findElement(By.xpath("//div[@class='login__buttons']/button[text()='Registrar']"));
    }

    public WebElement formRegister() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card__register")));
    }

    public WebElement buttonClosedModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btnCloseModal']/../..")));
        return driver.findElement(By.id("btnCloseModal"));
    }

    public void registerForm(String name, String email, String password, boolean money) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='email']")))
                .sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys(name);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='password']")))
                .sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwordConfirmation"))).sendKeys(password);

        if (money) {
            System.out.println("Entrou aqui dentro do money");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='toggleAddBalance']//..")));

            // Clique no elemento
            WebElement toggleAddBalance = driver.findElement(By.xpath("//label[@id='toggleAddBalance']//.."));
            toggleAddBalance.click();
        }

        driver.findElement(By.xpath("//div[@class='card__register']//button[@type='submit']")).click();
    }

    public WebElement messageError(String messageError) {
        List<WebElement> elements = driver.findElements(By.xpath("//p[contains(text(), '" + messageError + "')]"));
        if (elements.isEmpty()) {
            return null;
        } else {
            return elements.get(0);
        }
    }

    public WebElement modalMessageName() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Nome não pode ser vazio.')]/../..")));
    }

    public String balance() {
        return driver.findElement(By.id("textBalance")).getText();
    }

}
