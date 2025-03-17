package AppAutomation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Emulator {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    //AndroidDriver<MobileElement> driver;

    protected static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();

    @Test()
    public void AndroidApp1() {
        try {
//            MutableCapabilities capabilities = new MutableCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Galaxy.*");
//            ltOptions.put("devicelog", true);
//            //ltOptions.put("network", true);
//            ltOptions.put("platformVersion", "13");
//            ltOptions.put("app", "lt://APP1016047291732864572921319");
//            //ltOptions.put("appiumVersion", "2.1.3");
//            ltOptions.put("build", "wix-regex-debug-1412");
//            ltOptions.put("isRealMobile", false);
//            //ltOptions.put("appProfiling", true);
//            capabilities.setCapability("lt:options", ltOptions);
            //capabilities.setCapability("tags", new String[] {"regression", "android"});



                        DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","Java TestNG Android");

             capabilities.setCapability("deviceName", ".*");


            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("isRealMobile", false);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP1016047291732864572921319"); //Enter your app url

            capabilities.setCapability("console", true);
            //capabilities.setCapability("network", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
   //         capabilities.setCapability("appProfiling", true);
 //           capabilities.setCapability("geoLocation", "HK");

            String hub = "http://" + userName + ":" + accessKey + gridURL;

            threadLocalDriver.set(new AndroidDriver(new URL(hub), capabilities));
            //driver = new AndroidDriver<MobileElement>(new URL(hub), capabilities);







            threadLocalDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            Thread.sleep(3000);

//            driver.findElementByIosClassChain("**/XCUIElementTypeTextField[`label == \"Username\"`]").sendKeys("mohammed.kamle");
//
//            Thread.sleep(2000);
//
//            driver.findElementByIosClassChain("**/XCUIElementTypeSecureTextField[`label == \"Password\"`]").sendKeys("myPassword");
//
//            Thread.sleep(2000);

            //driver.resetApp();

            // Method 1 //APPTESYa2wcP1IcLTICjiz
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            Map<String, String> data = new HashMap<>();
//            data.put("appUrl", "lt://APP10160201271708624582624451");
//            js.executeScript("lambda-install-app", data);
//            driver.launchApp();


         // Method 2 //APPTESZ6DFyoI1KgLZ80U1
            ///driver.installApp("lt://APP10160201271708624582624451");

//com.helloheart.app.healthplan.demo
            //driver.installApp("com.hello-do.Hello-Heart-Demo");

            //driver.installApp("com.helloheart.app.healthplan.demo");


            // MEthod 3 //APPTESUQkZCerIsWHa4vrU
//            driver.terminateApp("com.hello-do.Hello-Heart-Demo");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            Map<String, String> data = new HashMap<>();
//            data.put("appUrl", "lt://APP10160201271708624582624451");
//            js.executeScript("lambda-install-app", data);
 //getting Failed to install the app using lambda webhook


            // Method 4 //
//            driver.terminateApp("com.hello-do.Hello-Heart-Demo");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            js.executeScript("lambda-install-app=com.hello-do.Hello-Heart-Demo");

            // "Failed to fetch app details"

           //  Method 5 - wroks (APPTESdj2eqbWBsUdGxldX)
//            driver.terminateApp("com.hello-do.Hello-Heart-Demo");
//            Thread.sleep(2000);
            //driver.executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.hello-do.Hello-Heart-Demo"));

            // Method 6 - works
//            driver.terminateApp("com.hello-do.Hello-Heart-Demo");
//           driver.activateApp("com.hello-do.Hello-Heart-Demo");




           // Method 7 - works
//            driver.executeScript("mobile: clearApp", ImmutableMap.of("bundleId", "com.hello-do.Hello-Heart-Demo"));
//            driver.executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.hello-do.Hello-Heart-Demo"));


            // Method 8
//            driver.removeApp("com.hello-do.Hello-Heart-Demo");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            Map<String, String> data = new HashMap<>();
//            data.put("appUrl", "lt://APP10160201271708624582624451");
//            js.executeScript("lambda-install-app", data);


//            Map<String, String> data1 = new HashMap<>();
//            data1.put("appPackage", "com.hello-do.Hello-Heart-Demo");
//            driver.executeScript("lambda-uninstall-app", data1);
//
//            Map<String, String> data2 = new HashMap<>();
//            data2.put("appUrl", "lt://APP10160201271708624582624451");
//            driver.executeScript("lambda-install-app",data2);

//            driver.executeScript("lambda-uninstall-app=com.hello-do.Hello-Heart-Demo");
//            driver.executeScript("lambda-install-app=lt://APP10160201271708624582624451");


//            driver.removeApp("com.hello-do.Hello-Heart-Demo");
//            driver.executeScript("lambda-install-app=lt://APP10160201271708624582624451");




            threadLocalDriver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                threadLocalDriver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
