package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Summup {

    String userName = "leonardo.gallardo";
    String accessKey = "hZgvVEwvbYQcrPm5tlsTSFiQk8zpUHfOwkoXb6Z8QO7DGHOApu";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel 7 Pro");
            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP101604581718285386022633");
            ltOptions.put("appPackage", "com.kaching.merchant.kiwi");
            ltOptions.put("appActivity", "com.kaching.merchant.Activities.RegisterActivity");
            ltOptions.put("appiumVersion", "1.22.3");
            ltOptions.put("build", "summup-debug");
            ltOptions.put("autoGrantPermission", true);
            ltOptions.put("devicelog", true);
            //ltOptions.put("resignApp", false);
            ltOptions.put("mitmProxy", true);


            ltOptions.put("isRealMobile", true);
            //ltOptions.put("project", "ios");
            //ltOptions.put("language", "fr");
            //ltOptions.put("locale", "fr_FR");
            ltOptions.put("network", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.0.0");
//            //capabilities.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            capabilities.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            capabilities.setCapability("app", "bs://94f03fdabf41e23359506ea5d4580849c5fe619e");
//            capabilities.setCapability("build", "build-summup");
//            capabilities.setCapability("name", "debug");
//            capabilities.setCapability("appPackage", "com.kaching.merchant.kiwi");
//            capabilities.setCapability("appActivity", "com.kaching.merchant.Activities.RegisterActivity");
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("platformVersion", "13.0");
//            capabilities.setCapability("deviceName", "Google Pixel 7 Pro");
//            capabilities.setCapability("interactiveDebugging", true);


          //  driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);



          //  driver.activateApp("com.kaching.merchant.kiwi");




            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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
}
