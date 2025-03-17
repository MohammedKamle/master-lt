package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.layertree.LayerTree;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class AhNl {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    //AndroidDriver driver;
    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();
    boolean isBSSession;

    @Test(invocationCount = 10, threadPoolSize = 10)
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", false);
//            ltOptions.put("devicelog", true);
//            ltOptions.put("console", false);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Galaxy.*");
//            //^(?!.*Tab).*
//            //ltOptions.put("platformVersion", "(16.*),(14.*),(15.*),(17.*)");
//            ltOptions.put("platformVersion", "13");
//            // new lt://APP10160541811717764121977817
//            ltOptions.put("app", "lt://APP10160352241718811943485355");
//            //ltOptions.put("app", "lt://APP1016025931715779582402477");
//            ltOptions.put("resignApp", false);
//            ltOptions.put("appiumVersion", "1.22.3");
//            ltOptions.put("build", "android-app-luanch-issue-with- Galaxy.*-b");
//            ltOptions.put("autoGrantPermissions", true);
//            //ltOptions.put("settings[waitForIdleTimeout]", 1);
//            ltOptions.put("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            ltOptions.put("newCommandTimeout",240);
//            ltOptions.put("nativeWebScreenshot", true);
//
//            //ltOptions.put("waitForIdleTimeout", 1);
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("network", true);
//            ltOptions.put("visual", true);
//            ltOptions.put("video", true);
//
//           ltOptions.put("enableMultiWindows", true);
//           ltOptions.put("enableNetworkThrottling", false);
//            ltOptions.put("enableTopmostWindowFromActivePackage", true);
//            ltOptions.put("ignoreUnimportantViews", false);
//            ltOptions.put("includeExtrasInPageSource", true);
//           ltOptions.put("shouldUseCompactResponses", false);
//            ltOptions.put("extendedDebuging", true);
//            ltOptions.put("allowInvisibleElements", true);
//           //ltOptions.put("appWaitActivity","nl.ah.appie.app.timetravel.TimeTravelActivity");
//
//            //ltOptions.put("automationName", "XCUITest");
//           //ltOptions.put("noReset", true);
//
//
//
//           //ltOptions.put("fixedIP","R5CW13X0E7V");
//            capabilities.setCapability("lt:options", ltOptions);
//            String hub = "http://" + userName + ":" + accessKey + gridURL;
//            threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities))

            // WITHOUT W3C ON LT
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("w3c", false);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("console", false);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("deviceName", "Galaxy.*");
//^(?!.*Tab).*
//capabilities.setCapability("platformVersion", "(16.*),(14.*),(15.*),(17.*)");
            capabilities.setCapability("platformVersion", "13");
            //primary acc  lt://APP10160291931718953575297925
            // secondry acc lt://APP10160352241718811943485355
            capabilities.setCapability("app", "lt://APP10160352241718811943485355");
//capabilities.setCapability("app", "lt://APP1016025931715779582402477");
            capabilities.setCapability("resignApp", false);
            capabilities.setCapability("appiumVersion", "1.22.3");
            capabilities.setCapability("build", "resource-id-webview-issue-after-enabling-flag");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("settings[waitForIdleTimeout]", 1);
            capabilities.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
            capabilities.setCapability("newCommandTimeout", 240);
            capabilities.setCapability("nativeWebScreenshot", true);

//capabilities.setCapability("waitForIdleTimeout", 1);
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("network", true);
            capabilities.setCapability("visual", false);
            capabilities.setCapability("video", true);

            capabilities.setCapability("enableMultiWindows", true);
            capabilities.setCapability("enableNetworkThrottling", false);
            capabilities.setCapability("enableTopmostWindowFromActivePackage", true);
            capabilities.setCapability("ignoreUnimportantViews", false);
            capabilities.setCapability("includeExtrasInPageSource", true);
            capabilities.setCapability("shouldUseCompactResponses", false);
            //capabilities.setCapability("extendedDebugging", true);
            //capabilities.setCapability("allowInvisibleElements", true);

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities));


//

