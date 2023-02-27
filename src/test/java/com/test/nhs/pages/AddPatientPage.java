package com.test.nhs.pages;

import com.test.nhs.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddPatientPage {

    public AddPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "hospitalNumber")
    WebElement hospitalNo;

    @FindBy(name = "dateOfBirth")
    WebElement dataOfBirth;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> sexRadioButtons;

    @FindBy(xpath = "//input[@name='Submit']")
    WebElement addPatientButton;

    public void addUser(WebDriver driver, String firstName, String lastName, String hospitalNo, String dataOfBirth, String sex) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.hospitalNo.sendKeys(hospitalNo);
        this.dataOfBirth.sendKeys(dataOfBirth);
        for (WebElement sexBut : sexRadioButtons) {
            if (sexBut.getAttribute("value").startsWith(sex)) {
                BrowserUtils.ClickWithJS(driver, sexBut);
                break;
            }
        }
    }

    public void clickAddPatientButton() {
        addPatientButton.click();
    }

}
