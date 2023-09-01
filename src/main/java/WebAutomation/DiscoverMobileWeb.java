package WebAutomation;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DiscoverMobileWeb {

    private AppiumDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "android");
//        caps.setCapability("deviceName", "Pixel.*");
//        caps.setCapability("platformVersion", "11");
//        caps.setCapability("isRealMobile", true);
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");
//        caps.setCapability("deviceOrientation", "landscape");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "Android");
        ltOptions.put("deviceName", "Pixel.*");
        ltOptions.put("build", "discover-debug");
        ltOptions.put("user","mohammadk");
        ltOptions.put("accessKey", "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd");
        // ltOptions.put("name", platform+" "+device+" "+version);
        ltOptions.put("isRealMobile", true);
        capabilities.setCapability("LT:Options", ltOptions);

        driver = new IOSDriver(new URL("https://mobile-hub.lambdatest.com/wd/hub"), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {

        String spanText;
        System.out.println("Loading Url");

        driver.get("https://www.discovercard.com/application/website/apply?srcCde=VP5V&envc=acceptanceproxy");
        scrollDown();
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



    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

}