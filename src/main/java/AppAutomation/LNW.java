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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class LNW {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";


    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();
    AppiumDriver driver = null;
    @Test
    public void AndroidApp1() {
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("devicelog", true);
//
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S24");

            ltOptions.put("platformVersion", "14");

            ltOptions.put("app", "lt://APP10160321281723464481369557");
//
            ltOptions.put("isRealMobile", true);
           // ltOptions.put("autoAcceptAlerts",true);
//
            ltOptions.put("build", "LNW-2.4.1");
//
            //ltOptions.put("appiumVersion", "2.4.1");
            ltOptions.put("appiumVersion", "2.11.2");



            ltOptions.put("autoGrantPermissions", true);
            ltOptions.put("unicodeKeyboard", true);
            ltOptions.put("visual", true);
            ltOptions.put("resetKeyboard", true);

            ltOptions.put("nativeWebScreenshot", true);

            ltOptions.put("allowInvisibleElements", true);
//            ltOptions.put("imageMatchThreshold", "0.8");
//            ltOptions.put("imageElementTapStrategy", "w3cActions");
//            ltOptions.put("fixImageTemplateSize", true);
//            ltOptions.put("fixImageTemplateScale",true);
//            ltOptions.put("getMatchedImageResult", true);
//            ltOptions.put("checkForImageElementStaleness",false);
//            ltOptions.put("ignoreUnimportantViews", true);
//            ltOptions.put("nativeWebTap", true);
            //ltOptions.put("enableMultiWindows", true);


//            ltOptions.put("enableNetworkThrottling", false);
//            //ltOptions.put("enableTopmostWindowFromActivePackage", true);
//            ltOptions.put("ignoreUnimportantViews", false);
//            ltOptions.put("includeExtrasInPageSource", true);
//            ltOptions.put("shouldUseCompactResponses", false);


//
            capabilities.setCapability("lt:options", ltOptions);
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            threadLocalDriver.set(new AndroidDriver(new URL(hub), capabilities));



            threadLocalDriver.get().hideKeyboard();


            WebDriverWait Wait = new WebDriverWait(   threadLocalDriver.get(), 30);
            Thread.sleep(3000);

            threadLocalDriver.get().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

            Map<String, Object> settings = new HashMap<>();
            settings.put("imageMatchThreshold", 0.8);
            threadLocalDriver.get().setSettings(settings);

            Map<String, Object> settings1 = new HashMap<>();
            settings1.put("imageElementTapStrategy", "w3cActions");
            threadLocalDriver.get().setSettings(settings1);

            Map<String, Object> settings2 = new HashMap<>();
            settings2.put("fixImageTemplateSize", true);
            threadLocalDriver.get().setSettings(settings2);

            Map<String, Object> settings3 = new HashMap<>();
            settings3.put("fixImageTemplateScale", true);
            threadLocalDriver.get().setSettings(settings3);

            Map<String, Object> settings4 = new HashMap<>();
            settings4.put("getMatchedImageResult", true);
            threadLocalDriver.get().setSettings(settings4);

            Map<String, Object> settings5 = new HashMap<>();
            settings5.put("checkForImageElementStaleness", false);
            threadLocalDriver.get().setSettings(settings5);

            Map<String, Object> settings6 = new HashMap<>();
            settings6.put("allowInvisibleElements", true);
            threadLocalDriver.get().setSettings(settings6);


            Map<String, Object> settings7 = new HashMap<>();
            settings7.put("ignoreUnimportantViews", true);
            threadLocalDriver.get().setSettings(settings7);


            Map<String, Object> settings8 = new HashMap<>();
            settings8.put("nativeWebTap", true);
            threadLocalDriver.get().setSettings(settings8);

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"SKIP\"]"))).click();
            Thread.sleep(5000);
//            Wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[@text=\"OK\"]"))).click();
//            Wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]"))).click();
//            Wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("/*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Login\"]"))).click();
            Thread.sleep(10000);
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"JOIN NOW\"]"))).click();
            Thread.sleep(10000);
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Email Address']"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Email Address']"))).sendKeys("abc@email.com");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Confirm Email Address']"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Confirm Email Address']"))).sendKeys("abc@email.com");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Password']"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Password']"))).sendKeys("Mxtuvw86@azim");

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Confirm Password']"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Confirm Password']"))).sendKeys("Mxtuvw86@azim");


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Next\"]"))).click();

            Thread.sleep(4000);

           scrollDown();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='First Name']"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='First Name']"))).sendKeys("abs");
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@hint='Last Name']"))).sendKeys("abs");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Last Name']"))).click();


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Gender\" and ./preceding-sibling::*[@text=\"Gender\"]]"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Male\"]"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"MM\" and @class=\"android.view.View\"]"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"January\"]"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"YYYY\" and @class=\"android.view.View\"]"))).click();
            scrollDown();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"1995\"]"))).click();
            //Thread.sleep(5000);
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='DD']"))).click();
           // Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id=\"id_birth_date_day\"]"))).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"2\"]"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Next\"]"))).click();

            scrollDown();

            //new code
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.View[@content-desc=\"Next\"])[2]/android.widget.TextView"))).click();
            scrollDown();
            scrollDown();
