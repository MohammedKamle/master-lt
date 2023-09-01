package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.testng.annotations.Test;



public class Lodgify {

    String userName = System.getenv("LT_USERNAME") == null ?
            "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("automationName", "flutter");
            ltOptions.put("deviceName", "iPhone.*");
            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "flutter-app-ios");
            ltOptions.put("appiumVersion", "2.0");
            ltOptions.put("build", "lodgify-debug");
            ltOptions.put("isRealMobile", true);
            capabilities.setCapability("lt:options", ltOptions);




            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);





        } finally {
            driver.quit();
        }
    }
}
