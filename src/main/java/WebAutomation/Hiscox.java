package WebAutomation;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Hiscox {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "Pixel.*");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("isRealMobile", true);
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);



//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
////        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro");
//        capabilities.setCapability(MobileCapabilityType.UDID, "54D1D0C1-B53D-4ECD-811C-73E22C05A2FB");
//
//
//        URL url = new URL("http://127.0.0.1:4723");
//        driver = new IOSDriver(url, capabilities);


    }

    @Test
    public void basicTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://APIUAT.portal.hiscox.com/oneshield/GatewayExternalLinkServlet?partner=https://systest2.hiscox.com&oswt=StartQuoteConsumer&zipcode=30328");
        WebElement closeDialog = driver.findElement(By.xpath("//*[@id = 'onetrust-close-btn-container']"));
        closeDialog.click();

        WebElement dropdown1 = driver.findElement(
                By.cssSelector("input[osviewid='PAI_1149865_OT_205_OI_1_BI_1168365_CI_16420965']"));
        dropdown1.sendKeys("Accounting");

        WebElement el2 = driver.findElement(By.xpath("//input[@osviewid = 'PAI_1149865_OT_205_OI_1_BI_1168365_CI_16565865']"));
        el2.click();
        el2.clear();
        el2.sendKeys("Corporation");
        el2.sendKeys(Keys.ENTER);

        //scrollDown();
        //driver.hideKeyboard();




        WebElement el3 = driver.findElement(By.xpath("//input[@osviewid = 'PAI_1149865_OT_205_OI_1_BI_1168365_CI_16421165']"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(el3)).click();

        //el3.click();
        el3.clear();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//table[@id='ID289863581757_1244865_0-Label_289863581757_211195p33087465p4095-R19C0-picker-eventEl']")).click();
        //el3.sendKeys("07/28/2023");
        //driver.findElement(By.xpath("//*[text() = '6']")).click();




        Thread.sleep(5000);

        WebElement ctn = driver.findElement(By.xpath("//*[text() = 'Continue']"));
        System.out.println(ctn.isDisplayed());
        System.out.println(ctn.isEnabled());

        ctn.sendKeys(Keys.ENTER);

        scrollDown();

        Thread.sleep(5000);

        WebElement checkbox =
                driver.findElement(By.xpath("//*[@osviewid = 'PAI_1185565_OT_3378865_OI_1_CI_17217565_EC_1']"));

        System.out.println("CHECKBOX IS DISPLAYED>>>>>>>"+checkbox.isDisplayed());

        //driver.executeScript("arguments[0].scrollIntoView(true);", checkbox);
        checkbox.click();


        checkbox.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", checkbox);
        Thread.sleep(10000);



        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

        // cyber button
        WebElement cyber =
                driver.findElement(By.xpath("//*[@osviewid = 'PAI_1185565_OT_3358665_OI_2_CI_17219665_EC_111']"));

        driver.executeScript("arguments[0].scrollIntoView(true);", cyber);

        cyber.click();
//
//        System.out.println("IS selected..."+checkbox.isSelected());
//
//        Thread.sleep(5000);
////        System.out.println(driver.getPageSource());


        driver.findElement(By.xpath("//*[text() = 'Continue']")).sendKeys(Keys.ENTER);

        Thread.sleep(10000);


        Status = "passed";
    }

    @AfterMethod
    public void tearDown() {
        // driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction((AndroidDriver)driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4 / 5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

}
