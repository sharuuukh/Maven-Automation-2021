package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_CartPage extends Abstract_Class {

    ExtentTest logger1;
    public E_CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@id='qdd-0-quantity']")
    WebElement changeQuantity;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutButton;
    @FindBy(xpath = "//button[text()='Checkout as Guest']")
    WebElement guestCheckoutButton;

    public void setChangeQuantity(String Quantity) {
        Reusable_Actions_PageObject.dropdownByText(driver, changeQuantity, Quantity, logger, "Change Quantity");
    }
    public void setCheckoutButton() {
        Reusable_Actions_PageObject.clickOnElement(driver, checkoutButton, logger, "Checkout");
    }
    public void setGuestCheckoutButton() {
        Reusable_Actions_PageObject.clickOnElement(driver, guestCheckoutButton, logger, "Guest Checkout");
    }
}
