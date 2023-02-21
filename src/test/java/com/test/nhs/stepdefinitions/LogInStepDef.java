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

    @Given("the user navigates to the NHS website")
    public void the_user_navigates_to_the_nhs_website() {
        driver.get(ConfigReader.readProperty("NHS_url"));
    }

    @Given("The fields password and username are empty")
    public void the_fields_password_and_username_are_empty() {
        Assert.assertTrue(loginPage.userNameFieldIsEmpty());
    }

    @Given("user validates the url of the page")
    public void user_validates_the_url_of_the_page() {
        Assert.assertEquals(ConfigReader.readProperty("NHS_url"), driver.getCurrentUrl());
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials(DataTable dataTable) {
        List<String> validCredentials = dataTable.asList();
        loginPage.userLogin(validCredentials.get(0), validCredentials.get(1));
    }

    @When("the user clicks the SignIn button")
    public void the_user_clicks_the_sign_in_button() throws InterruptedException {
        loginPage.clickSignInButton();
    }

    @Then("The user should validate the title")
    public void the_user_should_validate_the_title() {
        Assert.assertEquals("NHS patients", driver.getTitle());
    }

    @When("the user enters the invalid credentials {string} and {string}")
    public void the_user_enters_the_invalid_credentials_and(String userName, String password) {
        loginPage.userLogin(userName, password);
    }

    @When("the user enters the credentials {string} and {string}")
    public void the_user_enters_the_credentials_and(String userName, String password) {
        loginPage.userLogin(userName, password);
    }


}
