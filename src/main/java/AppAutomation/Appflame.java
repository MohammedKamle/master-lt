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
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Appflame {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    IOSDriver driver;
    String deviceRegex = "(Pixel (8 Pro|8|7 Pro|7|6))|(Galaxy S2[34](\\+| Ultra)?)";
    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 15");
            //ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP10160361821724057339776934");
            ltOptions.put("build", "appflame-debug");

            ltOptions.put("geoLocation", "UA");
            ltOptions.put("devicelog", true);
            ltOptions.put("resign", false);
            ltOptions.put("geoLocation", "UA");
            ltOptions.put("language", "en");
            ltOptions.put("locale", "en_US");
            ltOptions.put("processArguments", "{\"env\":{\"NOTIFICATION_SHOW_TIME\":\"6\"}}");
            ltOptions.put("enableNetworkThrottling", false);
            ltOptions.put("autoAcceptAlerts", false);


            //ltOptions.put("mitmProxy", true);

            //ltOptions.put("")



            ltOptions.put("isRealMobile", true);


            ltOptions.put("network", false);
//            HashMap<String, String> playstorelogin = new HashMap<>();
//            playstorelogin.put("email", "myema@gmail.com");          //Add in your Google account ID
//            playstorelogin.put("password", "pasorrd");          //Add in your Google account Password
//            capabilities.setCapability("playStoreLogin", playstorelogin);


            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);
//

//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.4.1");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            //bsCaps.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            bsCaps.setCapability("app", "bs://d96d9c66344e1ac3d36cace904e5e2ed386fc1e1");
//            bsCaps.setCapability("build", "build-wix");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoGrantPermissions", true);
//            bsCaps.setCapability("platformName", "android");
//            bsCaps.setCapability("platformVersion", "14.0");
//            bsCaps.setCapability("deviceName", "Samsung Galaxy S24");
//            bsCaps.setCapability("interactiveDebugging", true);
//
//            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//
//





            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                driver.startRecordingScreen();


                Thread.sleep(5000);

                driver.stopRecordingScreen();

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
