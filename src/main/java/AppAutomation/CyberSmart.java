package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class CyberSmart {

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
            ltOptions.put("platformName", "android");
            ltOptions.put("network", true);
            ltOptions.put("deviceName", "Galaxy.*");
            ltOptions.put("app", "Stock");
            ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "cybersmart-debug");
            ltOptions.put("autoGrantPermission", true);
            ltOptions.put("platformVersion", "11");
            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("appPackage", "com.android.vending");
            ltOptions.put("appActivity", "com.android.vending.AssetBrowserActivity");
            ltOptions.put("project", "android");

            capabilities.setCapability("lt:options", ltOptions);



//            \
//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



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
