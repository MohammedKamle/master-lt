package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class SKID {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S23");

            //ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP10160522261723710220133986");

            //ltOptions.put("appiumVersion", "2.2.1");

            ltOptions.put("build", "sk-id-solution");
            //ltOptions.put("autoGrantPermission", true);
            ;


            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

//
//
            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("build","Java TestNG Android");
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//             capabilities.setCapability("deviceName", "iPhone.*");
//             capabilities.setCapability("animationCoolOffTimeout", 2000);
//            //capabilities.setCapability("platformVersion",version);
//            capabilities.setCapability("platformName", "ios");
//            capabilities.setCapability("isRealMobile", true);
//            //AppURL (Create from Wikipedia.apk sample in project)
//            capabilities.setCapability("app", "proverbial-ios"); //Enter your app url
//
//            capabilities.setCapability("console", true);
//            //capabilities.setCapability("network", true);
//            capabilities.setCapability("visual", true);
//            capabilities.setCapability("devicelog", true);
//   //         capabilities.setCapability("appProfiling", true);
// //           capabilities.setCapability("geoLocation", "HK");
//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.context("WEBVIEW_com.stagnationlab.sk");

            driver.findElement(By.xpath("//*[@class=\"btn menu-btn\"]")).click();


            driver.context("NATIVE_APP");

            driver.findElement(By.xpath("//*[@text=\"Settings\"]")).click();

            driver.context("WEBVIEW_com.stagnationlab.sk");

            driver.findElement(By.xpath("(//*[@data-test='menu-settings-allow-screenshots']/div[2])")).click();

            driver.context("NATIVE_APP");

            driver.findElement(By.xpath("//*[@text=\"Close main menu\"]")).click();

            driver.context("WEBVIEW_com.stagnationlab.sk");

            driver.findElement(By.xpath("//button[@class=\"btn btn-success\" and @data-test=\"register\"]")).click();

            Thread.sleep(4000);

            var country = driver.findElements(By.xpath("(//*[@data-test='country-LT'])")) ;


            driver.findElement(By.xpath("(//*[@data-test='country-LT'])")).click();

            driver.findElement(By.xpath("(//*[@data-test='provider-banks'])")).click();

            driver.findElement(By.xpath("(//*[@data-test='provider-bank-siauliu-bankas'])")).click();

            driver.findElement(By.xpath("(//*[@data-test='bank-online'])")).click();

            driver.findElement(By.xpath("(//*[@data-test='primary-action'])")).click();



            driver.context("NATIVE_APP");





            scrollDown();
            scrollDown();
            scrollDown();
            scrollDown();





            driver.context("WEBVIEW_com.stagnationlab.sk");


            driver.findElement(By.xpath("(//*[@data-test='agree'])")).click();


          //  driver.findElement(By.xpath("(//*[@data-test='phoneNumber'])")).sendKeys("41410840");
            driver.context("WEBVIEW_com.stagnationlab.sk");
            WebElement phoneNumberField = driver.findElement(By.xpath("//*[@data-test='phoneNumber']"));
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='41410840';", phoneNumberField);





        Thread.sleep(5000);





            driver.executeScript("lambda-status=passed");


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.executeScript("lambda-status=failed");
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
        int bottomY = driver.manage().window().getSize().height/2;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

}
