package com.ohrm.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= "src/Features",
        glue = "src/test/java/com/ohrm/stepdefinition",
        dryRun = false,
        plugin = {"pretty","html:src/Reports/CucumberReport.html"}

)
public class TestRunner {
}




