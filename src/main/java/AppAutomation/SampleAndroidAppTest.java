package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class SampleAndroidAppTest {

    String userName = "mkamle86";
    String status = "failed";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    protected static ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();

    @Test()
    public void AndroidApp1() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy.*");
            ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP1016062101739211055805809");
            //ltOptions.put("resignApp", false);
            //ltOptions.put("appiumVersion", "2.2.1");
            ltOptions.put("build", "debug");
            ltOptions.put("settings[snapshotMaxDepth]",61);
            //ltOptions.put("autoGrantPermission", true);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", false);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("build","Java TestNG Android");
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//             capabilities.setCapability("deviceName", "iPhone.*");
//             capabilities.setCapability("animationCoolOffTimeout", 2000);
//            //capabilities.setCapability("platformVersion",version);
//            capabilities.setCapability("platformName", "ios");
//            capabilities.setCapability("isRealMobile", true);
//            //AppURL (Create from Wikipedia.apk sample in project)
//            capabilities.setCapability("app", "proverbial-ios"); //Enter your app url
//
//            capabilities.setCapability("console", true);
//            //capabilities.setCapability("network", true);
//            capabilities.setCapability("visual", true);
//            capabilities.setCapability("devicelog", true);
//   //         capabilities.setCapability("appProfiling", true);
// //           capabilities.setCapability("geoLocation", "HK");
//

            String hub = "http://" + userName + ":" + accessKey + gridURL;


        threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities));

            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



            status = "passed";
    }

    @AfterMethod
    public void tearDown(){
        threadLocalDriver.get().executeScript("lambda-status="+status);
        threadLocalDriver.get().quit();
    }
}
