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
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class WIX {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    String optionalArguments = "--es injected-cookie JWT.eyJraWQiOiJrdU42YlJQRCIsImFsZyI6IlJTMjU2In0.eyJkYXRhIjoie1widXNlckd1aWRcIjpcIjY2MzcyYWJjLTEwN2EtNGJhZi1iNjY0LTU2MTg1YTNmYmZiNlwiLFwidXNlck5hbWVcIjpcIlwiLFwiY29sb3JzXCI6e1wicG9zdFJlZ0NvbG9yXCI6W1wiSE9QUFwiXX0sXCJ1Y2RcIjpcIjIwMjEtMTItMjZUMTA6MDA6MzcuMDAwKzAwOjAwXCIsXCJ3eHNcIjpmYWxzZSxcImV3eGRcIjpmYWxzZSxcImFvclwiOnRydWUsXCJhY2lcIjpcIjY2MzcyYWJjLTEwN2EtNGJhZi1iNjY0LTU2MTg1YTNmYmZiNlwiLFwicm1iXCI6ZmFsc2UsXCJsdmxkXCI6XCIyMDI0LTA5LTI2VDE1OjAwOjAxLjQyMiswMDowMFwiLFwibGF0aFwiOlwiMjAyNC0wOS0yNlQxNTowMDowMS4zNTMrMDA6MDBcIixcInd4ZXhwXCI6XCIyMDI0LTEwLTExVDE1OjAwOjAxLjQyMiswMDowMFwiLFwicGFjXCI6dHJ1ZSxcInNpZFwiOlwiMjNlZjNiMDItNWIyZC00NTQwLWFlYjgtZjllNjJiYjg2Y2VkXCJ9IiwiaWF0IjoxNzI3MzYyODAxLCJleHAiOjE3Mjg2NTg4MDF9.mVPGx1WAaQZHrkial2SDLXklx27iSTY6vofl40AbQ_4A1rMxy-evpreT9Ta12_nY9eKASwOlquUbIlHUbvsavJlEekPPgwqiBQryWy6g-3mXI50yRcf_52yQieSu1AJrgQCOlIJv9UmS8ZtucyP4x_cN0xJ3Qt3jdTgUwGwIaDInmiqZO0AL3yx1nZ4aQ7csa3wNJjIcivnS7CNJwUFzQ5U6kxYpWZjiOLAwR6pUIUW_9_ngWQSR5ANnIKctRXW0_b2aA8I7DgQR1iFCo8AEQ3-q5eT5Bs3ZAMHkI0aNjImXUi7TIQQp0oAzvIpj3gbsWCCEveaV0K-G_wWsUs-fig --es experiments 2a2dda1253e60571afc98038be3ee6eb";

    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();
    String deviceRegex = "(Pixel (8 Pro|8|7 Pro|7|6))|(Galaxy S2[34](\\+| Ultra)?)";
    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("deviceName", "Galaxy S24 Ultra");
            //ltOptions.put("udid", "R5CX11PCVCV");//RZCW20H4T9P//RZCX115ALAT

            ltOptions.put("platformVersion", "14");
            ltOptions.put("app", "lt://APP10160522181729857561737434");
            ltOptions.put("build", "wix-debug-touch-actions-issue-parallel-appium-2.0.0-2");
            ltOptions.put("autoGrantPermissions", true);
           // ltOptions.put("privateCloud", true);


            ltOptions.put("devicelog", true);
            ltOptions.put("optionalIntentArguments", optionalArguments);

            //ltOptions.put("fixedIP", "RZCW12HGLJT");
            //ltOptions.put("resign", false);
            //ltOptions.put("mitmProxy", true);

            //ltOptions.put("")



            ltOptions.put("isRealMobile", true);

            ltOptions.put("network", false);
//            HashMap<String, String> playstorelogin = new HashMap<>();
//            playstorelogin.put("email", "myema@gmail.com");          //Add in your Google account ID
//            playstorelogin.put("password", "pasorrd");          //Add in your Google account Password
//            capabilities.setCapability("playStoreLogin", playstorelogin);


            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities));
//

//            DesiredCapabilities bsCaps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            //browserstackOptions.put("appiumVersion", "2.4.1");
//            bsCaps.setCapability("bstack:options", browserstackOptions);
////        capabilities.setCapability("platformName", "ios");
////        capabilities.setCapability("platformVersion", "16");
////        capabilities.setCapability("deviceName", "iPhone 14");
//            //bsCaps.setCapability("browserstack.networkLogs", "true");
//            //ios
////        capabilities.setCapability("app", "bs://11c89322ec2e72d1718a40af5ed9836fa953acda");
//            //android
//            bsCaps.setCapability("app", "bs://d96d9c66344e1ac3d36cace904e5e2ed386fc1e1");
//            bsCaps.setCapability("build", "build-wix");
//            bsCaps.setCapability("name", "debug");
//            bsCaps.setCapability("autoGrantPermissions", true);
//            bsCaps.setCapability("platformName", "android");
//            bsCaps.setCapability("platformVersion", "14.0");
//            bsCaps.setCapability("deviceName", "Samsung Galaxy S24");
//            bsCaps.setCapability("interactiveDebugging", true);
//
//            driver = new AndroidDriver(new URL("http://"+"mobileautoservic_w86Uka"+":"+"SeW8HQo2LzzoUw9qsDK8"+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), bsCaps);
//
//





            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            Thread.sleep(2000);

           // threadLocalDriver.get().findElement(By.xpath("//*[@resource-id=\"owners.empty-state.wixLogo\"]")).isDisplayed();

            Thread.sleep(5000);
            tapByCoordinates(threadLocalDriver.get(), 0.5,0.5);

            //scroll(threadLocalDriver.get(),0.5, 0.8, 0.5, 0.2);

            scrollDown();

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


//    public static void scroll(AppiumDriver<MobileElement> driver, double startXPercentage, double startYPercentage, double endXPercentage, double endYPercentage) {
//        // Get screen dimensions
//        Dimension screenSize = driver.manage().window().getSize();
//        int screenWidth = screenSize.getWidth();
//        int screenHeight = screenSize.getHeight();
//
//        // Calculate start and end points for the swipe
//        int startX = (int) (screenWidth * startXPercentage);
//        int startY = (int) (screenHeight * startYPercentage);
//        int endX = (int) (screenWidth * endXPercentage);
//        int endY = (int) (screenHeight * endYPercentage);
//
//        // Perform swipe action using TouchAction
//        new TouchAction<>(driver)
//                .press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) // Wait for 1 second
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();
//    }

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
}
