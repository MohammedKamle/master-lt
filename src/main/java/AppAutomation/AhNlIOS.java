package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.v85.layertree.LayerTree;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class AhNlIOS {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    IOSDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 13");
            ltOptions.put("platformVersion", "15");
            ltOptions.put("app", "lt://APP10160471181716289520376436");
            //ltOptions.put("app", "lt://APP1016025931715779582402477");
            //ltOptions.put("resignApp", false);
            ltOptions.put("appiumVersion", "2.0");
            ltOptions.put("build", "an.nl-debug");
            ltOptions.put("autoAcceptAlerts", true);
            ltOptions.put("isRealMobile", true);
            // ltOptions.put("network", true);
            ltOptions.put("visual", true);
            //ltOptions.put("resignApp", false);

            ltOptions.put("enableMultiWindows", true);
            ltOptions.put("enableNetworkThrottling", false);
            ltOptions.put("enableTopmostWindowFromActivePackage", true);
            ltOptions.put("ignoreUnimportantViews", false);
            ltOptions.put("includeExtrasInPageSource", true);
            ltOptions.put("shouldUseCompactResponses", false);
            ltOptions.put("settings[waitForIdleTimeout]", 0);

            capabilities.setCapability("lt:options", ltOptions);
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);


//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("appiumVersion", "2.0.0");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
//            bsCaps.setCapability("browserstack.networkLogs", "true");
//            bsCaps.setCapability("app", "bs://890b20f9109571cfea8d41d81776b263a599167e");
//            bsCaps.setCapability("build", "build-ahnl");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoAcceptAlerts", true);
//            bsCaps.setCapability("platformName", "ios");
//            bsCaps.setCapability("platformVersion", "15.0");
//            bsCaps.setCapability("deviceName", "iPhone 13");
//
//            bsCaps.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            bsCaps.setCapability("enableMultiWindows", true);
//            bsCaps.setCapability("enableTopmostWindowFromActivePackage", true);
//            bsCaps.setCapability("ignoreUnimportantViews", false);
//            bsCaps.setCapability("includeExtrasInPageSource", true);
//            bsCaps.setCapability("settings[waitForIdleTimeout]", 1);
//            bsCaps.setCapability("shouldUseCompactResponses",false);
//            bsCaps.setCapability("interactiveDebugging", true);
//            driver = new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            driver.findElement(By.xpath("//*[@name=\"Ik ga akkoord\"]")).click();

            driver.findElement(By.xpath("//*[@name=\"Overslaan\"]")).click();

            driver.findElement(By.xpath("//XCUIElementTypeImage[contains(@name,\"Icon/clock24\")]")).click();




            //driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Albert Heijn. Online bestellen\"]]/*[1]/*[@type=\"XCUIElementTypeButton\"]")).click();








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
