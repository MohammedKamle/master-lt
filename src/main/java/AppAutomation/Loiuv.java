package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Loiuv {

    String userName = "mohammadk";
    String accessKey =  "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            //ltOptions.put("deviceName", "iPad Mi.*, iPad Ai.*, iPad 10.*,iPad [(]");

        ltOptions.put("deviceName", "iPhone.*");
            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "lt://APP1016029691706182999920719");
            ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "lv-debug");
            //ltOptions.put("fixedIP", "00008110-001014D402DB801E");
            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            capabilities.setCapability("lt:options", ltOptions);




            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //Thread.sleep(5000);

           // driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Americas'] | //XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[not(contains(@label, 'Ask App')) and not(contains(@label, 'Allow'))][1]")).click();
            
            Set<String> contexts =  driver.getContextHandles();

            for (String context : contexts) {
                System.out.println("CONTEXT IS :: "+context);
            }

        } catch (Exception e){
            e.printStackTrace();

        }finally {
            driver.quit();
        }
    }
}
