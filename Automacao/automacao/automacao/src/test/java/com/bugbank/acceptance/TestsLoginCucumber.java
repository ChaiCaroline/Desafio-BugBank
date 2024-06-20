package com.bugbank.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports" }, // Plugins para relatórios
                glue = { "com.bugbank.steps", "com.bugbank.hooks" }, // Pacote onde estão as definições de steps
                features = { "classpath:com/bugbank/features" }, // Caminho para as features
                tags = "@login") // Tags para filtrar os testes
public class TestsLoginCucumber {

}
