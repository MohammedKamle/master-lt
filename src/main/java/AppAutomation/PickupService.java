package AppAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import okhttp3.*;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class PickupService {

    String userName = "mohammadk";

     String mediaUrl;
    String accessKey = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() throws IOException {
        mediaUrl = uploadImageAndGetUrl();

        System.out.println("MEDIA URL :: "+mediaUrl);
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");
            //ltOptions.put("platformVersion", version);
            ltOptions.put("app", "lt://APP1016033751689695546835361");
            ltOptions.put("build", "pickup-debug");
            // ltOptions.put("name", platform+" "+device+" "+version);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("visual", true);
            ltOptions.put("enableImageInjection",true);
            ltOptions.put("media", mediaUrl);
            capabilities.setCapability("lt:options", ltOptions);




            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            MobileElement el1 = (MobileElement) driver.findElementById("com.ams.pudo:id/username");
            el1.sendKeys("ITA-TRAINING");
            MobileElement el2 = (MobileElement) driver.findElementById("com.ams.pudo:id/login");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.ams.pudo:id/code_txv");
            el3.sendKeys("ScanTraining");
            MobileElement el4 = (MobileElement) driver.findElementById("com.ams.pudo:id/verify");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("com.ams.pudo:id/continue_relay");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View[2]");
            el6.click();
            driver.executeScript("lambda-image-injection="+mediaUrl);
            MobileElement el7 = (MobileElement) driver.findElementById("com.ams.pudo:id/btn_scan");
            el7.click();
            driver.executeScript("lambda-image-injection="+mediaUrl);
            MobileElement el8 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
            el8.click();

            Thread.sleep(10000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    private String uploadImageAndGetUrl() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("media_file","linear.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/Users/mohammadk/Desktop/linear.png")))
                .addFormDataPart("type","image")
                .addFormDataPart("custom_id","my-photo")
                .build();

        Request request = new Request.Builder()
                .url("https://mobile-mgm.lambdatest.com/mfs/v1.0/media/upload")
                .method("POST", body)
                .addHeader("Authorization", "Basic bW9oYW1tYWRrOnJha2NCb0JZSGl5OEJXN29zVmk0TjFMR1lqZ0poUmZBd3ZMMXBQVXZ3Q0Exd2ZOQ2hk")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JSONObject jo = new JSONObject(jsonString);
        return (String) jo.get("media_url");
    }
}
