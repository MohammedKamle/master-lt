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

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class HelloHeart {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");

            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "lt://APP10160201271708686495153664");
            ltOptions.put("appiumVersion", "2.0");
            ltOptions.put("build", "HelloHeart");
            //ltOptions.put("autoGrantPermission", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");
            //ltOptions.put("region", "US");
//            ltOptions.put("language", "fr");
//            ltOptions.put("locale", "fr_FR");
            //ltOptions.put("network", true);
            //ltOptions.put("network.full.har", true);
            //ltOptions.put("tags", new String[] {"regression", "android"});
            //ltOptions.put("visual", true);
//            ltOptions.put("smartUI.project", "md-rd-1");
            //ltOptions.put("smartUI.baseline", false);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            WebDriverWait Wait = new WebDriverWait(driver,30);

            //Changes the color of the text
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("color"))).click();
            Thread.sleep(1000);

            //Changes the text to "Proverbial"
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Text"))).click();
            Thread.sleep(1000);



            //Toast will be visible
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("toast"))).click();
            Thread.sleep(1000);

            //Notification will be visible
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("notification"))).click();
            Thread.sleep(4000);

            //Opens the geolocation page
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("geoLocation"))).click();
            Thread.sleep(4000);


            JavascriptExecutor js = (JavascriptExecutor) driver;
            Map<String, String> data = new HashMap<>();
            data.put("appUrl", "lt://APP10160201271708686495153664");
            js.executeScript("lambda-install-app", data);
            driver.launchApp();

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
