package com.test.nhs.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/addPatient.feature",
        glue = "com/test/nhs/stepdefinitions",
        dryRun = false,
        tags = "@Smoke",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)



public class AddPatientRunner {
}
