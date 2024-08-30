package com.bugbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public void clickButtonTransfer() {
        driver.findElement(By.id("btn-TRANSFERÊNCIA")).click();
    }

    public void transfer(String account, String digit, String value) {
        driver.findElement(By.name("accountNumber")).sendKeys(account);
        driver.findElement(By.name("digit")).sendKeys(digit);
        driver.findElement(By.name("transferValue")).sendKeys(value);
        driver.findElement(By.xpath("//form")).submit();
    }

    public void buttonClosedModalExtract() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCloseModal"))).click();
    }

    public void buttonBackHome() {
        driver.findElement(By.id("btnBack")).click();
    }

    public String lastTransfer() {
        return driver
                .findElement(
                        By.xpath("//div[contains(@class, 'fCYQeb')]/div[last()]/div[2]/p[@id='textTransferValue']"))
                .getText();
    }

    public String lastTransferElement() {
        return wait
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'fCYQeb')]/div[last()]/div[2]/p[@id='textTransferValue']")))
                .getAttribute("type");
    }

    public void createTransfer(String email, String value) {
        String registerTransfer = String.format(
                "{\"id\": \"5c490a0b-a9d8-487e-86d6-bdc9505bf254\","
                        + "\"date\": \"28/08/2024\","
                        + "\"type\": \"input\","
                        + "\"transferValue\": %s,"
                        + "\"description\": \"\"}",
                value);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String transactions = (String) js.executeScript("return localStorage.getItem('transaction:" + email + "');");
        String updatedTransactions = String.format(
                "let transactions = JSON.parse('%s'); transactions.push(%s); return JSON.stringify(transactions);",
                transactions, registerTransfer);
        String finalTransactions = (String) js.executeScript(updatedTransactions);

        js.executeScript(String.format("localStorage.setItem('%s', '%s');", "transaction:" + email, finalTransactions));
    }

}
