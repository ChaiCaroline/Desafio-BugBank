package com.bugbank.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PageObject {

    public WebDriver driver;
    public WebDriverWait wait;

    public String urlBugBank = "https://bugbank.netlify.app/";

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String currentPage() {
        return driver.getCurrentUrl();
    }

    public int elementQuantity(String xpath) {
        return driver.findElements(By.xpath(xpath)).size();
    }

    public void createLocalStorage(String email, String password, String account) {
        LocalDate currentDate = LocalDate.now();

        // Formatar a data no formato "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        String registerKey = email;
        String registerUser = String.format(
                "{\"name\":\"Paula\",\"email\":\"%s\",\"password\":\"%s\",\"accountNumber\":\"%s\",\"balance\":1000,\"logged\":false}",
                email, password, account);
        String registerUser2 = String.format(
                "[{\"id\":\"3731ce63-9dcd-49bb-ab4b-6dcd82ae2415\",\"date\":\"%s\",\"type\":\"Abertura de conta\",\"transferValue\":1000,\"description\":\"Saldo adicionado ao abrir conta\"}]",
                formattedDate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("localStorage.setItem('%s', '%s');", registerKey, registerUser));
        js.executeScript(String.format("localStorage.setItem('%s', '%s');", "transaction:" + email, registerUser2));

        String storedValue = (String) js
                .executeScript(String.format("return localStorage.getItem('%s');", registerKey));
        System.out.println("Valor armazenado no localStorage: " + storedValue);
    }

}
