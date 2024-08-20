package com.bugbank.pages;

import org.openqa.selenium.WebDriver;

import com.bugbank.utils.PageObject;

public class ExtratoPage extends PageObject {
    private WebDriver driver;

    public ExtratoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
