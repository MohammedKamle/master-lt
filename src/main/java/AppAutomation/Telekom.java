package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Telekom {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    IOSDriver driver;

    @Test
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "ios");
//            ltOptions.put("deviceName", "iPhone.*");
//            //ltOptions.put("automationName", "UIAutomator2");
//            ltOptions.put("platformVersion", "13");
//            ltOptions.put("app", "lt://APP10160522261720078160208645");
//            //ltOptions.put("resignApp", false);
//            //ltOptions.put("appiumVersion", "1.22.3");
//            //ltOptions.put("timezone", "Belgium");
//            ltOptions.put("build", "telekom-debug");
//            //ltOptions.put("autoGrantPermission", true);
//            //ltOptions.put("smartUI.project", "md-rd-1");
//
//            // ltOptions.put("name", platform+" "+device+" "+version);
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("project", "android");
//            //ltOptions.put("region", "US");
////            ltOptions.put("language", "fr");
////            ltOptions.put("locale", "fr_FR");
//            ltOptions.put("network", false);
//
//            capabilities.setCapability("lt:options", ltOptions);
//            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

//            String hub = "http://" + userName + ":" + accessKey + gridURL;
           // driver = new IOSDriver(new URL(hub), capabilities);


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("build","Java TestNG Android");
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//            // capabilities.setCapability("deviceName", device);
//            //capabilities.setCapability("platformVersion",version);
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("isRealMobile", true);
//            //AppURL (Create from Wikipedia.apk sample in project)
//            capabilities.setCapability("app", "proverbialAndroid"); //Enter your app url
//            capabilities.setCapability("deviceOrientation", "PORTRAIT");
//            capabilities.setCapability("console", true);
//            capabilities.setCapability("network", true);
//            capabilities.setCapability("visual", true);
//            capabilities.setCapability("devicelog", true);
//            capabilities.setCapability("appProfiling", true);
//            capabilities.setCapability("geoLocation", "HK");



//          BS
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            //browserstackOptions.put("appiumVersion", "2.0.0");
            capabilities.setCapability("bstack:options", browserstackOptions);
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("platformVersion", "16");
//        capabilities.setCapability("deviceName", "iPhone 14");
            //capabilities.setCapability("browserstack.networkLogs", "true");
            //ios
//        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
            //android
            capabilities.setCapability("app", "bs://32bb0b55128f4a1296f3164379c0ab388ef136e6");
            capabilities.setCapability("build", "build-telekom-mdk");
            capabilities.setCapability("name", "debug");

            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("platformVersion", "16");
            capabilities.setCapability("deviceName", "iPhone 14");
            capabilities.setCapability("browserstack.resignApp", true);

            driver = new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);



            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeButton\" and ./parent::*[@name=\"OARadioButton\" and ./following-sibling::*[@name=\"English\"]]]")).click();

            driver.findElement(By.xpath("//*[@name=\"continueButton\"]")).click();

            driver.findElement(By.xpath("//*[@label=\"Mit Bestätigungscode als SMS anmelden\"]")).isDisplayed();

            driver.executeScript("lambda-status=passed");


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.executeScript("lambda-status=failed");
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
