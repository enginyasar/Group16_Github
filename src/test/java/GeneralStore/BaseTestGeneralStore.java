package GeneralStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestGeneralStore {
    UiAutomator2Options options;
    AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        options = new UiAutomator2Options().setPlatformName("Android")
                .setAppPackage("com.androidsample.generalstore")
                .setAppActivity("com.androidsample.generalstore.SplashActivity")
                .setUdid("emulator-5554")
                .setAutomationName("uiautomator2")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofMinutes(10));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //the default Appium server address and port
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
