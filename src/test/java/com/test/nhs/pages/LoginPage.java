package com.test.nhs.pages;

import com.test.nhs.Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton;

    public Boolean userNameFieldIsEmpty() {
        return userName.getText().isEmpty() && password.getText().isEmpty();
    }

    public void userLogin(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
public void clickSignInButton(){
        signInButton.click();
}


}
