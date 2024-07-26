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

}
