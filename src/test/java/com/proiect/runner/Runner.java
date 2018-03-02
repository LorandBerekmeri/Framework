package com.proiect.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions (features ="classpath:features",
        glue = "classpath:com/proiect/steps",
        plugin = {
            "pretty",
            "html:target/cucumber-html-report",
            "json:target/cucumber.json"},
        tags = {"@cucumber-test"}
)

public class Runner extends AbstractTestNGCucumberTests{

}

