package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class Vorwerk {

    String userName = "Vitali.Maier";  //anurags
    String accessKey = "gXHKmTgS9ozJ30ly6ACtboxK9oxZsgLCQo15tDOIId8A3hOx2K";
//GqBrdRSOT7sQQowLZ67OfV7DEyXFgVOFyH7h199p4KTha9xV2s
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    WebDriver driver;

    @Test
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Pixel 7");
//            ltOptions.put("automationName", "UIAutomator2");
//            ltOptions.put("platformVersion", "13.0");
//            //ltOptions.put("nativeWebScreenshot", true);
//            ltOptions.put("app", "lt://APP1016029121717485329982501");
//            //ltOptions.put("resignApp", false);
//            ltOptions.put("appiumVersion", "2.2.1");
//            ltOptions.put("build", "vorwerk-debug");
//            //ltOptions.put("autoAcceptAlerts", false);
//            ltOptions.put("isRealMobile", true);
//            //ltOptions.put("idleTimeout", 300);
//            ltOptions.put("project", "vorwerk_mdk");
//            ltOptions.put("network", true);
////            ltOptions.put("tunnel", true);
////            ltOptions.put("tunnelName", "kamle");
//            //ltOptions.put("mitmProxy", true);
//            //ltOptions.put("console", false);
//            ltOptions.put("visual", true);
//            //ltOptions.put("devicelog", false);
//            //ltOptions.put("connectHardwareKeyboard", true);
//            //ltOptions.put("geoLocation", "DE");
//          //  ltOptions.put("fixedIP", "00008110-00125C582200A01E");////00008110-00125C582200A01E
//            //wwvg6-cugf5-6i2qn-m8wjq ^^
////            ltOptions.put("region", "eu");
//            ltOptions.put("timezone", "Belgium");
//            capabilities.setCapability("lt:options", ltOptions);




            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","vorwerk-debug");
            capabilities.setCapability("w3c", true);
            capabilities.setCapability("automationName", "UIAutomator2");
             capabilities.setCapability("deviceName", "Pixel 7");
            capabilities.setCapability("platformVersion", "13.0");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP1016029121717485329982501"); //Enter your app url

            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("appiumVersion", "2.2.1");
            capabilities.setCapability("timezone", "Belgium");

            //capabilities.setCapability("resignApp", false);
//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new RemoteWebDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

           // driver.get(" http://localhost:8000");

            Thread.sleep(5000);

//            TouchAction touchAction = new TouchAction(driver)
//                    .press(PointOption.point(206, 252))  // coordinates for the touch
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))  // pause for 100 milliseconds
//                    .release();  // lift the finger
//
//            // Perform the action
//            touchAction.perform();

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
