package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class RankBank {

    String userName = "mkamle86";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    protected static ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();

    @Test(threadPoolSize = 25, invocationCount = 25)
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S24 Ultra");
            //ltOptions.put("automationName", "UIAutomator2");
            ltOptions.put("platformVersion", "14");
            ltOptions.put("app", "lt://APP1016049361737361229341621");

            ltOptions.put("build", "rank_bank_debug");

            ltOptions.put("isRealMobile", true);


            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");


//

            String hub = "http://" + userName + ":" + accessKey + gridURL;


            threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities));

            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            Thread.sleep(4000);





            threadLocalDriver.get().executeScript("lambda-status=passed");


            threadLocalDriver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                threadLocalDriver.get().executeScript("lambda-status=failed");
                threadLocalDriver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
