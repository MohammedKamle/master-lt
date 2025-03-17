package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class RandonRegion {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test(invocationCount = 10, threadPoolSize = 10)
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");
            //ltOptions.put("automationName", "UIAutomator2");
            //ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160502001720000162477875");
            //ltOptions.put("resignApp", false);
            //ltOptions.put("appiumVersion", "1.22.3");
            //ltOptions.put("timezone", "Belgium");
            ltOptions.put("build", "rano-test");
            //ltOptions.put("autoGrantPermission", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");
            String[] regions = {"ap", "eu", "us"};
            Random random = new Random();
            String randomRegion = regions[random.nextInt(regions.length)];
            ltOptions.put("region", randomRegion);
//            ltOptions.put("language", "fr");
//            ltOptions.put("locale", "fr_FR");
            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");


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
//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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
