package AppAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Simulator {

    String userName = "mkamle86";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    IOSDriver<MobileElement> driver;

    @Test
    public void AndroidApp1() {
        try {
            MutableCapabilities capabilities = new MutableCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 15 Pro");
            ltOptions.put("devicelog", true);
            //ltOptions.put("network", true);
            //ltOptions.put("platformVersion", "16.0");
            ltOptions.put("app", "lt://APP10160542501734775886754165");
            //ltOptions.put("appiumVersion", "2.1.3");
            ltOptions.put("build", "hello-heart-debug");
            ltOptions.put("isRealMobile", false);
            capabilities.setCapability("lt:options", ltOptions);
            //capabilities.setCapability("tags", new String[] {"regression", "android"});


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver<MobileElement>(new URL(hub), capabilities);





            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            Thread.sleep(3000);




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
