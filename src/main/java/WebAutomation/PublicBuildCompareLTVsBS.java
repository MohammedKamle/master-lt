package WebAutomation;


import java.awt.datatransfer.DataFlavor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PublicBuildCompareLTVsBS {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "mkamle86";
        String authkey = "Z4fjukn5CSrn4uJEwEh8wO6DtK4I8kyVPKImW5cdD8z1Tm1RIn";

        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "debug");
        caps.setCapability("name", "sample-test");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("resolution", "2560x1440");
        //caps.setCapability("geoLocation", "CA/ON");

        //caps.setCapability("infraProvider", "LW-UK");



        //caps.setCapability( "selenium_version", "4..0");

//        caps.setCapability("accessibility", true);
//        caps.setCapability("accessibility.wcagVersion", "wcag21a");
//        caps.setCapability("accessibility.bestPractice", false);
//        caps.setCapability("accessibility.needsReview", true);
        //caps.setCapability("autoHeal", true);
        //caps.setCapability("network", true);
        //caps.setCapability("network.full.har", true);
        //caps.setCapability("performance", true);
        //caps.setCapability("tunnel", true);




        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





    }

    @Test
    public void basicTest() throws InterruptedException {
        String url = "https://automate.browserstack.com/dashboard/v2/public-build/WGx5TzZ5N3RMTkNvUzhSODIwMVYxdlArSHA0NEJSQXJCU20wUTE4T2toeVY5Si9leWNlZVdNVDNQRSt0MFQycUt6Ry9uTGNLT2tJWU91OStnN21tVVE9PS0tcVFPT2REU090akUyT2JJQUdHQVErZz09--a8e602c7be4d04fbe65b02a2be5f012f70db8499";
        String ltURL = "https://automation.lambdatest.com/share?isThemeEnabled=true&selectedTab=home&shareId=5EY98JSKOAZJ1AJJAJBTDHV18JFM2H1D544VOZPOCBZJAVCMZ4GFZ3JP1EN0IB5Y&testID=GWGEL-BKPZE-8FVO4-UZIQE&themeVersion=v2";
        driver.get(url);

        scrollToLoadAll(driver);

        List<WebElement> testDurations = driver.findElements(By.xpath("//div[@class = 'detail-duration']"));

        // Print the extracted durations
        System.out.println("Extracted Test Durations:");
        for (int i = 0; i < testDurations.size(); i++) {
            String durationText = testDurations.get(i).getText().trim();
            if (!durationText.isEmpty()) {
                System.out.println("Test " + (i + 1) + ": " + durationText);
            }
        }

        
        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");

    }


    @Test
    public void lt() throws InterruptedException {

        String ltURL = "https://automation.lambdatest.com/share?isThemeEnabled=true&selectedTab=home&shareId=5EY98JSKOAZJ1AJJAJBTDHV18JFM2H1D544VOZPOCBZJAVCMZ4GFZ3JP1EN0IB5Y&testID=GWGEL-BKPZE-8FVO4-UZIQE&themeVersion=v2";
        driver.get(ltURL);

        WebElement leftPanel = driver.findElement(By.xpath("//*[@id=\"testlistGroup\"]/div/div/div/div/div[2]/div/div/div[1]/div/div")); // Replace with the actual XPath to the left panel

        // Scroll the left panel until all tests are loaded
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return arguments[0].scrollHeight", leftPanel);

        while (true) {
            // Scroll the left panel to the bottom
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", leftPanel);

            // Wait for the page to load new content
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate new scroll height and compare it with the last scroll height
            long newHeight = (long) js.executeScript("return arguments[0].scrollHeight", leftPanel);
            if (newHeight == lastHeight) {
                break; // If the height hasn't changed, we've reached the bottom
            }
            lastHeight = newHeight;
        }

        // Now, grab the test durations
        List<WebElement> testDurations = driver.findElements(By.xpath("//*[starts-with(@id, 'testTime')]"));

        // Print out each test duration
        for (WebElement duration : testDurations) {
            System.out.println(duration.getText());
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.executeScript("lambda-build=" + "some-name-1");
        driver.quit();

    }

    public static void scrollToLoadAll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5L);

        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            // Scroll down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // **Adding delay to allow elements to load**
            try {
                Thread.sleep(5000); // 1-second delay after each scroll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Wait for new elements to load
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class = 'detail-duration']")));
            } catch (TimeoutException e) {
                System.out.println("No more new elements loaded.");
            }

            // Check new page height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break; // No more content to load
            }
            lastHeight = newHeight;
        }
    }

}