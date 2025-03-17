package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class OTT {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub-internal.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "fireos");
            //ltOptions.put("platformName", "tvos");
          //  ltOptions.put("platformName", "roku");
            ltOptions.put("deviceName", "Amazon Fire TV Stick");
            //ltOptions.put("deviceName", "Apple TV");
            //ltOptions.put("deviceName", "Roku Ultra");
            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "lt://APP1016029691703150459696340"); // firetv
           // ltOptions.put("app", "lt://APP1016029691703149229649580"); // apple
            //ltOptions.put("app", "lt://APP10160281841703149872785188");
            //ltOptions.put("appiumVersion", "2.0");
            ltOptions.put("build", "debug");
            //ltOptions.put("autoGrantPermission", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");
            //ltOptions.put("network", true);
            //ltOptions.put("network.full.har", true);
            //ltOptions.put("tags", new String[] {"regression", "android"});
            //ltOptions.put("visual", true);
//            ltOptions.put("smartUI.project", "md-rd-1");
            //ltOptions.put("smartUI.baseline", false);
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







            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            System.out.println("session_id :: "+driver.getSessionId());
            //Changes color to pink
            color.click();
            Thread.sleep(1000);
            //   driver.executeScript("smartui.takeScreenshot=dashboard-1");
            //driver.executeScript("smartui.takeScreenshot=dashboard-1");
            //Back to orginal color
            color.click();

            driver.context("NATIVE_APP");

            driver.getContext();

            MobileElement text = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/Text");
            //Changes the text to "Proverbial"
            text.click();

            //toast will be visible
            MobileElement toast = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/toast");
            toast.click();

            //notification will be visible
            MobileElement notification = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/notification");
            notification.click();
            Thread.sleep(2000);

            //driver.executeScript("smartui.takeScreenshot=dashboard-1");

            //Opens the geolocation page
//            MobileElement geo = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/geoLocation");
//            geo.click();
//            Thread.sleep(5000);
//
//            //takes back to home page
//            MobileElement home = (MobileElement) driver.findElementByAccessibilityId("Home");
//            home.click();
//
//            //Takes to speed test page
//            MobileElement speedtest = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/speedTest");
//            speedtest.click();
            // Thread.sleep(5000);



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
