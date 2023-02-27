package com.test.nhs.pages;

import com.test.nhs.Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class DashboardPage {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "patientsInRooms")
    WebElement patientWithRoom;

    @FindBy(xpath = "//div[@class='panel panel-red']")
    WebElement patientWaitingRoom;

    @FindBy(xpath = "//div[@class='panel panel-orange']")
    WebElement freeRooms;

    @FindBy(xpath = "//div[@class='panel-heading']")
    List<WebElement> rooms;

    @FindBy(xpath = "//table[@id='patients-in-hospital']//td")
    List<WebElement> informationOfPatientsWithRooms;
    @FindBy(xpath = "//div[@class='dataTables_wrapper form-inline dt-bootstrap no-footer']")
    List<WebElement> patientCards;

    @FindBy(xpath = "//th[@tabindex='0' and @aria-controls='patients-in-hospital']")
    List<WebElement> actualHeadersOfPatientWithRoomsCard;

    @FindBy(xpath = "//a[contains(text(),'  Add patient')]")
    WebElement addPatientMenuButton;

    @FindBy(xpath = "//table[@id='patients-waiting']//tr[@role='row']")
    List<WebElement> patientInformationInPatientWaitingRoom;

    public List<WebElement> getActualHeadersOfPatientWithRoomsCard() {
        return actualHeadersOfPatientWithRoomsCard;
    }

    public Integer actualAmountOfRoom() {
        return rooms.size();
    }

    public List<WebElement> getRooms() {
        return rooms;
    }

    public List<WebElement> getPatientCards() {
        return patientCards;
    }

    public List<WebElement> getInformationOfPatientsWithRooms() {
        return informationOfPatientsWithRooms;
    }

    public void clickAddPatientButton() {
        addPatientMenuButton.click();
    }

    public void checkPatientDetailsInWaitingCards(String expectedFirstName, String expectedLastName, String expectedHospitalNo) {
        for (WebElement patient : patientInformationInPatientWaitingRoom) {
            String actualPatientInfo = BrowserUtils.getTextMethod(patient);

            if (actualPatientInfo.startsWith(expectedHospitalNo)) {
                Assert.assertTrue(patient.isDisplayed());
                Assert.assertTrue(actualPatientInfo.contains(expectedHospitalNo+" "+expectedFirstName+" "+expectedLastName));


            }
        }
    }

}
