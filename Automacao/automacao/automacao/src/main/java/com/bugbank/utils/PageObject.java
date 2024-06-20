package com.bugbank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject {

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
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

}
