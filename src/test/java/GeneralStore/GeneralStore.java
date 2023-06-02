package GeneralStore;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GeneralStore extends BaseTestGeneralStore {

    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
    }
    @Test
    public void secondTest() throws MalformedURLException {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkey\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Turkey']")).click();
        // driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        System.out.println("toastMessage = " + toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}