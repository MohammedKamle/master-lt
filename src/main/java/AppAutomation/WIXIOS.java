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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class WIXIOS {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

  //  AppiumDriver driver;
    protected static ThreadLocal<IOSDriver> threadLocalDriver = new ThreadLocal<>();

    String argument = "{\"args\": [\"injected-cookie-wixSession2-JWT.eyJraWQiOiJrdU42YlJQRCIsImFsZyI6IlJTMjU2In0.eyJkYXRhIjoie1widXNlckd1aWRcIjpcIjM5MWYwMWM1LWE4ZjEtNDU5ZC05MDhlLTY3YWYwNzUwMjIzM1wiLFwidXNlck5hbWVcIjpcIlwiLFwiY29sb3JzXCI6e30sXCJ1Y2RcIjpcIjIwMjAtMTEtMjJUMjA6MjM6NDUuMDAwKzAwOjAwXCIsXCJ3eHNcIjpmYWxzZSxcImV3eGRcIjpmYWxzZSxcImFvclwiOnRydWUsXCJhY2lcIjpcIjM5MWYwMWM1LWE4ZjEtNDU5ZC05MDhlLTY3YWYwNzUwMjIzM1wiLFwicm1iXCI6ZmFsc2UsXCJsdmxkXCI6XCIyMDI0LTExLTA2VDA4OjMwOjU2LjQzNiswMDowMFwiLFwibGF0aFwiOlwiMjAyNC0xMS0wNlQwODozMDo1Ni4zNjIrMDA6MDBcIixcInd4ZXhwXCI6XCIyMDI0LTExLTIxVDA4OjMwOjU2LjQzNiswMDowMFwiLFwicGFjXCI6dHJ1ZSxcInNpZFwiOlwiNGIwYzAwZTMtNDY3ZS00MjBlLTljMjktNGJiNDAxMzkwZmEyXCJ9IiwiaWF0IjoxNzMwODgxODU2LCJleHAiOjE3MzIxNzc4NTZ9.lCzsNiqCKS8yVPKnuSe0We3-OpA8OINDobzEznSKXTeqXYQJ1q9rh2vl7b8Z3jWDAFnyea8A4eGQCRgpDTEFeA4g0RtU9ADD_UinK7IrFwI58sjpBFoPlj4ZTUITSQA6UxV2A70hrFsVdM7BHQn20LieE-_rpD-PXz8Mhz1DyI-lUXp74Qk_Kgc2NBdHkfrT9OMTgwRLg3UYsKRCMpM8W2LUe5WqTQgZ-GKMIZ2eGefKIySpIIFx64nwAL3YsqtoSLw8e4JgRCVdbw4BWhcjNnDbthqUug6bqTU5vmj9lPH3K1SDiBskAUQwhlEcsyl1EyV9HO_24JA7toG6nQfSfA\"]}";
    boolean isBS = false;

    //
    @Test(threadPoolSize = 20, invocationCount = 20)
    public  void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 15");
            ltOptions.put("platformVersion", "17");
            ltOptions.put("app", "lt://APP10160232211730883990347620");
            ltOptions.put("build", "wix-issue");
            ltOptions.put("autoAcceptAlerts", true);
            //ltOptions.put("appium:settings[acceptAlertButtonSelector]", "**/XCUIElementTypeButton[label == 'Allow Full Access']");
            ltOptions.put("processArguments", argument);
            ltOptions.put("appiumVersion", "2.2.1");


            ltOptions.put("devicelog", true);
            //ltOptions.put("network", true);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            threadLocalDriver.set(new IOSDriver<>(new URL(hub), capabilities));
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

            threadLocalDriver.get().findElementByAccessibilityId("SiteItem_ee267039-44e8-4473-8a05-8570e883c777").click();


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
