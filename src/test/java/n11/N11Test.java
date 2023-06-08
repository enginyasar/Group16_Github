package n11;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class N11Test {

    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options().setPlatformName("Android")
                .setAppPackage("com.dmall.mfandroid")
                .setAppActivity("com.dmall.mfandroid.activity.base.NewSplash")
                .setUdid("emulator-5554")
                .setAutomationName("uiautomator2")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofMinutes(10));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(new AppiumBy.ByAccessibilityId("Kategoriler")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator
                ("text(\"Elektronik\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator
                ("text(\"Bilgisayar\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator
                ("text(\"Tablet\")")).click();

        Thread.sleep(3000);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator
                ("className(\"android.widget.ImageView\").instance(5)")).click();

    Thread.sleep(3000);

    Dimension dimension = driver.manage().window().getSize();
    Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));

        for (int i = 0; i < 8; i++) {
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of(
                            "left", midPoint.x * 0.5 , "top", midPoint.y * 0.5,
                            "width", midPoint.x,"height", midPoint.y,
                            "direction", "left",
                            "percent", 0.75,
                            "speed", 5 * 1000));
        }
    }
    }