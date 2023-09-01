package com.lambdatest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExceptionCatcher {

    private static RemoteWebDriver driver;
    private static String Status="failed";

    @BeforeSuite
    public void setup() throws MalformedURLException {

        try {
            String username = System.getenv("LT_USERNAME");
            String authkey = System.getenv("LT_ACCESS_KEY");
            String hub = "@hub.lambdatest.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("version", "86");
            caps.setCapability("platform", "MacOS Catalina");
            caps.setCapability("build", "LambdaException Demo");
            caps.setCapability("name", "Test 2");
            caps.setCapability("network", true);
            caps.setCapability("visual", true);
            caps.setCapability("video", true);
            caps.setCapability("console", true);


            System.out.println("Desired Caps: " + caps);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    @Test
    public static void testAssertionError() {

        ArrayList<String> exceptionCapture = new ArrayList<>();
        try {
            driver.get("https://www.lambdatest.com");

            String ExpectedTitle = "Most Powerful Cross Browser Testing Tool Online | LambdaT";
            String TitleValue = driver.getTitle();
            if (TitleValue.equals(ExpectedTitle)) {
                Status = "passed";
            }

            Assert.assertEquals(TitleValue, ExpectedTitle);
        } catch (AssertionError e) {
            Status = "failed";
            exceptionCapture.add(e.getMessage());
            ((JavascriptExecutor) driver).executeScript("lambda-exceptions", exceptionCapture);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}