package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class SumUpIOS {

    String userName = "leonardo.gallardo";
    String accessKey = "hZgvVEwvbYQcrPm5tlsTSFiQk8zpUHfOwkoXb6Z8QO7DGHOApu";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    IOSDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 14");
            ltOptions.put("platformVersion", "16");
            ltOptions.put("app", "lt://APP10160251801718379500589409");
            ltOptions.put("autoAcceptAlerts", false);
//            ltOptions.put("appPackage", "com.kaching.merchant.kiwi");
//            ltOptions.put("appActivity", "com.kaching.merchant.Activities.RegisterActivity");
        //    ltOptions.put("appiumVersion", "1.22.3");
            ltOptions.put("build", "summup-debug-ios");
            //ltOptions.put("auto", true);
            //ltOptions.put("resignApp", false);
            ltOptions.put("mitmProxy", true);
            ltOptions.put("appiumFolderPath", "2.2.1");
            ltOptions.put("automationName", "XCUITest");
            ltOptions.put("devicelog", true);
            ltOptions.put("idleTimeout", 900);

           // ltOptions.put("language", "en");
           // ltOptions.put("locale", "US");


            ltOptions.put("isRealMobile", true);

            //ltOptions.put("project", "ios");
            ltOptions.put("language", "en");
            ltOptions.put("locale", "en_US");
            //ltOptions.put("network", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            //HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.0.0");
//            //capabilities.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            //capabilities.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            capabilities.setCapability("app", "bs://6175107eb4b64ced9cf48d561712754f6359312e");
//            capabilities.setCapability("build", "build-summup");
//            capabilities.setCapability("name", "debug");
////            capabilities.setCapability("appPackage", "com.kaching.merchant.kiwi");
////            capabilities.setCapability("appActivity", "com.kaching.merchant.Activities.RegisterActivity");
//            capabilities.setCapability("platformName", "ios");
//            capabilities.setCapability("platformVersion", "15.0");
//            capabilities.setCapability("deviceName", "iPhone 13");
//            capabilities.setCapability("language", "en");
//            capabilities.setCapability("locale", "US");
//
//            capabilities.setCapability("interactiveDebugging", true);
////
//
//            driver = new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);
//
//

              //driver.activateApp("com.kaching.merchant.kiwi");




            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            Thread.sleep(3000);

            driver.findElementByAccessibilityId("OK").click();

            driver.findElementByIosClassChain("**/XCUIElementTypeAlert[`label == \"App update available\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]").click();




            WebElement loginBtn = driver.findElementByAccessibilityId("WelcomeContentLoginButton");

            // Create a TouchAction instance
            TouchAction action = new TouchAction(driver);

            // Perform a long press
            action.longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(loginBtn))
                            .withDuration(Duration.ofSeconds(2)))
                    .release()
                    .perform();


            driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"Staging\"`]").click();


            driver.findElementByAccessibilityId("Theta").click();

            driver.findElementByAccessibilityId("Close").click();


            driver.findElementByAccessibilityId("WelcomeContentLoginButton").click();

            driver.findElementByAccessibilityId("SMPPromptPrimaryButton").click();

            driver.findElementByAccessibilityId("Allow While Using App").click();


            driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
                    .sendKeys("pcu87.ca4b9ce3-3654-403f-ba1c-51c24aaab7cb@inbox.testmail.app");


            driver.findElementByXPath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[6]/XCUIElementTypeSecureTextField")
                    .sendKeys("12345678");


            driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Next\"])[1]").click();




            Thread.sleep(10000);









            //driver.closeApp();
            //driver.launchApp();


//            Map<String, Object> data1 = new HashMap<>();
//            data1.put("appPackage", "ca.qc.gouv.portefeuilleqc");
//
//            ((JavascriptExecutor) driver).executeScript("lambda-uninstall-app", data1);
//
//            Thread.sleep(3000);
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("appUrl", "lt://APP101602212171518452248248");
//
//
//            ((JavascriptExecutor) driver).executeScript("lambda-install-app=lt://APP1016022121715348835070846");
//
//            driver.activateApp("ca.qc.gouv.portefeuilleqc");


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }


    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }
}
