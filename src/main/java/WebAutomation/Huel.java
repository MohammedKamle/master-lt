package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Huel {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "mohammadk";
        String authkey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "huel-debug");
        caps.setCapability("name", "sample-test");
        caps.setCapability("plugin", "git-testng");
        //caps.setCapability("region", "us");


        caps.setCapability( "selenium_version", "4.15.0");

        caps.setCapability("accessibility", true);
        caps.setCapability("accessibility.wcagVersion", "wcag21aa");
        caps.setCapability("accessibility.bestPractice", true);
        caps.setCapability("accessibility.needsReview", true);
        //caps.setCapability("autoHeal", true);
        //caps.setCapability("network", true);
        //caps.setCapability("network.full.har", true);
        //caps.setCapability("performance", true);
        //caps.setCapability("tunnel", true);




        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub"), caps);



    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        driver.get("https://uk.huel.com/");

        Status = "passed";
        Thread.sleep(30000);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.executeScript("lambda-build=" + "some-name-1");
        driver.quit();


    }

}