package com.test.nhs.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverHelper {
    //private variable
    private static WebDriver driver;

    //Private constructor to make sure they do not create an object from this class
    private DriverHelper() {
    }

    public static WebDriver getDriver() {
        if (driver == null) { //I'm checking driver whether it is null or not.
            //if driver is null I am going to create a new one
            //if not, it is not going to create a new Driver. It will use the existing(current) one.
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();//for fresh start
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //this implicitly will wait for the elements until element will be loaded (not more than 10 seconds).
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;

    }
}
