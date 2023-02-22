package com.test.nhs.stepdefinitions;

import com.test.nhs.Utils.ConfigReader;
import com.test.nhs.Utils.DriverHelper;
import com.test.nhs.pages.DashboardPage;
import com.test.nhs.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LogInStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    DashboardPage dashboardPage = new DashboardPage(driver);

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
        Assert.assertEquals("NHS patients", driver.getTitle().trim());
    }

    @When("the user enters the invalid credentials {string} and {string}")
    public void the_user_enters_the_invalid_credentials_and(String userName, String password) {
        loginPage.userLogin(userName, password);
    }

    @When("the user enters the credentials {string} and {string}")
    public void the_user_enters_the_credentials_and(String userName, String password) {
        loginPage.userLogin(userName, password);
    }
    ////////////////////////DASHBOARD PAGE//////////////////////////////////////////

    @When("the user successfully loges in")
    public void the_user_successfully_loges_in() {
        loginPage.userLogin(ConfigReader.readProperty("userName"), ConfigReader.readProperty("userPassword"));
        loginPage.clickSignInButton();
        Assert.assertEquals("NHS patients", driver.getTitle().trim());

    }

    @When("amount of rooms are {int}")
    public void amount_of_rooms_are(Integer expectedAmountOfRooms) {
        Assert.assertEquals(expectedAmountOfRooms, dashboardPage.actualAmountOfRoom());
    }

    @Then("the rooms should be display on the page")
    public void the_rooms_should_be_display_on_the_page() {
        for (WebElement room : dashboardPage.getRooms()) {
            Assert.assertTrue(room.isDisplayed());
        }
    }

    @When("{int} Patient Cards is visible for user")
    public void patient_cards_is_visible_for_user(int expectedPatientCards) {
        Assert.assertEquals(expectedPatientCards, dashboardPage.getPatientCards().size());

    }

    @When("information of patients with rooms is displayed")
    public void information_of_patients_with_rooms_is_displayed() {
        for (WebElement info : dashboardPage.getInformationOfPatientsWithRooms()){
            Assert.assertTrue(info.isDisplayed());
        }
    }

    @Then("headers of Patients with rooms has the right information")
    public void headers_of_patients_with_rooms_has_the_right_information(DataTable dataTable) {
        List<String> expectedHeaders = dataTable.asList();
        List<WebElement> actualHeadersOfPatientWithRoomsCard = dashboardPage.getActualHeadersOfPatientWithRoomsCard();
        for (int i = 0; i < actualHeadersOfPatientWithRoomsCard.size(); i++){
            Assert.assertEquals(expectedHeaders.get(i),actualHeadersOfPatientWithRoomsCard.get(i).getText().trim());
            System.out.println(expectedHeaders.get(i));
            System.out.println(actualHeadersOfPatientWithRoomsCard.get(i).getText().trim());
        }
    }


}