//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.0.0");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
//            bsCaps.setCapability("browserstack.networkLogs", "true");
//            bsCaps.setCapability("browserstack.networkProfile", "reset");
//            bsCaps.setCapability("app", "bs://8696c2a79225b6d82e1b38c418efcf170ce575c3");bs://8696c2a79225b6d82e1b38c418efcf170ce575c3
//            bsCaps.setCapability("build", "build-ahnl-ios-issue-june-14-with0direct-click");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoAccepAlerts", true);
//            bsCaps.setCapability("platformName", "ios");
//            bsCaps.setCapability("platformVersion", "16");
//
//
//
//            bsCaps.setCapability("deviceName", "iPhone 14");
//            bsCaps.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            bsCaps.setCapability("newCommandTimeout", 240);
//
//            bsCaps.setCapability("nativeWebScreenshot", true);
//             //extra caps
//            bsCaps.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            bsCaps.setCapability("enableMultiWindows", true);
//            bsCaps.setCapability("enableTopmostWindowFromActivePackage", true);
//            bsCaps.setCapability("ignoreUnimportantViews", false);
//            bsCaps.setCapability("includeExtrasInPageSource", true);
//            bsCaps.setCapability("settings[waitForIdleTimeout]", 0);
//            bsCaps.setCapability("shouldUseCompactResponses",false);
//            bsCaps.setCapability("interactiveDebugging", true);
//            bsCaps.setCapability("acceptSslCert", false);
//            bsCaps.setCapability("browserstack.appProfiling", false);
//            bsCaps.setCapability("localVersion", "8.9");
//            isBSSession = true;
//            bsCaps.setCapability("allowInvisibleElements", true);
//            bsCaps.setCapability("appWaitActivity","nl.ah.appie.app.timetravel.TimeTravelActivity");
//            bsCaps.setCapability("browserstack.resignApp", false);
//            bsCaps.setCapability("automationName", "XCUITest");
//            bsCaps.setCapability("noReset", true);
//
//
//           // driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//            threadLocalDriver.set(new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps));
////



            // WITHOUT W3C
//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//
//           // HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.0.0");
//         //   bsCaps.setCapability("bstack:options", browserstackOptions);
//            bsCaps.setCapability("browserstack.networkLogs", "true");
//            bsCaps.setCapability("app", "bs://8696c2a79225b6d82e1b38c418efcf170ce575c3");
//            bsCaps.setCapability("build", "build-ahnl-ios-issue");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoAccepAlerts", true);
//            bsCaps.setCapability("platformName", "ios");
//            bsCaps.setCapability("platformVersion", "14");
//
//
//
//
//            bsCaps.setCapability("deviceName", "iPhone.*");
//            bsCaps.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            bsCaps.setCapability("newCommandTimeout", 240);
//
//            bsCaps.setCapability("nativeWebScreenshot", true);
//            //extra caps
//            bsCaps.setCapability("elementResponseAttributes", "name,text,rect,enabled,displayed,selected");
//            bsCaps.setCapability("enableMultiWindows", true);
//            bsCaps.setCapability("enableTopmostWindowFromActivePackage", true);
//            bsCaps.setCapability("ignoreUnimportantViews", false);
//            bsCaps.setCapability("includeExtrasInPageSource", true);
//            bsCaps.setCapability("settings[waitForIdleTimeout]", 0);
//            bsCaps.setCapability("shouldUseCompactResponses",false);
//            bsCaps.setCapability("interactiveDebugging", true);
//                isBSSession = true;
//            bsCaps.setCapability("allowInvisibleElements", true);
//            bsCaps.setCapability("appWaitActivity","nl.ah.appie.app.timetravel.TimeTravelActivity");
//            bsCaps.setCapability("browserstack.resignApp", false);
//            bsCaps.setCapability("automationName", "XCUITest");
//            bsCaps.setCapability("noReset", true);
//
//
//            // driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//            threadLocalDriver.set(new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps));
////




            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//            WebElement element = threadLocalDriver.get().findElement(By.xpath("//android.widget.RadioButton[@text=\"TST\"]"));
