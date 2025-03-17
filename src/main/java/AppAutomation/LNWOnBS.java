package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class LNWOnBS {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";


    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();
    AppiumDriver driver = null;

    @Test
    public void test2() throws MalformedURLException, InterruptedException {

        try {
            //        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("w3c", true);
//        ltOptions.put("devicelog", true);
//        ltOptions.put("platformName", "android");
//        ltOptions.put("deviceName", "Galaxy S24");
//        ltOptions.put("platformVersion", "14");
//        ltOptions.put("app", "lt://APP10160321281723464481369557");
//        ltOptions.put("isRealMobile", true);
//        ltOptions.put("build", "LNW-2.4.1");
//        ltOptions.put("appiumVersion", "2.4.1");
//        ltOptions.put("autoGrantPermissions", true);
//        ltOptions.put("unicodeKeyboard", true);
//        ltOptions.put("visual", true);
//        ltOptions.put("resetKeyboard", true);
//        ltOptions.put("nativeWebScreenshot", true);
//        ltOptions.put("allowInvisibleElements", true);
//        capabilities.setCapability("lt:options", ltOptions);
//        String hub = "http://" + userName + ":" + accessKey + gridURL;

            //driver = new AndroidDriver(new URL(hub), capabilities);


            DesiredCapabilities bsCaps = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("appiumVersion", "2.4.1");
            bsCaps.setCapability("bstack:options", browserstackOptions);
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("platformVersion", "16");
//        capabilities.setCapability("deviceName", "iPhone 14");
            //bsCaps.setCapability("browserstack.networkLogs", "true");
            //ios
//        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
            //android
            bsCaps.setCapability("app", "bs://7360b0b60aff8912a91477b3db47b703d578f4e7");
            bsCaps.setCapability("build", "build-lnw");
            bsCaps.setCapability("name", "debug");
            bsCaps.setCapability("autoGrantPermissions", true);
            bsCaps.setCapability("platformName", "android");
            bsCaps.setCapability("platformVersion", "14.0");
            bsCaps.setCapability("deviceName", "Samsung Galaxy S24");
            bsCaps.setCapability("interactiveDebugging", true);

            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);








            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            Map<String, Object> settings = new HashMap<>();
            settings.put("imageMatchThreshold", 0.8);
            driver.setSettings(settings);

            Map<String, Object> settings1 = new HashMap<>();
            settings1.put("imageElementTapStrategy", "w3cActions");
            driver.setSettings(settings1);

            Map<String, Object> settings2 = new HashMap<>();
            settings2.put("fixImageTemplateSize", true);
            driver.setSettings(settings2);

            Map<String, Object> settings3 = new HashMap<>();
            settings3.put("fixImageTemplateScale", true);
            driver.setSettings(settings3);

            Map<String, Object> settings4 = new HashMap<>();
            settings4.put("getMatchedImageResult", true);
            driver.setSettings(settings4);

            Map<String, Object> settings5 = new HashMap<>();
            settings5.put("checkForImageElementStaleness", false);
            driver.setSettings(settings5);

            Map<String, Object> settings6 = new HashMap<>();
            settings6.put("allowInvisibleElements", true);
            driver.setSettings(settings6);


            Map<String, Object> settings7 = new HashMap<>();
            settings7.put("ignoreUnimportantViews", true);
            driver.setSettings(settings7);


            Map<String, Object> settings8 = new HashMap<>();
            settings8.put("nativeWebTap", true);
            driver.setSettings(settings8);



            driver.findElements(By.xpath("//*[@text='SKIP']"));
            driver.findElements(By.xpath("//*[@text='SKIP']"));
            driver.findElement(By.xpath("//*[@text='SKIP']")).click();
//
//        driver.findElements(By.xpath("//*[@text='OK']"));
//        driver.findElements(By.xpath("//*[@text='OK']"));
//        driver.findElement(By.xpath("//*[@text='OK']")).click();
//
//        driver.findElements(By.xpath("//*[@text='While using the app']"));
//        driver.findElements(By.xpath("//*[@text='While using the app']"));
//        driver.findElement(By.xpath("//*[@text='While using the app']")).click();

//        driver.findElements(By.xpath("//*[@text='Allow']"));
//        driver.findElements(By.xpath("//*[@text='Allow']"));
//        driver.findElement(By.xpath("//*[@text='Allow']")).click();

            driver.findElement(By.xpath("//*[@resource-id='rightAction']"));

            driver.findElement(By.xpath("//*[@resource-id='rightAction']")).isDisplayed();

            driver.findElement(By.xpath("//*[@resource-id='btnLogin']"));
            driver.findElement(By.xpath("//*[@resource-id='btnLogin']")).click();


            driver.findElement(By.xpath("//*[@text='JOIN NOW']"));

            driver.findElement(By.xpath("//*[@text='JOIN NOW']")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Email Address']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Email Address']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Email Address']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Email Address']")).sendKeys("AutolnyHvK@cIMNMa.com");
            //AutolnyHvK@cIMNMa.com
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Email Address']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Email Address']")).isDisplayed();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Email Address']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Email Address']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Email Address']")).sendKeys("AutolnyHvK@cIMNMa.com");

            driver.findElement(By.xpath("//*[@hint='Password']"));
            driver.findElement(By.xpath("//*[@hint='Password']")).isEnabled();
            driver.findElement(By.xpath("//*[@hint='Password']")).clear();
            driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("Test1234");


            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Password']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Password']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Password']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Confirm Password']")).sendKeys("Test1234");

            //driver.findElementByAccessibilityId("Next").click();
            driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Next\"])[1]")).click();


            driver.findElement(By.xpath("//*[@text='2. Your personal details']"));
            driver.findElement(By.xpath("//*[@text='2. Your personal details']")).isDisplayed();

            driver.findElement(By.xpath("//*[@text='2. Your personal details']"));
            driver.findElement(By.xpath("//*[@text='2. Your personal details']")).isDisplayed();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='First Name']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='First Name']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='First Name']")).sendKeys("AutoDrBl");
            //AutoDrBl
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Last Name']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Last Name']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Last Name']")).sendKeys("abc");


            driver.findElement(By.xpath("//*[@text='Gender']//following-sibling::android.view.View"));
            driver.findElement(By.xpath("//*[@text='Gender']//following-sibling::android.view.View")).click();

            driver.findElement(By.xpath("//*[@text='Male']"));
            driver.findElement(By.xpath("//*[@text='Male']")).click();

            driver.findElement(By.xpath("//*[@text='MM']"));
            driver.findElement(By.xpath("//*[@text='MM']")).click();

            driver.findElement(By.xpath("//*[@text='January']"));
            driver.findElement(By.xpath("//*[@text='January']")).click();

            driver.findElement(By.xpath("//*[@text='DD']"));
            driver.findElement(By.xpath("//*[@text='DD']")).click();

            driver.findElement(By.xpath("//*[@text='5']"));
            driver.findElement(By.xpath("//*[@text='5']")).click();

            driver.findElement(By.xpath("//*[@text='YYYY']//following-sibling::android.view.View"));
            driver.findElement(By.xpath("//*[@text='YYYY']//following-sibling::android.view.View")).click();

            driver.findElement(By.xpath("//*[@text='1995']"));
            driver.findElement(By.xpath("//*[@text='1995']")).click();

            driver.findElement(By.xpath("(//android.view.View[@content-desc='Next'])[2]"));
            driver.findElement(By.xpath("(//android.view.View[@content-desc='Next'])[2]")).isDisplayed();
            driver.findElement(By.xpath("(//android.view.View[@content-desc='Next'])[2]")).click();

            driver.findElement(By.xpath("//*[@text='3. Your Contact Details']"));
            driver.findElement(By.xpath("//*[@text='3. Your Contact Details']")).isDisplayed();

            driver.findElement(By.xpath("//*[@text='3. Your Contact Details']"));
            driver.findElement(By.xpath("//*[@text='3. Your Contact Details']")).isDisplayed();

            driver.findElement(By.xpath("//*[@text='United States of America']"));
            driver.findElement(By.xpath("//*[@text='United States of America']")).isDisplayed();
            driver.findElement(By.xpath("//*[@text='United States of America']"));
            driver.findElement(By.xpath("//*[@text='United States of America']")).isDisplayed();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 1']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 1']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 1']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 1']")).sendKeys("qIEYQ");

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 2']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 2']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 2']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Address Line 2']")).sendKeys("NUJNV");


            driver.findElement(By.xpath("//android.widget.EditText[@hint='City']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='City']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='City']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='City']")).sendKeys("Trenton");

            driver.findElement(By.xpath("//*[@text='State']//following-sibling::android.view.View"));
            driver.findElement(By.xpath("//*[@text='State']//following-sibling::android.view.View")).click();

            driver.findElement(By.xpath("//*[@text='Alaska']"));
            driver.findElement(By.xpath("//*[@text='Alaska']")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Zip code']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Zip code']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Zip code']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Zip code']")).sendKeys("08611");


            scrollDown2();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Mobile number']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Mobile number']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Mobile number']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Mobile number']")).sendKeys("5423032000");

            driver.findElement(By.xpath("//*[@text='Security Question 1']//following-sibling::android.view.View")).click();

            driver.findElement(By.xpath("//*[@text='What is your favorite sports team?']")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 1']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 1']")).isEnabled();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 1']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 1']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 1']")).sendKeys("Mps");

            driver.findElement(By.xpath("//*[@text='Security Question 2']//following-sibling::android.view.View"));
            driver.findElement(By.xpath("//*[@text='Security Question 2']//following-sibling::android.view.View")).click();

            driver.findElement(By.xpath("//*[@text='In what city did you meet your spouse/significant other?']"));
            driver.findElement(By.xpath("//*[@text='In what city did you meet your spouse/significant other?']")).click();


            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 2']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 2']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 2']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Security Answer 2']")).sendKeys("Mps");


            scrollDown2();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='Did you receive a bonus code to join? Enter it here (optional).']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Did you receive a bonus code to join? Enter it here (optional).']")).isDisplayed();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Did you receive a bonus code to join? Enter it here (optional).']"));
            driver.findElement(By.xpath("//android.widget.EditText[@hint='Did you receive a bonus code to join? Enter it here (optional).']")).isDisplayed();


            driver.findElement(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']"));
            driver.findElement(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']")).isDisplayed();
            driver.findElement(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']"));
            driver.findElement(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']")).isDisplayed();
            driver.findElement(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']")).click();

            driver.findElement(By.xpath("//*[@text='I certify that all information provided during account registration is true and accurate, and that I am not prohibited from engaging in sports wagering activities.']"));
            driver.findElement(By.xpath("//*[@text='I certify that all information provided during account registration is true and accurate, and that I am not prohibited from engaging in sports wagering activities.']")).click();

            driver.findElement(By.xpath("//android.widget.CheckBox[@text='I hereby acknowledge that I am prohibited from allowing any other person to access or use my gaming account']"));
            driver.findElement(By.xpath("//android.widget.CheckBox[@text='I hereby acknowledge that I am prohibited from allowing any other person to access or use my gaming account']")).click();

            scrollDown2();

            driver.findElement(By.xpath("//*[@text='Join now']"));
            driver.findElement(By.xpath("//*[@text='Join now']")).isDisplayed();

            driver.findElement(By.xpath("//*[@text='Join now']")).click();
            driver.getContextHandles();
            driver.context("NATIVE_APP");
            driver.getPageSource();


            driver.findElement(By.xpath("//*[@text='Proceed']")).click();
//
//    WebDriverWait Wait = new WebDriverWait(   driver, 30);
//    Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Proceed']"))).click();

//    driver.findElement(By.xpath("//*[@text='Proceed']"));
//    driver.findElement(By.xpath("//*[@text='Proceed']")).isDisplayed();










            driver.quit();



        }finally {
            //driver.findElement(By.xpath("//*[@text='Proceed']")).click();
            driver.quit();
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
        int bottomY = threadLocalDriver.get().manage().window().getSize().height /4;
        // just non zero point, as it didn't scroll to zero normally
        int topY = threadLocalDriver.get().manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

    private void scroll1(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(threadLocalDriver.get());
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown1() {
        //if pressX was zero it didn't work for me
        int pressX = threadLocalDriver.get().manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = threadLocalDriver.get().manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = threadLocalDriver.get().manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

    private void scroll2(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    private void scrollDown2() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll2(pressX, bottomY, pressX, topY);
    }


}
