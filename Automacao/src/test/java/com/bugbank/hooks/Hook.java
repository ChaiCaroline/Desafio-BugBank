package com.bugbank.hooks;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    private static WebDriver driver;

    @Before
    public void setup() {
        if (driver == null) {
            try {
                // google chrome
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();

                // edge
                // EdgeOptions options = new EdgeOptions();
                // options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                // driver = new EdgeDriver(options);
                // driver.manage().window().maximize();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            } catch (Exception e) {
                throw new RuntimeException("Falha ao inicializar o WebDriver: " + e.getMessage(), e);
            }
        }
    }

    @After
    public void close(Scenario cenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException(
                    "O WebDriver não foi inicializado. Certifique-se de que o setup() foi chamado antes de obter o driver.");
        }
        return driver;
    }
}
