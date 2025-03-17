//package WebAutomation;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.ITestContext;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class Specsavers {
//
//    private RemoteWebDriver driver;
//
//
//    @BeforeMethod
//    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//        String username = "mobileautoservic_w86Uka";
//        String authkey = "SeW8HQo2LzzoUw9qsDK8";
//
//
//        String hub = "@hub.browserstack.com/wd/hub";
//
////        MutableCapabilities capabilities = new MutableCapabilities();
////        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
////        capabilities.setCapability("browserName", "Chrome");
////        bstackOptions.put("os", "Windows");
////        bstackOptions.put("osVersion", "10");
////        bstackOptions.put("browserVersion", "123.0");
////        bstackOptions.put("buildName", "mdk-debug-specsavers");
////        bstackOptions.put("consoleLogs", "info");
////        capabilities.setCapability("bstack:options", bstackOptions);
//
////        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("browserName", "Chrome");
////        capabilities.setCapability("browserVersion", "123");
////        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
////        bstackOptions.put("platformName", "Windows 10");
////        bstackOptions.put("build", "mdk-debug-specsavers-canada-hub");
////        bstackOptions.put("consoleLogs", "info");
////        capabilities.setCapability("LT:Options", bstackOptions);
//
////        ChromeOptions browserOptions = new ChromeOptions();
////        browserOptions.setPlatformName("Windows 10");
////        browserOptions.setBrowserVersion("123");
////        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
////        ltOptions.put("username", "mohammadk");
////        ltOptions.put("accessKey", "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU");
////        ltOptions.put("project", "Untitled");
////        ltOptions.put("selenium_version", "4.12.0");
////        ltOptions.put("w3c", true);
////        browserOptions.setCapability("LT:Options", ltOptions);
//
//        username = "mohammadk";
//        authkey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";
//        hub = "@hub.lambdatest.com/wd/hub";
//
//
//
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), browserOptions);
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//// BS - 12.7
//    // LT - 6.5
//    @Test(invocationCount = 1)
//    public void basicTest() throws InterruptedException {
//        driver.get("https://duckduckgo.com/");
//        WebElement ele = driver.findElement(By.cssSelector("#searchbox_input"));
//        ele.sendKeys("Specsavers");
//        ele.submit();
//
//        WebElement link = driver.findElement(By.cssSelector("body.body--serp:nth-child(2) div.site-wrapper.js-site-wrapper:nth-child(13) div.content-wrap:nth-child(6) div.h3EKGeHmRRkjbMqYfNUi.wuwdN2SgDOTwsnBO5PI7.rXBzGoYc_uM83jRoODrM.xWVFEW_kM7bYLASLNfsZ div.FMPme3X940xAt4SKPFuw section.At_VJ9MlrHsSjbfCtz2_.aDtqDaYogch0DyrGTrX6 ol.react-results--main:nth-child(1) li.wLL07_0Xnd1QZpzpfR4W:nth-child(2) article.yQDlj3B5DI5YO8c8Ulio.CpkrTDP54mqzpuCSn1Fa.SKlplDuh9FjtDprgoMxk div.ikg2IXiCD14iVX7AdZo1 h2.LnpumSThxEWMIsDdAT17.CXMyPcQ6nDv47DKFeywM a.eVNpHGjtxRBq_gLOfGDr.LQNqh2U1kzYxREs65IJu > span.EKtkFWMYpwzMKOYr0GYm.LQVY1Jpkk8nyJ6HBWKAk"));
//
//        if (link.isDisplayed()){
//            System.out.println("TEST PASSED");
//        }
//    }
//
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//}