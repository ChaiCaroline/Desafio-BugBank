package com.bugbank.pages;

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

    public void registerForm(String name, String email, String password, boolean money) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("passwordConfirmation")).sendKeys(password);

        if (money) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggleAddBalance")));

            // Clique no elemento
            WebElement toggleAddBalance = driver.findElement(By.id("toggleAddBalance"));
            toggleAddBalance.click();
        }

        driver.findElement(By.xpath("//form")).submit();
    }

    public String balance() {
        return driver.findElement(By.id("textBalance")).getText();
    }

}