//
//            element.click();

            threadLocalDriver.get().findElement(By.xpath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/menu_time_travel_start\"]")).click();
            threadLocalDriver.get().findElementByXPath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/accept_full_consent_button\"]").click();
            threadLocalDriver.get().findElementByXPath("//*[@content-desc=\"Inloggen\"]").click();
            System.out.println(threadLocalDriver.get().getPageSource());
            threadLocalDriver.get().findElementByXPath("//*[@resource-id=\"login\"]").click();
            threadLocalDriver.get().findElementByXPath("//*[@resource-id=\"password\"]").click();


            //String txt = "Via “Cookie-instellingen” kan je ook zelf instellen welke cookies worden geplaatst. Je kan je keuze altijd wijzigen of intrekken via Profiel > Instellingen > Cookie-Instellingen in de App.";
               // Thread.sleep(4000);
            //swipe(threadLocalDriver.get(), SwipeDirection.UP);


//
//            System.out.println("I am out of while loop");

//            scrollDown();
//            (new TouchAction(threadLocalDriver.get()))
//                    .press(PointOption.point(180, 414))
//                    .moveTo(PointOption.point(185, 227))
//                    .release()
//                    .perform();





//Thread.sleep(2000);


//            WebDriverWait wait = new WebDriverWait(threadLocalDriver.get(), 20); // 10 seconds timeout
//                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"Ik ga akkoord\"]")));
//
//                    element.click();

                //    threadLocalDriver.get().findElement(MobileBy.AccessibilityId("Ik ga akkoord")).click();
//            WebElement ele = threadLocalDriver.get().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Ik ga akkoord\"]"));
//            ele.click();
//            ele.getRect();
//            int centerX = ele.getRect().x + (ele.getSize().width / 2);
//            int centerY = ele.getRect().y + (ele.getSize().height / 2);
//            System.out.println("centerX" + centerX);
//            System.out.println("centerY" + centerY);
//            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            Sequence tap = new Sequence(finger, 1);
//            tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
//            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            threadLocalDriver.get().perform(Arrays.asList(tap));

//            Thread.sleep(2000);
//            WebElement element = threadLocalDriver.get().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Ik ga akkoord\"]"));
//            // Retrieve the rectangle dimensions of the element
//            int elementWidth = element.getSize().getWidth();
//            int elementHeight = element.getSize().getHeight();
//            Point elementLocation = element.getLocation();
//            int elementX = elementLocation.getX();
//            int elementY = elementLocation.getY();
//            // Calculate the center coordinates
//            int centerX = elementX + (elementWidth / 2);
//            int centerY = elementY + (elementHeight / 2);
//            // Perform the click action using TouchAction
//            TouchAction touchAction = new TouchAction(threadLocalDriver.get());
//            touchAction.tap(PointOption.point(centerX, centerY)).perform();


            //  System.out.println(threadLocalDriver.get().getPageSource());
           // threadLocalDriver.get().findElement(By.xpath("//XCUIElementTypeStaticText[normalize-space(@name)=\"Welkom bij Mijn Albert Heijn\"]"));
//
//            threadLocalDriver.get().findElement(By.xpath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/menu_time_travel_start\"]")).click();
//
//            threadLocalDriver.get().findElement(By.xpath("//*[@resource-id=\"com.icemobile.albertheijn.debug:id/accept_full_consent_button\"]")).click();
//
//            //driver.findElement(By.xpath("//*[@content-desc=\"Inloggen\"]")).click();
//
//            threadLocalDriver.get().findElement(MobileBy.AccessibilityId("Overslaan")).click();
//            Thread.sleep(3000);

           // WebDriverWait wait = new WebDriverWait(threadLocalDriver.get(), 20); // 10 seconds timeout


//            WebElement clockElementiOS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeImage[contains(@name,\"Icon/clock24\")]")));
//            clockElementiOS.click();

