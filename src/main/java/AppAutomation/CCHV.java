package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class CCHV {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test(invocationCount = 10)
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Galaxy Tab S8");
//            ltOptions.put("platformVersion", "13");
//            ltOptions.put("app", "lt://APP10160492141707739165544161");
//            //ltOptions.put("appiumVersion", "2.0.0");
//            ltOptions.put("build", "Java TestNG Android");
//            ltOptions.put("autoGrantPermission", true);
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("project", "android");
//
//            //ltOptions.put("useResourcesForOrientationDetection", true);
//            capabilities.setCapability("lt:options", ltOptions);
//            //capabilities.setCapability("orientation", "LANDSCAPE");
////
//
//
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","cchv-debug-regex");
            capabilities.setCapability("name","prob");
             capabilities.setCapability("deviceName", "Galaxy Tab.*");
            //capabilities.setCapability("platformVersion", "9");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("appiumVersion", "latest");
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP10160492141707739165544161");//Enter your app url
            capabilities.setCapability("orientation", "AUTO");
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);



//            DesiredCapabilities caps = new DesiredCapabilities();
//// Set URL of the application under test
//            caps.setCapability("os_version", "12.0");
//            caps.setCapability("device", "Samsung Galaxy Tab S8");
//            caps.setCapability("app", "bs://a43b5901c62adbb44bdd84681a8ed937f49b2330");
//            caps.setCapability("browserstack.user", "mobileautoservic_w86Uka");
//            caps.setCapability("browserstack.key", "SeW8HQo2LzzoUw9qsDK8");
//
//            String bsHub = "http://hub.browserstack.com/wd/hub";
//
//
//            AppiumDriver driver = new AppiumDriver(new URL(bsHub), caps);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            System.out.println(driver.getSessionId());


            System.out.println(driver.location());




             Thread.sleep(5000);



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
