package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LBS {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "mohammadk";
        String authkey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

        String hub = "@mobile-hub.lambdatest.com/wd/hub";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("version", "latest");
//        caps.setCapability("build", "TestNG With Java1");
//        caps.setCapability("name", "sample-test");
//        caps.setCapability("plugin", "git-testng");
//        caps.setCapability("timezone", "Colombo");
//        //caps.setCapability("autoHeal", true);
//        //caps.setCapability("network", true);
//        //caps.setCapability("network.full.har", true);
//        //caps.setCapability("performance", true);
//        //caps.setCapability("tunnel", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "ios");
        ltOptions.put("deviceName", "iPhone 14");

        //ltOptions.put("appiumVersion", "2.0.0");
        ltOptions.put("build", "lbs-debug");

        // ltOptions.put("name", platform+" "+device+" "+version);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("project", "android");

        ltOptions.put("network", true);

        capabilities.setCapability("lt:options", ltOptions);



        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        driver.get("https://uat-btl.leedsbuildingsociety.co.uk/");

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("testinglbsltdco23@leedsbuildingsociety.co.uk");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password1!");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='btn btn-primary link_btn landingPageBtn yellowBtn'][normalize-space()='New Application']")).click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//body/div[2]/form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]")).click();
        //driver.findElement(By.xpath("//div[@class='bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-id-Application_TermsAndCondition bootstrap-switch-animate bootstrap-switch-off']//span[@class='bootstrap-switch-handle-off bootstrap-switch-default'][normalize-space()='No']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-off bootstrap-switch-id-Application_CreditCheckConsent bootstrap-switch-animate']//span[@class='bootstrap-switch-handle-off bootstrap-switch-default'][normalize-space()='No']")).click();


        driver.findElement(By.xpath("//button[contains(@class,'btnNavRight blueBtn')]")).click();

        Thread.sleep(3000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//*[text() = 'Yes']")).click();

        Thread.sleep(3000);

       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//*[text() = 'Yes']")).click();

        Thread.sleep(3000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//*[text() = 'Yes']")).click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("//button[contains(@class,'btnNavRight blueBtn')]")).click();


//
//      //  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//*[text() = 'Yes']")).click();
//
//        driver.findElement(By.xpath("//*[text() = 'Yes']")).click();
//
//        driver.findElement(By.xpath("//button[contains(@class,'btnNavRight blueBtn')]")).click();
//
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        driver.findElement(By.xpath("//*[text() = 'No']")).click();





        // To start a test case

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}