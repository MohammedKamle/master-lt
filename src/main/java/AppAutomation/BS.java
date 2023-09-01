package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BS {
    public IOSDriver<IOSElement> driver;



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
        capabilities.setCapability("app", "bs://f4e47edcf5eab80a15182576f2ba990db74428779");
        capabilities.setCapability("build", "build-lingo");
        capabilities.setCapability("name", "debug");

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Google Pixel 3");


        driver = new IOSDriver<IOSElement>(new URL("http://"+"falconmagicleap_vci1oa"+":"+"D2o95qF5cHvPyWj4uJXa"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);


        Thread.sleep(10000);

        driver.quit();
    }
}
