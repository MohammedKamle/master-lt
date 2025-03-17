package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class LingoKids {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");
            //ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP10160542501735823512140730");


            //ltOptions.put("resignApp", false);
            //ltOptions.put("appiumVersion", "2.2.1");
            //ltOptions.put("timezone", "Belgium");
            ltOptions.put("build", "wix debug-2");
            //ltOptions.put("autoGrantPermission", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("settings[snapshotMaxDepth]", 61);
            //ltOptions.put("project", "android");
            //ltOptions.put("smartUI.project", "rd-mobile");
            //ltOptions.put("region", "US");
//            ltOptions.put("language", "fr");
//            ltOptions.put("locale", "fr_FR");
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


            driver = new IOSDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);




//
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
