package com.bugbank.pages;

import org.openqa.selenium.WebDriver;

import com.bugbank.utils.PageObject;

public class RegistroPage extends PageObject {
    private WebDriver driver;

    public RegistroPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
