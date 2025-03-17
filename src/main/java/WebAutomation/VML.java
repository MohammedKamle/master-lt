package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VML {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//        String username = "mohammadk";
//        String authkey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";
//
//
//        String hub = "@hub.lambdatest.com/wd/hub";
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("version", "latest");
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", "sample-test");
//        caps.setCapability("plugin", "git-testng");
//        caps.setCapability("smartUI.project", "Coupa");
//        caps.setCapability("smartUI.baseline", false);
//
//
//        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
//        caps.setCapability("tags", Tags);
//
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;


        driver.get("file:///Users/mohammadk/Downloads/Lambdatest/cucumber-report/cucumber-html-reports/cucumber-html-reports/overview-features.html");


        List<WebElement> testNames = driver.findElements(By.xpath("//table[@id = 'tablesorter']//a"));

        System.out.println("SIZE :: "+testNames.size());

        for (WebElement name : testNames){
            System.out.println(name.getText());
        }

        System.out.println("==================================================");
        List<WebElement> durations = driver.findElements(By.xpath("//tbody[@aria-live= 'polite']//td[@class = 'duration']"));

        for (WebElement duration : durations){
            System.out.println(duration.getText());
        }


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}