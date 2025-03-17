package AppAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class TermiActiRD {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");

            //ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "proverbial-ios");
            //ltOptions.put("appiumVersion", "2.2.1");
            ltOptions.put("build", "Java TestNG Android");
            ltOptions.put("autoGrantPermission", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


          //  System.out.println(driver.location());

            ((JavascriptExecutor) driver).executeScript("lambda-testCase-start=find Name");


            driver.executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.lambdatest.proverbial"));
            driver.executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.lambdatest.proverbial"));


            Thread.sleep(3000);

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
