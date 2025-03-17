package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cadnet {

    private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username ="mohammadk";
        String authkey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "android");
//        caps.setCapability("deviceName", "Pixel.*");
//        caps.setCapability("platformVersion", "11");
//        caps.setCapability("isRealMobile", true);
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");
//        caps.setCapability("deviceOrientation", "landscape");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "ios");
        ltOptions.put("deviceName", "iPhone.*");



        ltOptions.put("build", "cadnet");
        ltOptions.put("user","mohammadk");
        ltOptions.put("accessKey", "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU");
        // ltOptions.put("name", platform+" "+device+" "+version);
        ltOptions.put("isRealMobile", true);
        capabilities.setCapability("LT:Options", ltOptions);

        driver = new IOSDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://cadentgas-dev.azurewebsites.net/");

        driver.findElement(By.xpath("//div[@class = 'hamburger-menu']")).click();

        driver.findElement(By.xpath("//a[normalize-space()='Emergencies']")).click();

        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}