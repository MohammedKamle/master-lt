package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Devrico {

    String userName = "mkamle86";

    String Status = "passed";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S23 Ultra");

            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160361611740640020404804");
            ltOptions.put("autoGrantPermissions", true);
            ltOptions.put("acceptInsecureCerts", false);
            ltOptions.put("autoAcceptAlerts", false);
            ltOptions.put("autoDismissAlerts", true);
//            ltOptions.put("uiautomator2ServerInstallTimeout", 30000);
//            ltOptions.put("uiautomator2ServerLaunchTimeout", 60000);


            //ltOptions.put("appiumVersion", "2.0.0");

            ltOptions.put("build", "devrico-debug-ES-11");

            ltOptions.put("dedicatedProxy", true);

            ltOptions.put("region", "us");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("geoLocation",    "CA/ON");




//
//
            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});



//

            String hub = "http://" + userName + ":" + accessKey + gridURL;


            driver.set(new AndroidDriver<>(new URL(hub), capabilities));

            driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            Thread.sleep(25000);
            WebElement retry  = driver.get().findElement(By.xpath("//*[@resource-id=\"com.betway.sports:id/retryBtn\"]"));

            if (retry.isDisplayed()) {
                // If it is displayed, throw a custom exception or handle the logic as needed
                throw new Exception("Retry button is displayed, throwing an exception!");
            }


            // Get the current context
            Set<String> contexts = driver.get().getContextHandles();

// Print all available contexts
            for (String context : contexts) {
                System.out.println("Available Context: " + context);
            }

            driver.get().context("WEBVIEW_com.betway.sports.debug");



            //driver.findElement(By.xpath("//*[@text=\"Accept\"]")).isDisplayed();
            driver.get().findElement(By.xpath("//*[contains(text(), 'Accept')]")).isDisplayed();





//
//
            driver.get().executeScript("lambda-status=passed");


            driver.get().quit();

        } catch (NoSuchElementException e) {
            driver.get().executeScript("lambda-status=failed");
            driver.get().quit();
            System.out.println("Retry button not found: " + e.getMessage());
        } catch (WebDriverException e) {
            driver.get().executeScript("lambda-status=failed");
            driver.get().quit();
            System.out.println("WebDriver error: " + e.getMessage());
        } catch (Exception e) {
            driver.get().executeScript("lambda-status=failed");
            driver.get().quit();
            // Handle the custom exception or other errors
            System.out.println("Exception occurred: " + e.getMessage());
        }

    }


    @Test(threadPoolSize = 20, invocationCount = 20)
    public void webContextTest() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S23 Ultra");

            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160361611740640020404804");
            ltOptions.put("autoGrantPermissions", true);
            ltOptions.put("acceptInsecureCerts", false);
            ltOptions.put("autoAcceptAlerts", false);
            ltOptions.put("autoDismissAlerts", true);
//            ltOptions.put("uiautomator2ServerInstallTimeout", 30000);
//            ltOptions.put("uiautomator2ServerLaunchTimeout", 60000);


            //ltOptions.put("appiumVersion", "2.0.0");

            ltOptions.put("build", "devrico-debug-webview-s23_ultra");

            ltOptions.put("dedicatedProxy", true);

            ltOptions.put("region", "us");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("geoLocation",  "CA/ON");




//
//
            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});



//

            String hub = "http://" + userName + ":" + accessKey + gridURL;


            driver.set(new AndroidDriver<>(new URL(hub), capabilities));

            driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //Thread.sleep(5000);
            if (driver.get().getContextHandles().size() == 1){
                System.out.println("ONLY NATIVE CONTEXT");
                Status = "failed";
            }

            driver.get().executeScript("lambda-status="+Status);




        }  catch (Exception e) {
        e.printStackTrace();
        }finally {
            driver.get().quit();
        }

    }


}
