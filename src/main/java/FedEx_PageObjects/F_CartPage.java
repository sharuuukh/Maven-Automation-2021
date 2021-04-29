package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_CartPage extends Abstract_Class {

    ExtentTest logger1;
    public F_CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//a[@id='cartToCheckoutBtn']")
    WebElement CheckoutButton;
    @FindBy(xpath = "//a[@id='continueAsGuest']")
    WebElement ContinueAsGuest;

    public void setCheckoutButton() {
        Reusable_Actions_PageObject.clickOnElement(driver, CheckoutButton, logger, "Checkout Button");
    }
    public void setContinueAsGuest(){
        Reusable_Actions_PageObject.clickOnElement(driver, ContinueAsGuest, logger, "Proceed as Guest");
    }
}