//            String xpath1 = "//XCUIElementTypeImage[contains(@name,\"Icon/clock24\")]";
//            String xpath2 = "//XCUIElementTypeOther[@name=\"ApplicatieVenster\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton";
//            MobileElement clkelem = findElementWithFallback(threadLocalDriver.get(), xpath1, xpath2);
//
//            if (clkelem != null) {
//                // Perform actions on the element
//                clkelem.click();
//            } else {
//                System.out.println("Element not found. Cannot perform actions.");
//            }


            //threadLocalDriver.get().findElement(By.xpath("")).click();

//
//            threadLocalDriver.get().findElement(By.xpath("//*[@text=\"Koken\"]")).click();
//
//            threadLocalDriver.get().findElement(By.xpath("//*[@class=\"android.widget.FrameLayout\" and ./parent::*[@content-desc=\"Koken\"]]/*[@class=\"android.widget.ImageView\"]")).click();
//
//            //Thread.sleep(5000);
//            threadLocalDriver.get().findElement(By.xpath("//*[@text=\"Zoek op ingrediënten of gerecht\"]")).click();
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.R));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.E));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.S));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.O));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.T));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.T));
//            threadLocalDriver.get().pressKey(new KeyEvent(AndroidKey.O));
//
//
//            //driver.findElement(By.xpath("//*[@text=\"Zoek op ingrediënt of gerecht\"]")).sendKeys("resotto");
//            Thread.sleep(2000);
//            threadLocalDriver.get().findElement(By.xpath("//*[@class=\"android.view.View\" and ./preceding-sibling::*[@content-desc=\"Filteroverzicht scherm\"]]")).click();
//            threadLocalDriver.get().findElement(By.xpath("//*[@class=\"android.view.View\" and ./*[@text=\"speciale wensen\"]]")).click();
//            Thread.sleep(2000);
//            threadLocalDriver.get().findElement(By.xpath("//*[@content-desc=\"Niet geselecteerd\" and ./following-sibling::*[@text=\"vegetarisch\"]]")).click();
//            threadLocalDriver.get().findElement(By.xpath("//*[@content-desc=\"Niet geselecteerd\" and ./following-sibling::*[@text=\"glutenvrij\"]]")).click();
//            threadLocalDriver.get().findElement(By.xpath("//*[@class=\"android.widget.Button\" and ./following-sibling::*[@text=\"Filteren\"]]")).click();
//
//            threadLocalDriver.get().findElement(By.xpath("//*[@class=\"android.view.View\" and ./*[@text=\"soort gerecht\"]]")).click();
//            Thread.sleep(2000);
//            //System.out.println(driver.getPageSource());
//            //*[@content-desc="Niet geselecteerd"]
//            //*[@class="android.widget.Button" and ./preceding-sibling::*[@text="3"]]
//            //*[@text="rijst"]
//
////            System.out.println("BEFORE -----------------");
////
////            driver.manage().logs().get("logcat").getAll().forEach(logEntry -> {
////                System.out.println(logEntry.getMessage());
////            });
//
////            int attempts = 0;
////            while(attempts < 5) {
////                try {
////                    WebDriverWait wait = new WebDriverWait(driver, 20); // 10 seconds timeout
////                    //Example: Wait for an element to be visible
////                    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[contains(@text,\"rijst\")])[1]")));
////                    element.click();
////                    break;
////                } catch(Exception e) {
////                    Thread.sleep(1000);
////                    attempts++;
////                }
////            }
//
//            WebDriverWait wait = new WebDriverWait(threadLocalDriver.get(), 20); // 10 seconds timeout
//             //Example: Wait for an element to be visible
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[contains(@text,\"rijst\")])[1]")));
//            element.click();

//            System.out.println("AFTER -----------------");
////
//            driver.manage().logs().get("logcat").getAll().forEach(logEntry -> {
//                System.out.println(logEntry.getMessage());
//            });



