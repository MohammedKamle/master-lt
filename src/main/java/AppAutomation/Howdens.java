package AppAutomation;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class Howdens {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    @Test()
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel 7 Pro");

            ltOptions.put("platformVersion", "13");
            ltOptions.put("app", "lt://APP10160162001732803053765302");

            //ltOptions.put("appiumVersion", "1.22.3");
            //ltOptions.put("fixedIP","27251FDH300866");

            ltOptions.put("build", "howdens-debug-pixel-8-pro-14-with-appium-2.x");
            ltOptions.put("autoGrantPermissions", true);



            ltOptions.put("isRealMobile", true);

            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            capabilities.setCapability("project", "mdk-project-oct-28-next");




            String hub = "http://" + userName + ":" + accessKey + gridURL;


            driver.set(new AndroidDriver<>(new URL(hub), capabilities));

            driver.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


            driver.get().findElement(By.xpath("//android.widget.TextView[contains(@text,\"Skip\")]")).click();

            driver.get().findElement(By.xpath("//android.widget.EditText[contains(@text,\"name@example.com\")]"))
                    .sendKeys("pp_ta_otam_credit_ot03@mailsac.com");

            driver.get().findElement(By.xpath("//android.widget.EditText[contains(@text,\"Password\")]"))
                            .sendKeys("Welcome_123");

            driver.get().findElement(By.xpath("//android.widget.TextView[@text=\"SIGN IN\"]")).click();


           // driver.findElement(By.xpath("//android.widget.Button[contains(@text,\"Allow\")]")).click();


            driver.get().findElement(By.xpath("//android.widget.TextView[contains(@text,\"ACCOUNT DETAILS\")]")).click();


            driver.get().findElement(By.xpath("//android.widget.Button[contains(@text,\"ACCEPT ALL COOKIES\")]")).click();
            //driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"ACCOUNT DETAILS\")]")).click();







            System.out.println(driver.get().getPageSource());
            driver.get().executeScript("lambda-status=passed");


            driver.get().quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                System.out.println(driver.get().getPageSource());
                driver.get().executeScript("lambda-status=failed");
                driver.get().quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
