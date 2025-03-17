package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Carefour {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AndroidDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            MutableCapabilities capabilities = new MutableCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy.*");

            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "lt://APP1016020161710349006808789");
            ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "carre-with-image");
            //ltOptions.put("region", "eu");
            ltOptions.put("autoGrantPermission", true);
            ltOptions.put("setWebContentsDebuggingEnabled", true);
            ltOptions.put("enableImageInjection", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

            capabilities.setCapability("lt:options", ltOptions);



            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

//            //BS
//            DesiredCapabilities caps = new DesiredCapabilities();
//// Set URL of the application under test
//            caps.setCapability("os_version", "13");
//            caps.setCapability("device", "Samsung Galaxy S23 Ultra");
//            caps.setCapability("app", "bs://62474021aeb8b95ecdb0f6593e79c37ad0a614d5");
//            caps.setCapability("autoGrantPermission", true);
//            caps.setCapability("browserstack.user", "mobileautoservic_w86Uka");
//            caps.setCapability("browserstack.key", "SeW8HQo2LzzoUw9qsDK8");
//            driver = new AndroidDriver(new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]");
            el1.sendKeys("admin_pickpack");
            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]");
            el2.sendKeys("Carrefour123$");
            MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.Button");
            el3.click();

            System.out.println(driver.getPageSource());

            driver.findElement(By.xpath("//android.view.View[@resource-id='searchbar']//android.widget.EditText")).sendKeys("Market Milly-La-Forêt");




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
