package AppAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class PLT {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AndroidDriver driver;

    @Test()
    public void keyBoardIsuue() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");
            ltOptions.put("appiumVersion", "2.0-stable");
            //ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160532321713342992958254");
            //ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "plt-debug");
            ltOptions.put("autoGrantPermission", true);



            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

            capabilities.setCapability("lt:options", ltOptions);



//
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("build","plt-debug");
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//             capabilities.setCapability("deviceName", "Pixel.*");
//            //capabilities.setCapability("platformVersion",version);
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("isRealMobile", true);
//            //AppURL (Create from Wikipedia.apk sample in project)
//            capabilities.setCapability("app", "lt://APP10160532321713342992958254"); //Enter your app url


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);
//


            //BS
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//           // browserstackOptions.put("appiumVersion", "2.0.0");
//            capabilities.setCapability("bstack:options", browserstackOptions);
//            capabilities.setCapability("app", "bs://48bb7a03cb5e0b6e8cd12491395298a1f1409a5c");
//            capabilities.setCapability("build", "build-plt");
//            capabilities.setCapability("name", "debug");
//
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("platformVersion", "12.0");
//            capabilities.setCapability("deviceName", "Google Pixel 6");
//            capabilities.setCapability("interactiveDebugging", true);
//
//
//            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);



            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//*[@resource-id=\"countrySelector\"]")).sendKeys("Austra");


            driver.findElement(By.xpath("//*[@text=\"Australia\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"com.poqstudio.app.platform.plt:id/btn_accept_cookies\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"absoluteText\"]")).click();

            // key press issue begin here

//            driver.findElement(By.xpath("//*[@resource-id=\"shopTabBarIcon\"]")).click();
//            //driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).sendKeys("Jeans");
//            var element = driver.findElement(By.xpath("//*[@text=\"Search...\"]"));
//
//            element.click();
//
//
//            element.sendKeys("jeans");
//            element.submit();
////            driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).click();
////            driver.findElement(By.xpath("//*[@content-desc=\"searchBarInput, SearchBar Input\"]")).sendKeys("Jeans");
////            driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).click();

            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("shopTabBarIcon");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("searchBarHome, SearchBar Input");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("searchBarInput, SearchBar Input");
            el3.sendKeys("Jeans");
            el3.click();
            driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            //el3.submit();


            // end here

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

    @Test()
    public void contextIssue() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");
            ltOptions.put("appiumVersion", "2.0-stable");
            //ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160532321713342992958254");
            //ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "plt-debug");
            ltOptions.put("autoGrantPermission", true);



            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

            capabilities.setCapability("lt:options", ltOptions);



