package com.test.nhs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public Integer actualAmountOfRoom() {
        return rooms.size();
    }

    public List<WebElement> getRooms() {
        return rooms;
    }


}
