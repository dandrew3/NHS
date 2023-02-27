package com.test.nhs.stepdefinitions;

import com.test.nhs.Utils.ConfigReader;
import com.test.nhs.Utils.DriverHelper;
import com.test.nhs.pages.DashboardPage;
import com.test.nhs.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DashboardStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

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
        for (WebElement info : dashboardPage.getInformationOfPatientsWithRooms()) {
            Assert.assertTrue(info.isDisplayed());
        }
    }

    @Then("headers of Patients with rooms has the right information")
    public void headers_of_patients_with_rooms_has_the_right_information(DataTable dataTable) {
        List<String> expectedHeaders = dataTable.asList();
        List<WebElement> actualHeadersOfPatientWithRoomsCard = dashboardPage.getActualHeadersOfPatientWithRoomsCard();
        for (int i = 0; i < actualHeadersOfPatientWithRoomsCard.size(); i++) {
            Assert.assertEquals(expectedHeaders.get(i), actualHeadersOfPatientWithRoomsCard.get(i).getText().trim());
            System.out.println(expectedHeaders.get(i));
            System.out.println(actualHeadersOfPatientWithRoomsCard.get(i).getText().trim());
        }
    }

}
