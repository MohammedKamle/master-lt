package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class HooksTest {

    String userName = "mohammadk";
    String accessKey = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Pixel.*");

        //ltOptions.put("platformVersion", version);
        ltOptions.put("app", "proverbial-android");
        ltOptions.put("appiumVersion", "2.0");
        ltOptions.put("build", "Java TestNG Android");
        //ltOptions.put("smartUI.project", "md-rd-1");

        // ltOptions.put("name", platform+" "+device+" "+version);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("project", "android");
        ltOptions.put("network", true);
        ltOptions.put("autoAccepAlert", true);
        ltOptions.put("autoGrantPermission", true);
        capabilities.setCapability("lt:options", ltOptions);
        capabilities.setCapability("tags", new String[] {"regression", "android"});


        String hub = "https://" + userName + ":" + accessKey + gridURL;
        driver = new AndroidDriver(new URL(hub), capabilities);
    }

    @Test(priority = 1)
    public void test1(Method m) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("lambda-testCase-start=test 1");

        MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            //Changes color to pink
            color.click();
            Thread.sleep(1000);

            //Back to orginal color
            color.click();

        ((JavascriptExecutor) driver).executeScript("lambda-testCase-end=test 1");

    }

    @Test(priority = 2)
    public void test2() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("lambda-testCase-start=test2");
        MobileElement text = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/Text");
        //Changes the text to "Proverbial"
        text.click();
       // ((JavascriptExecutor) driver).executeScript("lambda-testCase-end=test2");
    }

    @Test(priority = 3)
    public void test3() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("lambda-testCase-start=test3");
        //toast will be visible
        MobileElement toast = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/toast");
        toast.click();

       // ((JavascriptExecutor) driver).executeScript("lambda-testCase-end=test3");
    }

    @AfterClass
    public void testDown(){
        driver.quit();
    }
}
