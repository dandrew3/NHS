package com.test.nhs.Utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {
    //WE CREATE BROWSERUTILS TO BE ABLE TO CALL REUSABLE METHODS FROM HERE TO REDUCE AMOUNT OF THE CODES.
    public static void selectBy(WebElement element, String value, String mehtodName) {
        Select select = new Select(element);

        switch (mehtodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                System.out.println("Method name is not available, Use text,value,index");


        }
    }

    public static String getTextMethod(WebElement element) {

        return element.getText().trim();
    }

    public static String GetTitleWithJS(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title").toString();
        return title;
    }

    public static void ClickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public static void ScrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void ScrollWithXandYCord(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point location = element.getLocation();
        int xCord = location.getX();
        int yCord = location.getY();
        js.executeScript("window.scrollBy(" + xCord + "," + yCord + ")");
    }

    public static void SwitchTwoTabs(WebDriver driver, String mainPageId) {
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
    }

    //it real work this will help you a lot once you test difference tabs or windows.
    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPages = driver.getWindowHandles();
        for (String id : allPages) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    public static void getScreenshot(WebDriver driver, String packageName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir") + "/src/java/screnshot" + packageName;

        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getScreenShotCucumber(Scenario scenario, WebDriver driver){
        Date currentDate = new Date();
        String screenShotFileName=currentDate.toString().replace(" ","-")
                .replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
