package GeneralStore;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

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
    @Test //ÖNEMLİ : Scroll her halukarda en sona gidiyor eğer click edilecek element yukarıda kalırsa bulamıyor kod çalışmıyor.
    public void thirdTest() throws MalformedURLException {
        driver.findElement(By.id("android:id/text1")).click();
        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 600,
                    "direction", "down",
                    "percent", 3.0
            ));
        }
        driver.findElement(By.xpath("//android.widget.TextView[@text='Zambia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

    @Test
    public void sixthTest() throws MalformedURLException {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(By.xpath("(//*[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]"));
    }

    @Test @Ignore
    //ÇALIŞMADI BAKACAĞIM. KOPYALA YAPIŞTIR KAYNAKLI SORUNLAR VAR. DÜZELECEK
    public void fourthTest() throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Engin");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        Dimension dimension = driver.manage().window().getSize();
        Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));
        int i=0;
        while(i == 0){
         Thread.sleep(1000);
         ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of(
                            "left", midPoint.x * 0.5, "top", midPoint.y * 0.5,
                            "width", midPoint.x, "height", midPoint.y,
                            "direction", "up",
                            "percent", 0.75,
                            "speed", 1 * 1000));

            List<WebElement> list = driver.findElements(By.xpath("//android.widget.TextView"));
            for (WebElement each : list) {
                //System.out.println("each.getText() = " + each.getText());
                if (each.getText().equals("Argentina")) {
                    i =0;
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
                    Thread.sleep(3000);
                    break;
                }
            }
            if (i==1) break;
        }

    }


    @Test //HYBRID
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