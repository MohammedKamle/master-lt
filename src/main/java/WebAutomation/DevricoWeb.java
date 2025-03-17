package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DevricoWeb {

    protected static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();
    private String Status = "failed";


//    @Test()
//    public void basicTest() throws InterruptedException {
//        try {
//            String username ="mkamle86";
//            String authkey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";
//            ;
//            String hub = "@mobile-hub.lambdatest.com/wd/hub";
//
//
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "ios");
//            ltOptions.put("deviceName", ".*");
//            ltOptions.put("dedicatedProxy", true);
//            ///ltOptions.put("platformVersion", "14");
//            //ltOptions.put("browserName", "Chrome");
//            ltOptions.put("geoLocation", "GB");
//            //ltOptions.put("region", "us");
//            ltOptions.put("network", true);
//            ltOptions.put("network.full.har", true);
//            ltOptions.put("build", "devrico-web-ios-gb");
//            ltOptions.put("user","mkamle86");
//            ltOptions.put("accessKey", "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn");
//            // ltOptions.put("name", platform+" "+device+" "+version);
//            ltOptions.put("isRealMobile", true);
//
//            capabilities.setCapability("LT:Options", ltOptions);
//            threadLocalDriver.set(new RemoteWebDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities));
//            //driver = new RemoteWebDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities);
//
//            threadLocalDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            String spanText;
//            System.out.println("Loading Url");
//
////            threadLocalDriver.get().get("https://betway.com/g/en/sports?clean=true&lazy=false&next_ssr=false&location=ca");
////
////
////            threadLocalDriver.get().findElement(By.cssSelector("button:nth-child(2)"))
////                    .click();
////
//////        driver.findElement(By.cssSelector("[data-testid='login-menu-item']"))
//////                        .click();
////
////            Thread.sleep(2000);
////            threadLocalDriver.get().findElement(By.cssSelector("[data-name^='login'] input[type='text']"))
////                    .sendKeys("dvco_can_09");
////
////
////            threadLocalDriver.get().findElement(By.cssSelector("[data-name^='login'] input[type='password']"))
////                    .sendKeys("Password1234$");
////
////
////            threadLocalDriver.get().findElement(By.cssSelector("[data-name^='login'] [data-testid='login-button']"))
////                    .click();
////
////
////            threadLocalDriver.get().findElement(By.xpath("//*[text()='Deposit']"))
////                    .isDisplayed();
////
////            System.out.println("TestFinished");
//
//            threadLocalDriver.get().get("https://api.ipify.org/");
//            Thread.sleep(4000);
//            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
//            System.out.println(ip);
//
//            Status = "passed";
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            threadLocalDriver.get().executeScript("lambda-status=" + Status);
////            threadLocalDriver.get().get("https://api.ipify.org/");
////            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
////            System.out.println(ip);
//            threadLocalDriver.get().quit();
//        }
//
//
//    }

    @Test()
    public void basicTestForGB() throws InterruptedException {
        try {
            String username ="mkamle86";
            String authkey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";
            ;
            String hub = "@mobile-hub.lambdatest.com/wd/hub";


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "Android");
//            ltOptions.put("deviceName", ".*");
//            ltOptions.put("dedicatedProxy", true);
//            //ltOptions.put("appiumVersion", "2.0.0");
//            //ltOptions.put("fixedIP", "RZCW129BF0D");
//            ltOptions.put("platformVersion", "12");
//            ltOptions.put("browserName", "Chrome");
//            ltOptions.put("geoLocation", "DE");
//            //ltOptions.put("region", "us");
////            ltOptions.put("network", true);
////            ltOptions.put("network.full.har", true);
//            ltOptions.put("projectName", "yankee");
//            ltOptions.put("build", "debug-evolution");
//            ltOptions.put("user","mkamle86");
//            ltOptions.put("accessKey", "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn");
//            // ltOptions.put("name", platform+" "+device+" "+version);
//            ltOptions.put("isRealMobile", true);
//
//            capabilities.setCapability("LT:Options", ltOptions);
//            threadLocalDriver.set(new RemoteWebDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities));

            // Desktop
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("browserName", "chrome");
            caps.setCapability("version", "latest");
            caps.setCapability("build", "debug-evolution-1");
            caps.setCapability("name", "sample-test");
            caps.setCapability("plugin", "git-testng");
            caps.setCapability("name","same-x-c");
            caps.setCapability("dedicatedProxy", true);
            caps.setCapability("geoLocation", "ES");
            caps.setCapability("projectName", "yankee");
            threadLocalDriver.set(new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub"), caps));


            //driver = new RemoteWebDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities);

            threadLocalDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String spanText;
            System.out.println("Loading Url");

//            threadLocalDriver.get().get("https://betway.com/en/sports");
//
//
//            threadLocalDriver.get().findElement(By.cssSelector(".logo,.layout .topSiteLogo"))
//                    .isDisplayed();
//
//
//
//            System.out.println("TestFinished");
            threadLocalDriver.get().get("https://api.ipify.org/");
            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
            System.out.println(ip);
            Status = "passed";
        } catch (Exception e) {
            Status = "failed";
            threadLocalDriver.get().executeScript("lambda-status=" + Status);
            e.printStackTrace();
        } finally {

//            threadLocalDriver.get().get("https://api.ipify.org/");
//            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
//            System.out.println(ip);
            threadLocalDriver.get().executeScript("lambda-status=" + Status);
            threadLocalDriver.get().quit();
        }


    }

