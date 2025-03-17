package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Autozone {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "jagadish.chandraiah";
        String authkey = "0jq98zpwjJO8ofOCezByWeReW7fwJyvKd2jN03tZVlKVw2pcQW";

        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "macOS Sonoma");
        caps.setCapability("browserName", "safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "debug");
        caps.setCapability("name", "sample-test");
        caps.setCapability("plugin", "git-testng");
        //caps.setCapability("autoHeal", true);
        caps.setCapability("network", true);
        //
        // caps.setCapability("network.full.har", true);
        //caps.setCapability("performance", true);
        caps.setCapability("tunnel", true);
        caps.setCapability("tunnelIdentifier", "Lambdatest");
        caps.setCapability("tunnelName", "Lambdatest");




        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        driver.get("http://www-staging.autozone.com/");

        // To start a test case


        Status = "passed";
        Thread.sleep(4000);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}