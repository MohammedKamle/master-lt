package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Veepee {

    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");


        String hub = "@hub.lambdatest.com/wd/hub";

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "121.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        //ltOptions.put("username", "mohammadk");
        //ltOptions.put("accessKey", "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Untitled");
        ltOptions.put("build", "veepe-debug-6th");
        capabilities.setCapability("LT:Options", ltOptions);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }

    @Test(invocationCount = 5)
    public void basicTest() throws InterruptedException {
        driver.get("https://br.privalia.com/public");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}