//    @Test(threadPoolSize = 20, invocationCount = 20)
//    public void basicTestForCAON() throws InterruptedException {
//        try {
//            String username ="mkamle86";
//            String authkey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";
//            ;
//            String hub = "@mobile-hub.lambdatest.com/wd/hub";
//
//
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "Android");
//            ltOptions.put("deviceName", ".*");
//            ltOptions.put("app", "lt://APP10160162101739802611825551");
//            ltOptions.put("dedicatedProxy", true);
//            ltOptions.put("autoGrantPermissions", true);
//            //ltOptions.put("fixedIP", "RFCW4145ZYA");
//            //ltOptions.put("platformVersion", "14");
//            //ltOptions.put("browserName", "Chrome");
//            ltOptions.put("geoLocation", "CA/ON");
//            ltOptions.put("region", "us");
////            ltOptions.put("network", true);
////            ltOptions.put("network.full.har", true);
//            ltOptions.put("build", "devrico-app-dp-CA/ON-itr2");
//            ltOptions.put("user","mkamle86");
//            ltOptions.put("accessKey", "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn");
//            // ltOptions.put("name", platform+" "+device+" "+version);
//            ltOptions.put("isRealMobile", true);
//
//            capabilities.setCapability("LT:Options", ltOptions);
//            threadLocalDriver.set(new AndroidDriver<>(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities));
//
//            // Desktop
////            DesiredCapabilities caps = new DesiredCapabilities();
////            caps.setCapability("platform", "Windows 10");
////            caps.setCapability("browserName", "chrome");
////            caps.setCapability("version", "latest");
////            caps.setCapability("build", "devrico-dektop-gb");
////            caps.setCapability("name", "sample-test");
////            caps.setCapability("plugin", "git-testng");
////            caps.setCapability("dedicatedProxy", true);
////            caps.setCapability("geoLocation", "GB");
////            threadLocalDriver.set(new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub"), caps));
//
//
//            //driver = new RemoteWebDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities);
//
//            threadLocalDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            String spanText;
//            System.out.println("Loading Url");
//
//
//            threadLocalDriver.get().startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
//            Thread.sleep(5000);
//            Set<String> contexts = threadLocalDriver.get().getContextHandles();
//            //System.out.println("Available contexts: " + contexts);
//
//            // Switch to WebView
//            for (String context : contexts) {
//                if (context.contains("WEBVIEW")) {
//                    threadLocalDriver.get().context(context);
//                 //   System.out.println("Switched to WebView: " + context);
//                    break;
//                }
//            }
//            Thread.sleep(3000);
//            threadLocalDriver.get().get("https://api.ipify.org/");
//
//            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
//            System.out.println(ip);
//            Assert.assertTrue(ip.equalsIgnoreCase("4.172.208.165"));
//
//
//            System.out.println("TestFinished");
//            Status = "passed";
//        } catch (Exception e) {
//            Status = "failed";
//            threadLocalDriver.get().executeScript("lambda-status=" + Status);
//            e.printStackTrace();
//        } finally {
//
////            threadLocalDriver.get().get("https://api.ipify.org/");
////            String ip = threadLocalDriver.get().findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
////            System.out.println(ip);
//            threadLocalDriver.get().executeScript("lambda-status=" + Status);
//            threadLocalDriver.get().quit();
//        }
//

    }

