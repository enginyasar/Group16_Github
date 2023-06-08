package myTheresa;

import GeneralStore.BaseTestGeneralStore;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class MyTheresa extends BaseTestGeneralStore {
    UiAutomator2Options options;
    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        options = new UiAutomator2Options().setPlatformName("Android")
                .setAppPackage("com.mytheresa.app.mytheresa")
                .setAppActivity("com.mytheresa.app.mytheresa.MainActivity")
                .setUdid("emulator-5554")
                .setAutomationName("uiautomator2")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofMinutes(10));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); //the default Appium server address and port
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
   /* @Test
    public void firstTest() throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
    }*/

    //NETTEN ALDIM BU METODU AMA ÇALIŞMADI
    private void raiseToast(String text) {
        ImmutableMap<String, Object> scriptArgs = ImmutableMap.of(
                "target", "application",
                "methods", Arrays.asList(ImmutableMap.of(
                        "name", "raiseToast",
                        "args", Arrays.asList(ImmutableMap.of(
                                "value", text,
                                "type", "String"
                        ))
                ))
        );

        driver.executeScript("mobile: backdoor", scriptArgs);
    }

    @Test //ÇALIŞTI. AMA ALTTAKİ MYTHERESA1 İLE NE FARKI VAR BAKACAĞIM.
    public void firstTest1() throws MalformedURLException, InterruptedException {

        Dimension dimension = driver.manage().window().getSize();
        Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));

        for (int i = 0; i < 1; i++) {
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of(
                            "left", midPoint.x * 0.5, "top", midPoint.y * 0.5,
                            "width", midPoint.x, "height", midPoint.y,
                            "direction", "left",
                            "percent", 0.75,
                            "speed", 5 * 1000));
        }
        Thread.sleep(4000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"SHOP WOMEN\")")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CONTİNUE AS GUEST\")")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='qa-footer-burger-menu']/android.widget.ImageView")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("className(\"android.view.ViewGroup\").instance(51)")).click();
        Thread.sleep(2000);
        Set<String> contextList = driver.getContextHandles();
        for (String each : contextList) {
            System.out.println(each);}
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Shoulder Bags\")")).click();
        Thread.sleep(5000);
        Set<String> contextList1 = driver.getContextHandles();
        for (String each : contextList1) {
            System.out.println(each);}
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Locò Small Toile Iconographe shoulder bag | Valentino Garavani\")")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("android.widget.Image")).click();


//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"qa-menu-item-View All-0\"]/android.widget.TextView")).click();


        //driver.findElement(By.className("webkit.WebView")).click();
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CHRISTIAN LOUBOUTIN\")")).click();
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("className('android.widget.TextView').instance(15)")).click();
    }

    @Test @Ignore
    //TOAST MESAJ BULAMADI. KOD ÇALIŞMADI
    public void mytheresa() throws InterruptedException {
        Set<String> contextList = driver.getContextHandles();
        for (String each : contextList) {
            System.out.println(each);}
            Dimension dimension = driver.manage().window().getSize();
            Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));

            for (int i = 0; i < 1; i++) {
                Thread.sleep(2000);
                ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                        ImmutableMap.of(
                                "left", midPoint.x * 0.5, "top", midPoint.y * 0.5,
                                "width", midPoint.x, "height", midPoint.y,
                                "direction", "left",
                                "percent", 0.75,
                                "speed", 5 * 1000));
            }
            Set<String> contextList2 = driver.getContextHandles();
            for (String each : contextList2) {
                System.out.println(each);
            }
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"SHOP WOMEN\")")).click();
            //driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CONTINUE AS GUEST\")")).click();
            Set<String> contextList3 = driver.getContextHandles();
            for (String each : contextList3) {
                System.out.println(each);
            }
            Thread.sleep(2000);
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CONTİNUE AS GUEST\")")).click();
            Set<String> contextList4 = driver.getContextHandles();
            for (String each : contextList4) {
                System.out.println(each);
            }
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"qa-footer-burger-menu\"]/android.widget.ImageView")).click();
            Set<String> contextList5 = driver.getContextHandles();
            for (String each : contextList5) {
                System.out.println(each);
            }

            driver.findElement(AppiumBy.accessibilityId("qa-menu-item-Bags-5")).click();
            Thread.sleep(3000);
            Set<String> contextList6 = driver.getContextHandles();
            for (String each : contextList6) {
                System.out.println(each);
            }
            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"qa-menu-item-Clutches-4\"]/android.widget.TextView")).click();
            Thread.sleep(3000);
            Set<String> contextList7 = driver.getContextHandles();
            for (String each : contextList7) {
                System.out.println(each);
            }
            driver.findElement(By.xpath("//android.view.View[@content-desc='Dante leather clutch bag | The Row']/android.view.View/android.view.View/android.widget.Image")).click();
            Thread.sleep(3000);
            Set<String> contextList8 = driver.getContextHandles();
            for (String each : contextList8) {
                System.out.println(each);
            }
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"ADD TO BAG\")")).click();


        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.println("toastMessage = " + toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");

            Thread.sleep(3000);
            Set<String> contextList9 = driver.getContextHandles();
            for (String each : contextList9) {
                System.out.println(each);
            }
          //  driver.context("buraya konsolda yazan webview adını buraya giriyoruz");
        }

    @Test //BU KOD ÇALIŞTI
    public void mytheresa1() throws InterruptedException {
        Dimension dimension = driver.manage().window().getSize();
        Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));

        for (int i = 0; i < 1; i++) {
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of(
                            "left", midPoint.x * 0.5, "top", midPoint.y * 0.5,
                            "width", midPoint.x, "height", midPoint.y,
                            "direction", "left",
                            "percent", 0.75,
                            "speed", 5 * 1000));
        }
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"SHOP WOMEN\")")).click();
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CONTINUE AS GUEST\")")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"CONTİNUE AS GUEST\")")).click();

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"qa-footer-burger-menu\"]/android.widget.ImageView")).click();

        driver.findElement(AppiumBy.accessibilityId("qa-menu-item-Bags-5")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"qa-menu-item-Clutches-4\"]/android.widget.TextView")).click();
        Thread.sleep(3000);
        Set<String> contextList7 = driver.getContextHandles();
        for (String each : contextList7) {
            System.out.println(each);
        }
        driver.findElement(By.xpath("//android.view.View[@content-desc='Dante leather clutch bag | The Row']/android.view.View/android.view.View/android.widget.Image")).click();
        Thread.sleep(3000);
        Set<String> contextList8 = driver.getContextHandles();
        for (String each : contextList8) {
            System.out.println(each);
        }
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"ADD TO BAG\")")).click();
        Thread.sleep(3000);
        Set<String> contextList9 = driver.getContextHandles();
        for (String each : contextList9) {
            System.out.println(each);
        }
        //  driver.context("buraya konsolda yazan webview adını buraya giriyoruz");
    }
    }
