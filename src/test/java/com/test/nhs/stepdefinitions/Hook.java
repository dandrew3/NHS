package com.test.nhs.stepdefinitions;


import com.test.nhs.Utils.BrowserUtils;
import com.test.nhs.Utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hook {


    public WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotCucumber(scenario, driver);
        DriverHelper.tearDown();
    }
}
