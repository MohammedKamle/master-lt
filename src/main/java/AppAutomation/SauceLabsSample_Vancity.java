package AppAutomation;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class SauceLabsSample_Vancity {

    String userName = "mkamle86";
    String accessKey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    private static ThreadLocal<IOSDriver> iosDriver = new ThreadLocal<IOSDriver>();

    @Test()
    public void iOSApp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone SE");
            ltOptions.put("platformVersion", "15");
            ltOptions.put("app", "lt://APP1016049361738049134700260");
            ltOptions.put("appiumVersion", "2.12.1");
            ltOptions.put("build", "vacinity-debug");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("network", false);
            //ltOptions.put("settings[snapshotMaxDepth]",70);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");
            String hub = "http://" + userName + ":" + accessKey + gridURL;
            iosDriver.set(new IOSDriver<>(new URL(hub),capabilities));
//
//            MutableCapabilities capabilities = new MutableCapabilities();
//            MutableCapabilities sauceOptions = new MutableCapabilities();
//            // For all capabilities please check
//            // http://appium.io/docs/en/writing-running-appium/caps/#general-capabilities
//            // https://docs.saucelabs.com/dev/test-configuration-options/#mobile-appium-capabilities
//            // Use the platform configuration https://saucelabs.com/platform/platform-configurator#/
//            // to find the simulators/real device names, OS versions and appium versions you can use for your testings
//            capabilities.setCapability("platformName", MobilePlatform.IOS);
//            capabilities.setCapability("appium:automationName", AutomationName.IOS_XCUI_TEST);
//            capabilities.setCapability("appium:deviceName", "iPhone.*");
//            capabilities.setCapability("appium:platformVersion", "15");
//            capabilities.setCapability("appium:app", "storage:filename=VancityiOSDebug17201ipa-1737647909786.ipa");
//
//            // Sauce capabilities
//            sauceOptions.setCapability("resigningEnabled", true);
//            sauceOptions.setCapability("networkCapture", true);
//            //sauceOptions.setCapability("name", method.getName());
//            //DateTime dt = new DateTime();
//            sauceOptions.setCapability("build", "mdk-vancity-debug");
//            sauceOptions.setCapability("username", "asad360logica");
//            sauceOptions.setCapability("accessKey", "5b590681-12c9-40ff-8f6c-da4be6bac8d3");
//            sauceOptions.setCapability("appiumVersion", "latest");
//            capabilities.setCapability("sauce:options", sauceOptions);
//
//                var url = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
//            //threadLocalDriver.set(new AndroidDriver<>(new URL(hub), capabilities));
//            iosDriver.set(new IOSDriver<>(new URL(url),capabilities));





            iosDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);






            Thread.sleep(3000);

            Set<String> contextHandles = iosDriver.get().getContextHandles();
            System.out.println("Available contexts: " + contextHandles);

            String webview = contextHandles.stream()
                    .filter(s -> s.startsWith("WEBVIEW_") && s.endsWith(".12"))
                    .findFirst()  // Get the first match
                    .orElse(null); // Return null if no match is found


            iosDriver.get().context(webview);



            iosDriver.get().findElement(By.xpath("//a[@id='homeHelpButton']")).click();



            System.out.println(iosDriver.get().getPageSource());





            //iosDriver.get().executeScript("lambda-status=passed");


            iosDriver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
               // iosDriver.get().executeScript("lambda-status=failed");
                iosDriver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
