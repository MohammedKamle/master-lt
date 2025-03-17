package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MyKarma {
    public static String userName = System.getenv("LT_USERNAME") == null ? "mohammadk"  //Add LambdaTest username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU" //Add LambdaTest accessKey here
            : System.getenv("LT_ACCESS_KEY");

    private static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                HashMap<String, Object> ltOptions = new HashMap<String, Object>();
                ltOptions.put("w3c", true);
                ltOptions.put("platformName", "android");
                ltOptions.put("deviceName", ".*");

                //ltOptions.put("platformVersion", "13");
                ltOptions.put("app", "lt://APP1016053741710408239433953");
                ltOptions.put("appiumVersion", "1.17.1");
                ltOptions.put("build", "Java TestNG Android");
                ltOptions.put("autoGrantPermission", true);
                //ltOptions.put("smartUI.project", "md-rd-1");

                // ltOptions.put("name", platform+" "+device+" "+version);
                ltOptions.put("isRealMobile", true);
                ltOptions.put("project", "android");
                //ltOptions.put("region", "US");
        //            ltOptions.put("language", "fr");
        //            ltOptions.put("locale", "fr_FR");
                //ltOptions.put("network", true);
                //ltOptions.put("network.full.har", true);
                //ltOptions.put("tags", new String[] {"regression", "android"});
                //ltOptions.put("visual", true);
        //            ltOptions.put("smartUI.project", "md-rd-1");
                //ltOptions.put("smartUI.baseline", false);
                capabilities.setCapability("lt:options", ltOptions);

        driver= new AndroidDriver(
                new URL("https://" +userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);



        ///BS
//        DesiredCapabilities caps = new DesiredCapabilities();
//// Set URL of the application under test
//        caps.setCapability("os_version", "13");
//        caps.setCapability("device", "Samsung Galaxy S23 Ultra");
//        caps.setCapability("app", "bs://aece7c0309e7b045fa90cf74dfad36a0da294ba3");
//        caps.setCapability("autoGrantPermission", true);
//        caps.setCapability("browserstack.user", "mobileautoservic_w86Uka");
//        caps.setCapability("browserstack.key", "SeW8HQo2LzzoUw9qsDK8");
//        driver = new AndroidDriver(new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {


            //driver.findElement(By.xpath("//*[@resource-id='tbUsername']")).sendKeys("sample");
            driver.findElement
                    (MobileBy.
                            AndroidUIAutomator("new UiSelector().id(\"tbUsername\")")).sendKeys("sample");

            //driver.findElement(By.xpath("//*[@resource-id=\"tbUsername\"]")).click();

            System.out.println(driver.getPageSource());

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}