package AppAutomation;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import io.appium.java_client.touch.offset.PointOption;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Corpay {

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
            ltOptions.put("deviceName", "^(?!.*Tab).*Galaxy.*");
            //ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP1016041711725269094183985");
            ltOptions.put("autoGrantPermissions", true);
            //ltOptions.put("appiumVersion", "2.2.1");

            ltOptions.put("isRealMobile", true);
            ltOptions.put("build", "corpay-debug");

            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

//

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


           // driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")).click();

            driver.findElement(By.xpath("//android.view.View[@content-desc='Skip']")).click();

            driver.findElement(By.xpath("//android.widget.Button[@content-desc='Log in or register']")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("astest18@test.com");
            driver.hideKeyboard();
            driver.findElement(By.xpath("//android.widget.EditText[@password = 'true']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@password = 'true']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@password = 'true']")).sendKeys("Test@1234");


            driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("London");
            driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.ImageView[@index='4']")).isDisplayed();
            driver.findElement(By.xpath("//android.widget.ImageView[@index='4']")).isEnabled();
            driver.findElement(By.xpath("//android.widget.ImageView[@index='4']")).click();
            Thread.sleep(8000);
            driver.findElement(By.xpath("(//android.view.View[@index='1'])[2]")).isDisplayed();
            driver.findElement(By.xpath("(//android.view.View[@index='1'])[2]")).isEnabled();
            driver.findElement(By.xpath("(//android.view.View[@index='1'])[2]")).click();


            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='See more details']")).click();


            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Add to favourites']")).click();

            scrollDown();

//            Dimension dimension = driver.manage().window().getSize();
//            int scrollStart = (int) (dimension.getHeight() * 0.3);
//            int scrollEnd = (int) (dimension.getHeight() *  0.9);
//            new TouchAction((PerformsTouchActions) (driver)).press(PointOption.point(0, scrollStart))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
//                    .moveTo(PointOption.point(0, scrollEnd)).release().perform();
//            Thread.sleep(500);

            //driver.findElement(By.xpath("//android.widget.ImageView[@index='4']")).isDisplayed();






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
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }



}
