package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ioco {

    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");


        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "ioco-debug");
        caps.setCapability("name", "sample-test");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("timezone","Berlin");



        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void basicTest() throws InterruptedException {

        driver.get("https://oneplus-uat.e-toyota.co.za/");

        System.out.println("Session ID :: "+driver.getSessionId());

        driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("D2221256");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("3NI98442021");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(20000);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}