//
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("build","plt-debug");
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//             capabilities.setCapability("deviceName", "Pixel.*");
//            //capabilities.setCapability("platformVersion",version);
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("isRealMobile", true);
//            //AppURL (Create from Wikipedia.apk sample in project)
//            capabilities.setCapability("app", "lt://APP10160532321713342992958254"); //Enter your app url


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);
//


            //BS
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//           // browserstackOptions.put("appiumVersion", "2.0.0");
//            capabilities.setCapability("bstack:options", browserstackOptions);
//            capabilities.setCapability("app", "bs://48bb7a03cb5e0b6e8cd12491395298a1f1409a5c");
//            capabilities.setCapability("build", "build-plt");
//            capabilities.setCapability("name", "debug");
//
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("platformVersion", "12.0");
//            capabilities.setCapability("deviceName", "Google Pixel 6");
//            capabilities.setCapability("interactiveDebugging", true);
//
//
//            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);



            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//*[@resource-id=\"countrySelector\"]")).sendKeys("Austra");


            driver.findElement(By.xpath("//*[@text=\"Australia\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"com.poqstudio.app.platform.plt:id/btn_accept_cookies\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"absoluteText\"]")).click();

            // key press issue begin here

            driver.findElement(By.xpath("//*[@resource-id=\"shopTabBarIcon\"]")).click();
            //driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).sendKeys("Jeans");
            driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).click();
            driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).sendKeys("Jeans");
            driver.findElement(By.xpath("//*[@content-desc=\"searchBarHome, SearchBar Input\"]")).click();
            // end here

            driver.findElement(By.xpath("//*[@class=\"android.widget.ImageView\" and ./parent::*[@class=\"android.view.ViewGroup\" and ./following-sibling::*[@text=\"$36.00\"]]]")).click();

            driver.findElement(By.xpath("//*[@text=\"SELECT SIZE\"]")).click();

            driver.findElement(By.xpath("//*[@text=\"S\"]")).click();

            //driver.findElement(By.xpath("//*[@resource-id=\"addToBagBtn\"]")).click();

            driver.findElement(By.xpath("//*[@text=\"Bag\"]")).click();


            driver.findElement(By.xpath("//*[@resource-id=\"checkoutBtn\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"emailInput\"]")).sendKeys("UKapp@pltautomation.com");

            driver.findElement(By.xpath("//*[@text=\"Continue\"]")).click();

            driver.findElement(By.xpath("//*[@resource-id=\"passwordInput\"]")).sendKeys("Fred1234");

            driver.findElement(By.xpath("//*[@text=\"Continue\"]")).click();

            //Adrress
            driver.findElement(By.xpath("//*[@text=\"ADD\"]")).click();
            driver.findElement(By.xpath("//*[@content-desc=\"firstName, First name\"]")).sendKeys("hsjhdsj");
            driver.findElement(By.xpath("//*[@content-desc=\"lastName, Last name\"]")).sendKeys("sahjas");
            driver.findElement(By.xpath("//*[@resource-id=\"pickerInput\"]")).sendKeys("898989898");
            scrollDown();
            driver.findElement(By.xpath("//*[@resource-id=\"addressLookup-input\"]")).sendKeys("Brisbane");
            driver.findElement(By.xpath("//*[@text=\"Brisbane Muslim School, 724 Blunder Road, DURACK  QLD 4077\"]")).click();

            scrollDown();

            driver.findElement(By.xpath("//*[@resource-id=\"confirmButton\"]")).click();

            if (driver.findElement(By.xpath("//*[@text=\"EDIT\"]")).isDisplayed()){
                scrollDown();
            }




            // paypal button
            //driver.findElement(By.xpath("//*[@class=\"android.view.ViewGroup\" and ./parent::*[@class=\"android.view.ViewGroup\" and ./preceding-sibling::*[@text=\"PayPal\"]]]/*[@class=\"android.widget.TextView\"]")).click();

            //Add card
            driver.findElement(By.xpath("//*[@content-desc=\"addEditCardText\"]")).click();
            driver.findElement(By.xpath("//*[@resource-id=\"cardHolderName\"]")).sendKeys("Scott Jenkins");
            driver.findElement(By.xpath("//*[@resource-id=\"cardNumber\"]")).sendKeys("4555983783879594");
            driver.findElement(By.xpath("//*[@resource-id=\"cardExpiryMonth\"]")).sendKeys("10");
            driver.findElement(By.xpath("//*[@resource-id=\"cardExpiryYear\"]")).sendKeys("27");
            driver.findElement(By.xpath("//*[@resource-id=\"cardCvc\"]")).sendKeys("107");
            driver.findElement(By.xpath("//*[@class=\"android.view.ViewGroup\" and ./*[@text=\"SAVE\"]]")).click();

            Thread.sleep(2000);

            scrollDown();

            driver.findElement(By.xpath("//*[@text=\"SECURE CHECKOUT\"]")).click();


        //    System.out.println(driver.getPageSource());

            switchContext();

            // securepaymeents
//           WebElement ele =  driver.findElement(By.xpath("//*[@class=\"android.webkit.WebView\"]"));
//            Actions action = new Actions(driver);
//            action.moveToElement(ele).click().perform();

            //driver.findElement(By.xpath("//android.widget.Button[starts-with(@text, 'Submit')]")).click();
            iFrameSwitchInt(0,By.xpath("//*[@id=\"verify-button\"]"));
            driver.findElement(By.xpath("//*[@id=\"verify-button\"]")).click();

            //Context switching
           // switchContext();


//            driver.findElement(By.xpath("//*[@class=\"android.widget.EditText\" and ./following-sibling::*[@text=\"Email or mobile number\"]]")).sendKeys("hdhjadh@gmail.com");
//
//            driver.findElement(By.xpath("//*[@text=\"Next\"]")).click();



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

    private void switchContext(){
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW_com.poqstudio.app.platform.plt")) {
                driver.context(contextName);
                break;
            }
        }
    }

    public void iFrameSwitchInt(int value, By getbjectLocator) throws InterruptedException {
        //MobileActions Action = new MobileActions();
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        // --- Checking how manu iFrames are seen.
        System.out.println("Number of iFrames are : " + iframes.size());
        driver.switchTo().frame(value);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(10000);
        //Action.elementWait10sec(getbjectLocator);

        if (driver.findElement(getbjectLocator).isDisplayed()) {
            System.out.println("Staying in Iframe");
        } else {
            System.out.println("Coming out of iframe");
            driver.switchTo().defaultContent();
        }
    }

}