//
//            Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_address_line_2"))).sendKeys("abc");
//            Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_state"))).click();
                //
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"android.widget.EditText\" and ./following-sibling::*[@text=\"Address Line 2\"]]"))).sendKeys("abc");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"android.view.View\" and ./parent::*[@text=\"Sign-up - TropicanaCasino.com\"]]/*[2]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[6]"))).sendKeys("abc");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id=\"id_city\"]"))).sendKeys("Newyork");
            //Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"android.view.View\" and ./parent::*[@text=\"Sign-up - TropicanaCasino.com\"]]/*[2]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[@class=\"android.view.View\"]/*[8]"))).sendKeys("newyork");
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"State\" and ./preceding-sibling::*[@text=\"State\"]]"))).click();


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Alabama\"]"))).click();

            scrollDown();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Zip code']"))).sendKeys("35242");


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Mobile number']"))).sendKeys("5428288028");


         scrollDown1();


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Security Question 1']//following-sibling::android.view.View"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='What is your favorite sports team?']"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Security Answer 1']"))).clear();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Security Answer 1']"))).sendKeys("Mps");

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Security Question 2']//following-sibling::android.view.View"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='In what city did you meet your spouse/significant other?']"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Security Answer 2']"))).clear();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Security Answer 2']"))).sendKeys("Mps");

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@hint='Did you receive a bonus code to join? Enter it here (optional).']"))).clear();



            scrollDown1();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='I am 21 or over and I accept these Terms & Conditions']"))).click();

            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='I certify that all information provided during account registration is true and accurate, and that I am not prohibited from engaging in sports wagering activities.']"))).click();


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckBox[@text='I hereby acknowledge that I am prohibited from allowing any other person to access or use my gaming account']"))).click();


            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Join now']"))).click();

            threadLocalDriver.get().getPageSource();
            threadLocalDriver.get().getPageSource();



            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Proceed']"))).click();








            threadLocalDriver.get().executeScript("lambda-status=passed");


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

@Test
    public void test2() throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("devicelog", true);
//
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Galaxy S24");

        ltOptions.put("platformVersion", "14");

        ltOptions.put("app", "lt://APP10160321281723464481369557");
//
        ltOptions.put("isRealMobile", true);
         //ltOptions.put("autoAcceptAlerts",true);
//
        ltOptions.put("build", "LNW-2.4.1");
//
        //ltOptions.put("appiumVersion", "2.4.1");
    ltOptions.put("appiumVersion", "2.11.2");

        //ltOptions.put("noReset", true);



        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("unicodeKeyboard", true);
        ltOptions.put("visual", true);
        ltOptions.put("resetKeyboard", true);

        ltOptions.put("nativeWebScreenshot", true);

        ltOptions.put("allowInvisibleElements", true);
//            ltOptions.put("imageMatchThreshold", "0.8");
//            ltOptions.put("imageElementTapStrategy", "w3cActions");
//            ltOptions.put("fixImageTemplateSize", true);
//            ltOptions.put("fixImageTemplateScale",true);
//            ltOptions.put("getMatchedImageResult", true);
//            ltOptions.put("checkForImageElementStaleness",false);
//            ltOptions.put("ignoreUnimportantViews", true);
//            ltOptions.put("nativeWebTap", true);
        //ltOptions.put("enableMultiWindows", true);


//            ltOptions.put("enableNetworkThrottling", false);
//            //ltOptions.put("enableTopmostWindowFromActivePackage", true);
//            ltOptions.put("ignoreUnimportantViews", false);
//            ltOptions.put("includeExtrasInPageSource", true);
//            ltOptions.put("shouldUseCompactResponses", false);


//
        capabilities.setCapability("lt:options", ltOptions);
        String hub = "http://" + userName + ":" + accessKey + gridURL;

        driver = new AndroidDriver(new URL(hub), capabilities);



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

        driver.findElementByAccessibilityId("Next").click();


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
    scrollWithPercentage(0.8, 0.7);
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


    //scrollDown2();
    //scrollForAllAppiumVersion();

    scrollWithPercentage(0.8, 0.7);


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


   // scrollDown2();
    scrollForAllAppiumVersion();
    scrollForAllAppiumVersion();


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

    //scrollDown2();
    scrollForAllAppiumVersion();
    //scrollForAllAppiumVersion();

    driver.findElement(By.xpath("//*[@text='Join now']"));
    driver.findElement(By.xpath("//*[@text='Join now']")).isDisplayed();

    driver.findElement(By.xpath("//*[@text='Join now']")).click();
    driver.getContextHandles();
    driver.context("NATIVE_APP");
    driver.getPageSource();

    driver.findElements(By.xpath("//*[@text='Proceed']"));
    driver.findElements(By.xpath("//*[@text='Proceed']"));


    //driver.runAppInBackground(Duration.ofSeconds(3));
    driver.findElement(By.xpath("//*[@text='Proceed']")).isDisplayed();
    driver.findElement(By.xpath("//*[@text='Proceed']")).click();
//
//    WebDriverWait Wait = new WebDriverWait(   driver, 30);
//    Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Proceed']"))).click();

//    driver.findElement(By.xpath("//*[@text='Proceed']"));
//    driver.findElement(By.xpath("//*[@text='Proceed']")).isDisplayed();










        driver.quit();


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

    private void  scrollForAllAppiumVersion(){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1500))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 500, 300))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(scroll));
    }

    public void scrollWithPercentage(double startPercentage, double endPercentage) {
        // Get the screen size
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;

        // Calculate the start and end points for the scroll
        int startX = width / 2; // Horizontal center of the screen
        int startY = (int) (height * startPercentage); // Start point as a percentage of screen height
        int endY = (int) (height * endPercentage); // End point as a percentage of screen height
        System.out.println("START X IS :: "+startX);
        System.out.println("START Y IS :: "+startY);
        System.out.println("END Y IS IS :: "+endY);
        // Create W3C Touch Action
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Arrays.asList(scroll));
    }


}
