package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class AhNlBS {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

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
//            ltOptions.put("platformVersion", "13");
//            //ltOptions.put("app", "lt://APP10160471181715863740353908");
//            ltOptions.put("app", "lt://APP1016025931715779582402477");
//            ltOptions.put("resignApp", false);
//            ltOptions.put("appiumVersion", "2.0.0");
//            ltOptions.put("build", "an.nl-debug");
//            ltOptions.put("autoGrantPermissions", true);
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("network", true);
//            ltOptions.put("visual", true);
//            ltOptions.put("resignApp", false);
//            capabilities.setCapability("lt:options", ltOptions);
//            String hub = "http://" + userName + ":" + accessKey + gridURL;
//            driver = new AndroidDriver(new URL(hub), capabilities);


            DesiredCapabilities bsCaps = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("appiumVersion", "2.0.0");
            bsCaps.setCapability("bstack:options", browserstackOptions);
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("platformVersion", "16");
//        capabilities.setCapability("deviceName", "iPhone 14");
            bsCaps.setCapability("browserstack.networkLogs", "true");
            //ios
//        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
            //android
            bsCaps.setCapability("app", "bs://890b20f9109571cfea8d41d81776b263a599167e");
            bsCaps.setCapability("build", "build-cybersmart");
            bsCaps.setCapability("name", "debug");
            bsCaps.setCapability("autoGrantPermissions", true);
            bsCaps.setCapability("platformName", "android");
            bsCaps.setCapability("platformVersion", "13.0");
            bsCaps.setCapability("deviceName", "Samsung Galaxy S23");
            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);


        

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElement(By.xpath("xpath=//android.widget.RadioButton[@text=\"TST\"]")).click();

//
//            driver.findElement(By.xpath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/menu_time_travel_start\"]")).click();
//
//            driver.findElement(By.xpath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/accept_full_consent_button\"]")).click();
//
//            driver.findElement(By.xpath("//*[@content-desc=\"Inloggen\"]")).click();
//
//            //For BS
//            driver.findElement(By.xpath("//*[@resource-id=\"login\"]")).click();

//            Set<String> contextNames = driver.getContextHandles();
//            for (String contextName : contextNames) {
//                System.out.println(contextName);
//                if (contextName.contains("WEBVIEW_com.icemobile.alberthejin.debug")) {
//                    driver.context(contextName);
//                    break;
//                }
//            }
//
//            driver.findElement(By.xpath("//*[@text=\"E-mailadres\"]")).sendKeys("some-email");
//
//            driver.findElement(By.xpath("//*[@class=\"text-input_input__GcwGY\" and ./following-sibling::*[@text=\"Wachtwoord\"]]")).sendKeys("password");









            // Thread.sleep(3000);



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
