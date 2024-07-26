package com.bugbank.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    private WebDriver driver;
    protected WebDriverWait wait;

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

    public void createLocalStorage(String email, String password) {
        String registerKey = email;
        String registerUser = String.format(
                "{\"name\":\"Paula\",\"email\":\"%s\",\"password\":\"%s\",\"accountNumber\":\"613-4\",\"balance\":1000,\"logged\":false}",
                email, password);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("localStorage.setItem('%s', '%s');", registerKey, registerUser));

        String storedValue = (String) js
                .executeScript(String.format("return localStorage.getItem('%s');", registerKey));
        System.out.println("Valor armazenado no localStorage: " + storedValue);
    }

}
