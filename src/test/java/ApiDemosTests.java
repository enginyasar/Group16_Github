import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class ApiDemosTests {
    UiAutomator2Options options;
    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        options = new UiAutomator2Options().setPlatformName("Android")
                .setAppPackage("com.touchboarder.android.api.demos")
                .setAppActivity("com.touchboarder.androidapidemos.MainActivity")
                .setUdid("emulator-5554")
                .setAutomationName("uiautomator2")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofMinutes(10));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void firstTest() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        // driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"TAMAM\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Accessibility\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Accessibility Node Querying\")")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("className(\"android.widget.CheckBox\").instance(4)")).click();
    }

    @Test(priority = 1)
    public void secondTest() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        // driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"TAMAM\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"4. Default values\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"An example that uses an edit text dialog\")")).click();
        driver.findElement(By.id("android:id/edit")).clear();
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("android:id/edit")), "cat").perform();
    }

    @Test(priority = 2)
    public void thirdTest() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"App\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Activity\")")).click();
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 600,
                "direction", "down",
                "percent", 5.0
        ));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Wallpaper\")")).click();

    }

    @Test(priority = 3)
    public void fourthTest() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"App\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Activity\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Wallpaper\"))"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Wallpaper\")")).click();
    }

    @Test(priority = 4)
    public void fifthTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Drag and Drop\")")).click();
        WebElement element = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void sixthTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Drag and Drop\")")).click();
        WebElement element = driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 350,
                "endY", 210
        ));
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void seventhTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"WebView\")")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void eighthTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        Thread.sleep(3000);
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 600,
                "direction", "down",
                "percent", 5.0
        ));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"WebView\")")).click();
    }

    @Test(priority = 8)
    public void ninethTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Activity activity = new Activity("com.touchboarder.android.api.demos", "com.example.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void tenthTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        DeviceRotation deviceRotation = new DeviceRotation(0,0,90);
        driver.rotate(deviceRotation);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Accessibility\")")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 10)
    public void eleventhTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"API Demos\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Accessibility\")")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(3000);

    }

}



