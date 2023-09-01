package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Discover {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//        String username = "mohammadk";
//        String authkey = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";
//        String hub = "@hub.lambdatest.com/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("version", "113.0");
//        caps.setCapability("build", "discover-debug");
//        caps.setCapability("name", "sample-test");
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

        //BS
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("builName", "discover-debug");
//        caps.setCapability("browser_version", "113.0");
//        caps.setCapability("browserstack.user", "falconmagicleap_vci1oa");
//        caps.setCapability("browserstack.key", "D2o95qF5cHvPyWj4uJXa");
//        String bsHub = "http://hub.browserstack.com/wd/hub";
//        driver = new RemoteWebDriver(new URL(bsHub), caps);
//
        //local
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        driver.get("https://www.discovercard.com/application/website/apply?srcCde=VP5V&envc=acceptanceproxy");
        //skip
        driver.findElement(By.xpath("//*[text() = 'Skip This Step']")).click();
        //continue
       // driver.findElement(By.xpath("(//*[text() = 'Continue'])[1]")).click();


        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}