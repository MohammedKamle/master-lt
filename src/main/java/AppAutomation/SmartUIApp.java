package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import org.testng.annotations.Test;



public class SmartUIApp {

    String userName = System.getenv("LT_USERNAME") == null ?
            "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");

            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "proverbial-android");
            ltOptions.put("appiumVersion", "2.0");
            ltOptions.put("build", "Java TestNG Android");
            ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("visual", true);
//            ltOptions.put("smartUI.project", "md-rd-1");
            ltOptions.put("smartUI.baseline", false);
            capabilities.setCapability("lt:options", ltOptions);




            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);



            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            //Changes color to pink
            color.click();
            Thread.sleep(1000);
               driver.executeScript("smartui.takeScreenshot=dashboard-1");
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

           // driver.executeScript("smartui.takeScreenshot=dashboard-1");

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
