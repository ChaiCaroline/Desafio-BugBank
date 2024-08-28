package com.bugbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bugbank.utils.PageObject;

public class ExtratoPage extends PageObject {

    public ExtratoPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonExtract() {
        driver.findElement(By.id("btn-EXTRATO")).click();
    }

    public WebElement extract() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='textBalanceAvailable']//..//..")));
    }

}
