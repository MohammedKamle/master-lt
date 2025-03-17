package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class WIXAndroid {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    //  AppiumDriver driver;
    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();

    String argument = "--es injected-cookie JWT.eyJraWQiOiJrdU42YlJQRCIsImFsZyI6IlJTMjU2In0.eyJkYXRhIjoie1widXNlckd1aWRcIjpcIjM5MWYwMWM1LWE4ZjEtNDU5ZC05MDhlLTY3YWYwNzUwMjIzM1wiLFwidXNlck5hbWVcIjpcIlwiLFwiY29sb3JzXCI6e30sXCJ1Y2RcIjpcIjIwMjAtMTEtMjJUMjA6MjM6NDUuMDAwKzAwOjAwXCIsXCJ3eHNcIjpmYWxzZSxcImV3eGRcIjpmYWxzZSxcImFvclwiOnRydWUsXCJhY2lcIjpcIjM5MWYwMWM1LWE4ZjEtNDU5ZC05MDhlLTY3YWYwNzUwMjIzM1wiLFwicm1iXCI6ZmFsc2UsXCJsdmxkXCI6XCIyMDI0LTExLTA3VDEzOjQ4OjUzLjA3MiswMDowMFwiLFwibGF0aFwiOlwiMjAyNC0xMS0wN1QxMzo0ODo1My4wMDMrMDA6MDBcIixcInd4ZXhwXCI6XCIyMDI0LTExLTIyVDEzOjQ4OjUzLjA3MiswMDowMFwiLFwicGFjXCI6dHJ1ZSxcInNpZFwiOlwiZDkzMDgwNDItYzAwYi00NTljLWEyY2YtYmU1MjRmNWIzNTcxXCJ9IiwiaWF0IjoxNzMwOTg3MzMzLCJleHAiOjE3MzIyODMzMzN9.MXe7QZMr3CMUVfJQaXwHXkZIQQLpbiDBHY4mXgYKAv6lpy9REVqVRDE4tUXAq9NRnSxUJUI0CQfi26qooszG_IT_cZ7Hn9s3hBJgyMtRDqGJnI3GNncrMUxK4Boobtcf_g0y3w46VFVQqykK7ywkVv8aRq00W6LDeA0YXdAYxxLQCVId4p9eirCpkf57n1QnJSxpB8WB8HPzYWYncLXgeXF59bXJxJaIXaUAzb9z_A9xFZJt5sTx67qG_IFU3zDHj5drHnwdBIGYBmNY8yq8C-sQkJnhi3kXRokTiHkdYqD2HCO-6ME9mwsEdUmfLRWGhlwyGUZmmHwo_TTvpssSrA ";
    boolean isBS = false;

    //

    @Test(threadPoolSize = 4, invocationCount = 4)
    public  void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S23");
            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160162101730981669121155");
            ltOptions.put("build", "debug-api-3");
            ltOptions.put("autoGrantPermissions", true);
            //ltOptions.put("appium:settings[acceptAlertButtonSelector]", "**/XCUIElementTypeButton[label == 'Allow Full Access']");
            ltOptions.put("optionalIntentArguments", argument);
            ltOptions.put("appiumVersion", "2.0.0");


            ltOptions.put("devicelog", true);
            String testName = "Test-" + UUID.randomUUID().toString();
            ltOptions.put("name", testName);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            threadLocalDriver.set(new AndroidDriver(new URL(hub), capabilities));
            //driver = new IOSDriver(new URL(hub), capabilities);

//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("appiumVersion", "2.0.0");
//
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            bsCaps.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            bsCaps.setCapability("app", "bs://d8dd95a1d4643713b3bf6f3d73ea67b34ca2e048");
//            bsCaps.setCapability("build", "build-wix-flaky-test");
//            bsCaps.setCapability("name", "debug");
//            //bsCaps.setCapability("autoGrantPermissions", true);
//            bsCaps.setCapability("platformName", "ios");
//
//            isBS = true;
//            bsCaps.setCapability("platformVersion", "17.0");
//            bsCaps.setCapability("deviceName", "iPhone 15");
//            bsCaps.setCapability("autoAcceptAlerts", true);
//            bsCaps.setCapability("processArguments", argument);
//
//            bsCaps.setCapability("bstack:options", browserstackOptions);
//           // driver = new AndroidDriver(new URL(""), bsCaps);
//
//        String hub =     "http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub";
//
//            threadLocalDriver.set(new IOSDriver(new URL(hub), bsCaps));
////

            // threadLocalDriver.get().setSetting("acceptAlertButtonSelector", "**/XCUIElementTypeButton[label == 'Allow Full Access']");

            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            threadLocalDriver.get().findElement(By.xpath("//*[contains(@resource-id,\"SiteItem_\")]"));


//            threadLocalDriver.get().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Close\"]")).click();
//
//
//            threadLocalDriver.get().findElementByAccessibilityId("owners.profile.topBarAvatar.container").click();
//
//
//            threadLocalDriver.get().findElementByAccessibilityId("owners.profile.avatar").click();
//
//
//            threadLocalDriver.get().findElementByAccessibilityId("owners.edit-profile.screen.upload.image.button").click();
//
//            threadLocalDriver.get().findElementByAccessibilityId("owners.edit-profile.screen.upload.image.button").click();
//
//            threadLocalDriver.get().findElementByIosNsPredicate(" type == \"XCUIElementTypeButton\" AND name == \"Take Photo\"").click();


            //threadLocalDriver.get().findElementByAccessibilityId("Allow Full Access").click();

            // threadLocalDriver.get().setSetting("acceptAlertButtonSelector", "**/XCUIElementTypeButton[label == 'Allow Full Access']");

















            if (!isBS){
                threadLocalDriver.get().executeScript("lambda-status=passed");
            }


            threadLocalDriver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                if (!isBS){
                    threadLocalDriver.get().executeScript("lambda-status=failed");
                }
                threadLocalDriver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
