//package WebAutomation;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import java.net.URL;
//import org.openqa.selenium.remote.HttpCommandExecutor;
//
//
//
//public class TimeoutInDriverInitialize {
//
//    private RemoteWebDriver driver;
//    private String Status = "failed";
//
//    @BeforeMethod
//    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
//        String username = "mohammadk";
//        String authkey = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";
//
//        String hub = "@hub.lambdatest.com/wd/hub";
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("version", "latest");
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", "sample-test");
//        caps.setCapability("plugin", "git-testng");
//        //caps.setCapability("autoHeal", true);
//        caps.setCapability("network", true);
//        caps.setCapability("network.full.har", true);
//        //caps.setCapability("tunnel", true);
//
//
//
//
//        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
//        caps.setCapability("tags", Tags);
//
//        // Configuring timeouts
//        int timeoutInSeconds = 60; // For example, 60 seconds
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setConnectTimeout(timeoutInSeconds * 1000)
//                .setSocketTimeout(timeoutInSeconds * 1000)
//                .build();
//
//        // Custom HttpClient with increased timeouts
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setDefaultRequestConfig(requestConfig)
//                .build();
//
//        // URL of your Selenium Grid or Remote WebDriver server
//        URL seleniumGridUrl = new URL("http://your-grid-url:4444/wd/hub");
//
//        // Create a HttpCommandExecutor with your custom HttpClient
//        HttpCommandExecutor executor = new HttpCommandExecutor(httpClient);
//
//
//
//
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//    }
//
//    @Test
//    public void basicTest() throws InterruptedException {
//        String spanText;
//        System.out.println("Loading Url");
//
//        driver.get("https://lambdatest.github.io/sample-todo-app/");
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li2")).click();
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li4")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.xpath("//*[@id = 'addbutton']")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li7")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li8")).click();
//
//        System.out.println("Entering Text");
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li9")).click();
//
//        // Let's also assert that the todo we added is present in the list.
//
//        spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
//        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
//        Status = "passed";
//        Thread.sleep(150);
//
//        System.out.println("TestFinished");
//
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.executeScript("lambda-status=" + Status);
//        driver.quit();
//    }
//
//}