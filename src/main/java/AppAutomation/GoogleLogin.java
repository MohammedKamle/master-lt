package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class GoogleLogin {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "Pixel.*");
//
//            ltOptions.put("app", "proverbial-android");
//            ltOptions.put("appiumVersion", "2.0.0");
//            ltOptions.put("build", "Java TestNG Android");
//            ltOptions.put("autoGrantPermission", true);
//
//            ltOptions.put("isRealMobile", true);
//            ltOptions.put("project", "android");
//
//            ltOptions.put("network", true);
//
//            capabilities.setCapability("lt:options", ltOptions);
//            capabilities.setCapability("tags", new String[] {"regression", "android"});
//            //capabilities.setCapability("project", "android");


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","google-login");
            //capabilities.setCapability("name",platform+" "+device+" "+version);
             capabilities.setCapability("deviceName", "Pixel.*");
            //capabilities.setCapability("platformVersion",version);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP1016031721731318654019271"); //Enter your app url

            //capabilities.setCapability("console", true);
          //  capabilities.setCapability("network", true);
//            capabilities.setCapability("visual", true);
//            capabilities.setCapability("video", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("appProfiling", true);
            HashMap<String, String> playstorelogin = new HashMap<>();
            playstorelogin.put("email", "lingo.test.kids2@gmail.com");          //Add in your Google account ID
            playstorelogin.put("password", "LingoTest2397.");          //Add in your Google account Password
            capabilities.setCapability("playStoreLogin", playstorelogin);


            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.get("https://accounts.lambdatest.com/dashboard");


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            Thread.sleep(5000);
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
}
