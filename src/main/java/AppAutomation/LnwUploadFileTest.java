package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class LnwUploadFileTest {

    String userName = "mkamle86";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test()
    public void iOSApp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");
            ltOptions.put("platformVersion", "15");
            ltOptions.put("app", "lt://APP1016049361738049134700260");
            //ltOptions.put("appiumVersion", "2.2.1");
            ltOptions.put("build", "vacinity-debug");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", false);

            ltOptions.put("uploadMedia", Arrays.asList("lt://MEDIA1d170e075ce74db791ee3ed336197760"));
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            // browserstackOptions.put("appiumVersion", "2.4.1");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            //bsCaps.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            bsCaps.setCapability("app", "bs://91fd0a430512cd5e19620cc1b7f061ef5edafd18");
//            bsCaps.setCapability("build", "build-lnw");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoGrantPermissions", true);
//            bsCaps.setCapability("platformName", "ios");
//            bsCaps.setCapability("platformVersion", "17");
//            bsCaps.setCapability("deviceName", "iPhone.*");
//            bsCaps.setCapability("interactiveDebugging", true);
//            bsCaps.setCapability("browserstack.uploadMedia", new String[]{"media://374c1ded10daf837535dac3732ce4c7f939a6955"});
//
//
//            driver = new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//




            Thread.sleep(3000);


           // driver.pushFile("@com.vancity.onlinebankingapp.prevcomptest:Documents/mohammed_dp.jpg", new File("/Users/mohammadk/Downloads/mohammed_dp.jpeg"));


            driver.terminateApp("com.vancity.onlinebankingapp.prevcomptest");

            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeImage[6]")).getText());

            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeImage[6]")).getAttribute("name"));

            //System.out.println(driver.getPageSource());





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

//    @Test()
//    public void androidApp() {
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Galaxy S24.*");
//            //ltOptions.put("platformVersion", "11");
//            ltOptions.put("app", "lt://APP10160611311736435315518588");
//            //ltOptions.put("appiumVersion", "2.2.1");
//            ltOptions.put("build", "lnw-debug");
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("network", false);
//            ltOptions.put("uploadMedia", Arrays.asList("lt://MEDIA1a842a153e3545eea48a25270300a247"));
//            capabilities.setCapability("lt:options", ltOptions);
//            capabilities.setCapability("tags", new String[] {"regression", "android"});
//            capabilities.setCapability("project", "mdk-project-oct-28-next");
//            String hub = "http://" + userName + ":" + accessKey + gridURL;
//            driver = new AndroidDriver(new URL(hub), capabilities);
//
////            // BS
////            DesiredCapabilities bsCaps = new DesiredCapabilities();
////            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
////           // browserstackOptions.put("appiumVersion", "2.4.1");
////            bsCaps.setCapability("bstack:options", browserstackOptions);
//////        capabilities.setCapability("platformName", "ios");
//////        capabilities.setCapability("platformVersion", "16");
//////        capabilities.setCapability("deviceName", "iPhone 14");
////            //bsCaps.setCapability("browserstack.networkLogs", "true");
////            //ios
//////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
////            //android
////            bsCaps.setCapability("app", "bs://5283f99cbd55f1b238305ded6f0992ea62757a84");
////            bsCaps.setCapability("build", "build-lnw");
////            bsCaps.setCapability("name", "debug");
////            bsCaps.setCapability("autoGrantPermissions", true);
////            bsCaps.setCapability("platformName", "android");
////            bsCaps.setCapability("platformVersion", "14.0");
////            bsCaps.setCapability("deviceName", "Samsung Galaxy S24");
////            bsCaps.setCapability("interactiveDebugging", true);
////            bsCaps.setCapability("browserstack.uploadMedia", new String[]{"media://3bff28d99bb872867303fc92431bb9f91a4b3b7e"});
////
////
////           // driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
////
////
//
//
//
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//
//
//            Thread.sleep(3000);
//
//
//
//
//
//
//            driver.executeScript("lambda-status=passed");
//
//
//            driver.quit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            try{
//                driver.executeScript("lambda-status=failed");
//                driver.quit();
//            }catch(Exception e1){
//                e.printStackTrace();
//            }
//        }
//
//
//    }
}
