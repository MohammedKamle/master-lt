package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import org.testng.annotations.Test;



public class Dedulas {

    String userName = System.getenv("LT_USERNAME") == null ?
            "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("deviceName", "ASUS ZenFone 8");
            capabilities.setCapability("platformVersion", "13");
            capabilities.setCapability("app", "proverbial-android");
            //capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("build", "dedulas-debug");



            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);



            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            //Changes color to pink
            color.click();
            Thread.sleep(1000);
            //driver.executeScript("smartui.takeScreenshot=dashboard-1");
            //Back to orginal color
            color.click();

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

            //   driver.executeScript("smartui.takeScreenshot=dashboard-1");

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
