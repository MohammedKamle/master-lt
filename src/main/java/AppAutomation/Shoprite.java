package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Shoprite {

    String userName = "mkamle86";
    String accessKey = "s0EHeeN4IjrmpGjGUVKd8YuxYt3dSDsavuaOrLmVS16vZtkv5t";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    WebDriverWait wait ;

    AndroidDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy.*");
            ltOptions.put("visual", true);

            ltOptions.put("platformVersion", "11");
            ltOptions.put("app", "lt://APP1016025291728642945035622");
            //ltOptions.put("settings[waitForIdleTimeout]", 1);

            ltOptions.put("build", "shoprite-debug-1");
            ltOptions.put("autoGrantPermissions", true);
            //ltOptions.put("smartUI.project", "md-rd-1");

            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");

            //ltOptions.put("region", "US");
//            ltOptions.put("language", "fr");
//            ltOptions.put("locale", "fr_FR");
            ltOptions.put("network", false);

            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});
            //capabilities.setCapability("project", "android");

//

            String hub = "http://" + userName + ":" + accessKey + gridURL;

            driver = new AndroidDriver(new URL(hub), capabilities);

            ((JavascriptExecutor) driver).executeScript("lambda-name=shoprite-login-test");

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            wait = new WebDriverWait(driver, 10);


            driver.pushFile("/sdcard/Downloads/file-sample_150kB.pdf", new File("/Users/mohammadk/Downloads/file-sample_150kB.pdf"));



            byte[] fileBase64 = driver.pullFile("/sdcard/Downloads/file-sample_150kB.pdf");
            // Decode the Base64 byte array
            byte[] decodedBytes = Base64.getDecoder().decode(fileBase64);

            // Specify the output PDF file path
            String outputFilePath = "/Users/mohammadk/master-repo/src/main/java/Get_Started_With_Smallpdf.pdf";

            // Write the decoded bytes to a PDF file
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fos.write(decodedBytes);
                System.out.println("PDF file created successfully: " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error writing PDF file.");
            }




            //driver.findElementByAccessibilityId("profile_button").click();

//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"profile_button\"]/android.widget.ImageView")).click();
//
//            driver.findElement(By.id("za.co.shoprite.mmaqa:id/sign-in-screen/fields/phone-number")).sendKeys("+27658050310");
//
//            driver.findElement(By.id("za.co.shoprite.mmaqa:id/sign-in-screen/fields/pin")).sendKeys("91357");
//
//            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]")).click();
//
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"account_button\"]/android.widget.ImageView")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"toggleddropdown_button\"]/android.widget.ImageView")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"toggleddropdown_button\"]/android.widget.ImageView")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"mobiledeposit_button\"]")).click();
//
//            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"next_button\"]")).click();
//
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView")).click();
//
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView")).click();
//
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView")).click();
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"mobiledeposit_button\"]")).click();
//
//
//            driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"0, Voucher Account, Available: , R228511.00\"]/android.view.ViewGroup[1]")).click();
//
//
//            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
//
//            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
//
//
//            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView")).click();
//
//





            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"profile_button\"]/android.widget.ImageView"));
            sendKeysToElement(By.id("za.co.shoprite.mmaqa:id/sign-in-screen/fields/phone-number"), "+27658050310");
            sendKeysToElement(By.id("za.co.shoprite.mmaqa:id/sign-in-screen/fields/pin"), "91357");
            clickElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"mydetails_button\"]")));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"account_button\"]/android.widget.ImageView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"toggleddropdown_button\"]/android.widget.ImageView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"toggleddropdown_button\"]/android.widget.ImageView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"mobiledeposit_button\"]"));
            clickElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"next_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.TextView"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"mobiledeposit_button\"]"));
            clickElement(By.xpath("//android.widget.RadioButton[@content-desc=\"0, Voucher Account, Available: , R228511.00\"]/android.view.ViewGroup[1]"));
            clickElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"next_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"back_button\"]"));
            clickElement(By.xpath("//android.view.ViewGroup[@content-desc=\"sendmoney_button\"]"));
            clickElement(By.xpath("//android.widget.RadioButton[@content-desc=\"0, Voucher Account, Available: , R228511.00\"]/android.view.ViewGroup[1]"));



            ((JavascriptExecutor) driver).executeScript("lambda-name=TestName");























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

    public void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }
    }

    public void sendKeysToElement(By locator, String keys) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (element.isDisplayed() && element.isEnabled()) {
            element.sendKeys(keys);
        }
    }
}
