package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class PrivateDevice {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void iosPrivate() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone 13");
            //ltOptions.put("platformVersion", "15");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("queueTimeout", 900);
            ltOptions.put("idleTimeout", 900);
            ltOptions.put("video", true);
            //ltOptions.put("visual", true);
            //ltOptions.put("network", true);
            ltOptions.put("devicelog", true);
            ltOptions.put("build", "ApplePayParagNew");
            //  ApplePay Capabilities
            ltOptions.put("privateCloud", true);
            ltOptions.put("applePay", true);
            ltOptions.put("passcode", "180719");
            ltOptions.put("applePayCardType", new String[] { "visa" });
            capabilities.setCapability("lt:options", ltOptions);

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.get("https://applepaydemo.apple.com/");
            Thread.sleep(5000);
            String pageSource = driver.getPageSource();
            WebElement ele = driver.findElement(By.id("transcriptButton"));
            ele.getRect();
            int centerX = ele.getRect().x + (ele.getSize().width / 2);
            int centerY = ele.getRect().y + (ele.getSize().height / 2);
            System.out.println("centerX" + centerX);
            System.out.println("centerY" + centerY);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(tap));

            //tapByCoordinates(driver, 0.5, 0.5);

            JSONObject json = new JSONObject();
            json.put("confirm", true);
            ((JavascriptExecutor) driver).executeScript("lambda-applepay", json);
            new Actions(driver).sendKeys("180719").perform();
            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }


    public static void tapByCoordinates(AppiumDriver<MobileElement> driver, double xPercentage, double yPercentage) {
        // Get the screen size of the device
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Calculate coordinates as percentages of screen size
        int xCoordinate = (int) (screenWidth * xPercentage);
        int yCoordinate = (int) (screenHeight * yPercentage);

        // Create a TouchAction instance
        TouchAction touchAction = new TouchAction(driver);

        // Tap at the calculated coordinates
        touchAction.tap(PointOption.point(xCoordinate, yCoordinate)).perform();
    }
}
