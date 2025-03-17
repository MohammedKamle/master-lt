package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Codere {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Pixel.*");
//            ltOptions.put("app", "lt://APP1016029841714675352839490");
//            ltOptions.put("build", "codere");
//            ltOptions.put("autoGrantPermission", true);
//            ltOptions.put("geoLocation", "ES");
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("project", "android");
//            capabilities.setCapability("lt:options", ltOptions);
//            String hub = "http://" + userName + ":" + accessKey + gridURL;
//            driver = new AndroidDriver(new URL(hub), capabilities);


            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("appiumVersion", "2.0.0");
            capabilities.setCapability("bstack:options", browserstackOptions);
            capabilities.setCapability("browserstack.networkLogs", "true");
            capabilities.setCapability("app", "bs://38d9f3f4e4304a50db30d34934c27a56b06f2e41");
            capabilities.setCapability("build", "build-cybersmart");
            capabilities.setCapability("name", "debug");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("platformVersion", "10.0");
            capabilities.setCapability("deviceName", "Samsung Galaxy S20");
            capabilities.setCapability("autoGrantPermission", true);
            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[1]");
//            el2.click();
//            MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Button");
//            el3.click();
////            MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View/android.view.View/android.view.View/android.widget.Button[2]");
////            el4.click();

            //For BS
            MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[1]");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.widget.Button[3]");
            el2.click();


            System.out.println(driver.getPageSource());
            driver.findElement(By.id("btnaccess")).click();


//            List<MobileElement> eles = driver.findElements(By.id("btnaccess"));
//            System.out.println("SIZE IS :: "+eles.size());
//            for (MobileElement ele : eles){
//                System.out.println(ele);
//                ele.click();
//            }





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
