package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_UploadPage extends Abstract_Class {

    ExtentTest logger1;
    public F_UploadPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@name='upload-files-button']")
    WebElement UploadFileButton;
    @FindBy(xpath = "//a[text()='CONTINUE WITH EXISTING']")
    WebElement LowResPopUp;
    @FindBy(xpath = "//input[@id='item-quantity']")
    WebElement ItemQuantityField;
    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement AddToCart;

    public void setUploadImage() {
        Reusable_Actions_PageObject.uploadFile("C:\\Users\\sharu\\Pictures\\51661_anime_scenery.jpg", logger);
    }
    public void setUploadFileButton() {
        Reusable_Actions_PageObject.clickOnElement(driver, UploadFileButton, logger, "Upload File Button");
    }
    public void setLowResPopUp() {
        Reusable_Actions_PageObject.clickOnElement(driver, LowResPopUp, logger, "Continue with Low Res Image");
    }
    public void setItemQuantityField(){
        Reusable_Actions_PageObject.sendKeysMethod(driver, ItemQuantityField, "5", logger, "Item Quantity Field");
    }
    public void setAddToCart(){
        Reusable_Actions_PageObject.clickOnElement(driver, AddToCart, logger, "Add to Cart");
    }
}
