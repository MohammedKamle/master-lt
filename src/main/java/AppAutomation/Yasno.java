package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Yasno {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AndroidDriver driver;

    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", ".*");
            //ltOptions.put("automationName", "UIAutomator2");
            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP1016019381719413796215690");
            //ltOptions.put("resignApp", false);
            //ltOptions.put("appiumVersion", "1.22.3");
            //ltOptions.put("newCommandTimeout", 180);
            ltOptions.put("build", "yasno-debug-2-jul");
            ltOptions.put("autoGrantPermissions", true);



            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");
            //ltOptions.put("geoLocation", "UA");
            //ltOptions.put("region", "US");
            //ltOptions.put("language", "uk");
            //ltOptions.put("locale", "UA");
            ltOptions.put("noReset", true);
            ltOptions.put("fullReset",true);
            ltOptions.put("network", false);
            ltOptions.put("disableSuppressAccessibilityService", true);
            ltOptions.put("skipServerInstallation", true);
            ltOptions.put("suppressKillServer", true);
            ltOptions.put("fixedIp", "18121FDF60047Z");
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

          String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



            driver.findElement(By.xpath("//*[@*='sing-in-button']")).click();


            // Retrieve all available contexts
            Set<String> contextHandles = driver.getContextHandles();
//            for (String contextHandle : contextHandles) {
//                System.out.println("Available context: " + contextHandle);
//            }
//
//            // Switch to webview context (example: "WEBVIEW_com.example.yourapp")
            for (String contextHandle : contextHandles){
                System.out.println("Available context: " + contextHandle);
                if (contextHandle.contains("WEBVIEW_com.dsolutions.yasnomobile.demo")) {
                    driver.context(contextHandle);
                    System.out.println("Switched to context: " + contextHandle);
                    break;
                }
            }


            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("552221921");

            driver.findElement(By.xpath("//*[@*='sign-in-phone-screen-submit-button']")).click();

            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));


            Thread.sleep(10000);













            driver.executeScript("lambda-status=passed");

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.executeScript("lambda-status=failed");

                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
