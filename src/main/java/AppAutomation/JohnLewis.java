package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class JohnLewis {

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
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");
            ltOptions.put("platformVersion", "17");
            ltOptions.put("app", "lt://APP10160602371726656901907478");
            ltOptions.put("build", "john-lewis-debug");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", true);
            ltOptions.put("autoAcceptAlerts", false);
            ltOptions.put("autoDismissAlerts", false);
            ltOptions.put("enableBiometricsAuthentication", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new IOSDriver(new URL(hub), capabilities);


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//          //  HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.0.0");
//           // capabilities.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            capabilities.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            capabilities.setCapability("app", "bs://2621114be5924ac11ae62237b63bde39d471301c");
//            capabilities.setCapability("build", "build-john-lewis");
//            capabilities.setCapability("name", "debug");
//
//            capabilities.setCapability("platformName", "ios");
//            capabilities.setCapability("platformVersion", "17");
//            capabilities.setCapability("deviceName", "iPhone 15");
//            capabilities.setCapability("browserstack.enableBiometric", true);
//


            driver = new IOSDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), capabilities);


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElementByAccessibilityId(("primaryButtonOptional(\"Allow all\")")).click();

            driver.findElement(By.xpath("//*[@name=\"Search product or brand\"]")).click();
            driver.findElement(By.xpath("//*[@name=\"Search product or brand\"]")).sendKeys("Original Penguin");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@name=\"Original Penguin\"]")).click();

            driver.findElementByAccessibilityId("primaryButtonOptional(\"Add to basket\")").click();

            driver.findElement(By.xpath("//*[@name=\"Size Menu Label\"]")).click();



            scrollDown();

            driver.findElement(By.xpath("//*[@name=\"Done\"]")).click();


            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Add to basket\"]")).click();





                driver.executeScript("browserstack_executor: {\"action\":\"biometric\", \"arguments\": {\"biometricMatch\" : \"pass\"}}");
  //          driver.executeScript("lambda-status=passed");




            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                //driver.executeScript("lambda-status=failed");
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
