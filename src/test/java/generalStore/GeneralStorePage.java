package generalStore;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AndroidActions;

public class GeneralStorePage extends AndroidActions {

    AndroidDriver driver;
    public GeneralStorePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //WEBELEMENTLER
    @AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id ="android:id/text1")
    public WebElement countryField;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    @AndroidFindBy(xpath ="(//*[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]")
    private WebElement addToCartButton;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
    private WebElement visitToWebSite;


    //METODLAR
    public void setNameField(String name){
        nameField.sendKeys(name);
    }

    public void setGenderField(String name){
        if(name.equalsIgnoreCase("Male")){
           maleOption.click();
        }
        else{
           femaleOption.click();
        }
    }

    public void setCountryField(String countryName) {
        countryField.click();
        scrolToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

    public void submitForm() {
    shopButton.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartButton.click();
    }

    public void goToWebForPurchase() {
        visitToWebSite.click();
    }

    public void verifyToastMessageIs(String text){
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        System.out.println("toastMessage = " + toastMessage);
        Assert.assertEquals(toastMessage,text);
    }

}




