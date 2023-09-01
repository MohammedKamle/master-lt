package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Biometric {

    String userName = System.getenv("LT_USERNAME") == null ?
            "username" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "accessKey" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    private static final String BIOMETRIC_APP_ID = "lt://APP10160631101687949389447782";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");
            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", BIOMETRIC_APP_ID);
            ltOptions.put("build", "debug");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("biometric", "fail");
            capabilities.setCapability("lt:options", ltOptions);

            
            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            MobileElement allowButton = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
            allowButton.click();
            MobileElement biometric = (MobileElement) driver.findElementById("com.poc.sample:id/biometric");
            biometric.click();

        } finally {
            driver.quit();
        }
    }
}
