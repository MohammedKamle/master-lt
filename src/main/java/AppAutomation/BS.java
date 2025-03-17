package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class BS {
    public AndroidDriver driver;



    @Test
    public void test() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("project", "First TestNg iOS Project");
//        capabilities.setCapability("build", "build-lingo");
//        capabilities.setCapability("name", "debug");
//        capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("os_version", "16");
//        capabilities.setCapability("device", "iPhone 14");
//        capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
        //capabilities.setCapability("disableAnimations", "true");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("appiumVersion", "2.0.0");
        capabilities.setCapability("bstack:options", browserstackOptions);
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("platformVersion", "16");
//        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("browserstack.networkLogs", "true");
        //ios
//        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
        //android
        capabilities.setCapability("app", "bs://38d9f3f4e4304a50db30d34934c27a56b06f2e41");
        capabilities.setCapability("build", "build-cybersmart");
        capabilities.setCapability("name", "debug");

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S20");


        driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);


        Thread.sleep(5000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Button")).click();




        driver.quit();
    }
}
