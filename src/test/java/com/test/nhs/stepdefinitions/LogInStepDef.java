package com.test.nhs.stepdefinitions;

import com.test.nhs.Utils.ConfigReader;
import com.test.nhs.Utils.DriverHelper;
import com.test.nhs.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LogInStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User navigate to the website")
    public void user_navigate_to_the_website() {
        driver.get(ConfigReader.readProperty("NHS_url"));
    }

    @Given("The fields password and username are empty")
    public void the_fields_password_and_username_are_empty() {
        Assert.assertTrue(loginPage.userNameFieldIsEmpty());
    }

    @When("User enters valid userName and valid Password")
    public void user_enters_valid_user_name_and_valid_password() {
        loginPage.userLogin("admin", "admin");
    }

    @Then("User should be at the {string} page")
    public void user_should_be_at_the_page(String expectedTitle) {
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credential(DataTable dataTable) {
        List<String> validCredentials = dataTable.asList();
        loginPage.userLogin(validCredentials.get(0), validCredentials.get(1));

    }

}
