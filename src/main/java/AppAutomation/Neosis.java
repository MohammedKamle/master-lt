package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.annotations.Test;



public class Neosis {

    String userName = "mohammadk";
    //Add username here
    String accessKey = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";
    public String gridURL = "@hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Pixel.*");
//            ltOptions.put("app", "proverbial-android");
//            ltOptions.put("appiumVersion", "2.0");
//            ltOptions.put("build", "neosis-debug");
//            ltOptions.put("isRealMobile", true);
//            capabilities.setCapability("lt:options", ltOptions);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel 2");
            ltOptions.put("platformVersion", "9");
            ltOptions.put("build","neosis-emulator");
            ltOptions.put("app", "proverbial-android");
            capabilities.setCapability("lt:options", ltOptions);

            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            //Changes color to pink
            color.click();
            Thread.sleep(1000);
            //   driver.executeScript("smartui.takeScreenshot=dashboard-1");
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

            driver.executeScript("smartui.takeScreenshot=dashboard-1");

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
