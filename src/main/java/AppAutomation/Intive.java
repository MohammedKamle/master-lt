package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Intive {

    String userName = "mkamle86";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";
    boolean isBS = false;

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    @Test(invocationCount = 20, threadPoolSize = 20)
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S23");
            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP1016062101739211055805809");
            HashMap<String, String> coordinates = new HashMap<>();
            coordinates.put("lat", "52.377956");
            coordinates.put("long", "4.89707");
            ltOptions.put("location", "{\"lat\": \"52.377956\", \"long\": \"4.89707\"}");
            ltOptions.put("devicelog", true);
            ltOptions.put("appiumVersion", "2.12.1");
            ltOptions.put("appProfiling", true);
            ltOptions.put("build", "intive-debug-wtih-20p-withoutNet-withProfile-appiumV2.12.1-itr1");
            ltOptions.put("autoGrantPermissions", true);
            ltOptions.put("isRealMobile", true);
            //ltOptions.put("network", true);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver.set(new AndroidDriver<>(new URL(hub), capabilities));
//

            // Browserstack
//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("appiumVersion", "2.0.1");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
//            bsCaps.setCapability("app", "bs://7ac603fa3ca9427cc2b9588aa1a81d78e02cf32c");
//            bsCaps.setCapability("build", "intive-debug-appium-2.x-imp-20-itr1");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoGrantPermissions", true);
//            isBS = true;
//            bsCaps.setCapability("platformName", "android");
//            bsCaps.setCapability("platformVersion", "13.0");
//            bsCaps.setCapability("deviceName", "Samsung Galaxy S23");
//            bsCaps.setCapability("appProfiling", true);
//            bsCaps.setCapability("networkLogs", true);
//            bsCaps.setCapability("gpsLocation", "52.377956,4.89707");
//            driver.set(new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps));
//            //driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//
//
//


            driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



            driver.get().findElement(By.xpath("//*[@resource-id=\"login_username_input\"]")).sendKeys("lt_n");

            driver.get().findElement(By.xpath("//*[@resource-id=\"login_password_input\"]")).sendKeys("lambda123n");


            driver.get().findElement(By.xpath("//*[@class=\"android.widget.Button\"]")).click();



            driver.get().findElement(By.xpath("//*[@text=\"Synchronization\"]")).isDisplayed();





            if (isBS){
                driver.get().executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
            }else {
                driver.get().executeScript("lambda-status=passed");
            }


            driver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                if (isBS){
                    driver.get().executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Results not found\"}}");
                }else {
                    driver.get().executeScript("lambda-status=failed");
                }
                driver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