//             Create and configure the FluentWait object
//            FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(30))  // Maximum wait time
//                    .pollingEvery(Duration.ofSeconds(5))  // Frequency of checks
//                    .ignoring(NoSuchElementException.class);  // Ignoring specific exceptions
//
//            // Define the condition to wait for
//            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//                public WebElement apply(WebDriver driver) {
//                    return driver.findElement(By.xpath("(//android.widget.TextView[contains(@text,\"rijst\")])[1]"));  // Replace with your element's locator
//                }
//            });

            // Now you can interact with the element
           // element.click();

            //driver.findElement(By.xpath("(//android.widget.TextView[contains(@text,\"rijst\")])[1]")).click();







           // driver.findElement(By.xpath("//android.widget.TextView[@text=\"Voeg je eigen kookcreaties en recepten van andere websites toe\"]")).click();






         //   System.out.println(driver.getPageSource());

            //For BS
//           var email = driver.findElement(By.xpath("//*[@resource-id=\"login\"]"));
//           email.click();
//            driver.pressKey(new KeyEvent(AndroidKey.DEL));
//            email.clear();
//            email.sendKeys("appium-e2e-981cf04d-2c76-479f-9@appium.com");
//            var password = driver.findElement(By.xpath("//*[@resource-id=\"password\"]"));
//           password.click();
//            password.sendKeys("some-password");

//            Set<String> contextNames = driver.getContextHandles();
//            for (String contextName : contextNames) {
//                System.out.println(contextName);
//                if (contextName.contains("WEBVIEW_com.icemobile.albertheijn.debug")) {
//                    driver.context(contextName);
//                    break;
//                }
//            }

////
//            driver.findElement(By.xpath("//*[@class=\"android.widget.EditText\" and ./following-sibling::*[@text=\"E-mailadres\"]]")).sendKeys("some-email");
//            driver.findElement(By.xpath("//*[@class=\"android.widget.EditText\" and ./following-sibling::*[@text=\"Wachtwoord\"]]")).sendKeys("Passowrd");

//            driver.findElement(By.xpath("//*[@text=\"E-mailadres\"]")).sendKeys("some-email");
//            driver.findElement(By.xpath("//*[@class=\"text-input_input__GcwGY\" and ./following-sibling::*[@text=\"Wachtwoord\"]]")).sendKeys("password");









           // Thread.sleep(3000);
            if (!isBSSession){
                threadLocalDriver.get().executeScript("lambda-status=passed");
            }


            threadLocalDriver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                threadLocalDriver.get().executeScript("lambda-status=failed");
                threadLocalDriver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }

    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(threadLocalDriver.get());
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = threadLocalDriver.get().manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = threadLocalDriver.get().manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = threadLocalDriver.get().manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }
    public boolean isElementDisplayed(AndroidDriver driver) {
        try {
            WebElement element = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ik ga akkoord']"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public enum SwipeDirection {
        UP, DOWN, LEFT, RIGHT
    }
    public static void swipe(IOSDriver<MobileElement> driver, SwipeDirection direction) {
        Dimension size = driver.manage().window().getSize();
        int startX, startY, endX, endY;

        switch (direction) {
            case UP:
                startX = size.width / 2;
                startY = (int) (size.height * 0.65);
                endX = size.width / 2;
                endY = (int) (size.height * 0.2);
                break;

            case DOWN:
                startX = size.width / 2;
                startY = (int) (size.height * 0.2);
                endX = size.width / 2;
                endY = (int) (size.height * 0.8);
                break;

            case LEFT:
                startX = (int) (size.width * 0.8);
                startY = size.height / 2;
                endX = (int) (size.width * 0.2);
                endY = size.height / 2;
                break;

            case RIGHT:
                startX = (int) (size.width * 0.2);
                startY = size.height / 2;
                endX = (int) (size.width * 0.8);
                endY = size.height / 2;
                break;

            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public static MobileElement findElementWithFallback(AppiumDriver<MobileElement> driver, String xpath1, String xpath2) {
        try {
            MobileElement element = driver.findElementByXPath(xpath1);
            System.out.println("Element found using xpath1: " + xpath1);
            return element;
        } catch (NoSuchElementException e1) {
            try {
                MobileElement element = driver.findElementByXPath(xpath2);
                System.out.println("Element found using xpath2: " + xpath2);
                return element;
            } catch (NoSuchElementException e2) {
                System.out.println("Element not found using both xpaths");
                return null;
            }
        }
    }


}
