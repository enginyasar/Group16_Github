package webBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebBrowserSample {

    UiAutomator2Options options;
    AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        options = new UiAutomator2Options().setPlatformName("Android");
        options.setChromedriverExecutable("C://Users//yasar//chromedriver_win32//chromedriver.exe");
        options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //the default Appium server address and port
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    //Bu örnekte web testi yapıldı. Site test sırasında yine Emülatörde açıldı.
    public void firstWeb() throws InterruptedException {
        driver.get("http://www.google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test
    //https://rahulshettyacademy.com/angularAppdemo sayfasında mobil görünümden locateleri alıp, web testi gibi yaptı
    //Site test sırasında yine Emülatörde açıldı.
    public void firstWebMobile() throws InterruptedException {
    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[routerlink*='/products']")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
        String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        System.out.println("text = " + text);
        Assert.assertEquals(text,"Devops");
        Thread.sleep(3000);
    }
}