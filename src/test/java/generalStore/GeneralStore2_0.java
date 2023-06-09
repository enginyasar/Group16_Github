package generalStore;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class GeneralStore2_0 extends BaseTestGeneralStore {

    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {
        GeneralStorePage generalStorePage = new GeneralStorePage(driver);
        generalStorePage.setNameField("ENGİN");
        generalStorePage.setGenderField("Male");
        generalStorePage.setCountryField("Argentina");
        generalStorePage.submitForm();
        generalStorePage.addToCart();
        generalStorePage.goToCart();
        generalStorePage.goToWebForPurchase();
        Thread.sleep(3000);
    }
    @Test
    public void secondTest() throws MalformedURLException {
        GeneralStorePage generalStorePage = new GeneralStorePage(driver);
        generalStorePage.setGenderField("Male");
        generalStorePage.setCountryField("Argentina");
        generalStorePage.submitForm();
        generalStorePage.verifyToastMessageIs("Please enter your name");
    }


    @Test //HYBRID // //HENÜZ PAGE OBJECT MODEL UYGULANMADI
    public void fifthTest() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"ADD TO CART\")")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
        //Set<String> contextList = driver.getContextHandles();
        //for (String each : contextList) {
        //System.out.println(each);}
        driver.context("WEBVIEW_com.androidsample.generalstore");
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        Thread.sleep(3000);

        //driver.context("NATIVE_APP");

    }
}