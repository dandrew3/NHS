package com.test.nhs.stepdefinitions;

import com.beust.ah.A;
import com.test.nhs.Utils.DriverHelper;
import com.test.nhs.pages.AddPatientPage;
import com.test.nhs.pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class AddPatientStepDef {


    WebDriver driver = DriverHelper.getDriver();
    AddPatientPage addPatientPage = new AddPatientPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("the user clicks the add patient button on the left side of the page")
    public void the_user_clicks_the_add_patient_button_on_the_left_side_of_the_page() {
        dashboardPage.clickAddPatientButton();
    }

    @Then("the user should be able to add patient details like {string}, {string}, {string}, {string}, {string}")
    public void the_user_should_be_able_to_add_patient_details_like(String firstName, String lastName, String hospitalNo, String dateOfBirth, String sex) throws InterruptedException {
        addPatientPage.addUser(driver, firstName, lastName, hospitalNo, dateOfBirth, sex);
    }

    @When("the user click the add patient button")
    public void the_user_click_the_add_patient_button() {
        addPatientPage.clickAddPatientButton();
    }

    @Then("the patient details {string}, {string}, and {string} should be displayed under Patients waiting card on main page")
    public void the_patient_details_and_should_be_displayed_under_patients_waiting_card_on_main_page(String firstName, String lastName, String hospitalNo) {
        dashboardPage.checkPatientDetailsInWaitingCards(firstName, lastName, hospitalNo);
    }


}
