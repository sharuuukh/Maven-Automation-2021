package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_CheckoutPage extends Abstract_Class {

    ExtentTest logger1;
    public E_CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement LastName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement Email;
    @FindBy(xpath = "//input[@name='confirmEmail']")
    WebElement confirmEmail;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneNumber;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//input[@name='shipping.line1']")
    WebElement streetAddress;
    @FindBy(xpath = "//input[@name='shipping.postalCode']")
    WebElement ZipCode;
    @FindBy(xpath = "//input[@name='shipping.city']")
    WebElement city;
    @FindBy(xpath = "//select[@name='shipping.state']")
    WebElement state;
    @FindBy(xpath = "//*[text()='NO, THANK YOU']")
    WebElement checkoutPopup;
    @FindBy(xpath = "//input[@name='creditCardNumber']")
    WebElement CreditCardNumber;
    @FindBy(xpath = "//select[@name='expMonth']")
    WebElement expiryMonth;
    @FindBy(xpath = "//select[@name='expYear']")
    WebElement expiryYear;
    @FindBy(xpath = "//input[@name='cvv']")
    WebElement cvvNumber;
    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement placeOrder;
    @FindBy(xpath = "//div[@class='dOxMH labelError']")
    WebElement errorMessage;


    public void setFirstName(String firstName) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, FirstName, firstName, logger, "First Name");
    }
    public void setLastName(String lastName) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, LastName, lastName, logger, "Last Name");
    }
    public void setEmail(String email) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, Email, email, logger, "Email Address");
    }
    public void setConfirmEmail(String email) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, confirmEmail, email, logger, "Confirm Email Address");
    }
    public void setPhoneNumber(String Phone) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, phoneNumber, Phone, logger, "Phone Number");
    }
    public void setContinueButton() {
        Reusable_Actions_PageObject.clickOnElement(driver, continueButton, logger, "Continue Button");
    }
    public void setStreetAddress(String Address) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, streetAddress, Address, logger, "Street Address");
    }
    public void setZipCode(String zipCode) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, ZipCode, zipCode, logger, "Zip Code");
    }
    public void setCity(String City) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, city, City, logger, "Shipping City");
    }
    public void setState(String State) {
        Reusable_Actions_PageObject.dropdownByText(driver, state, State, logger, "Shipping State");
    }
    public void setCheckoutPopup(){
        Reusable_Actions_PageObject.popUpMessage(driver, checkoutPopup, logger, "Checkout Popup");
    }
    public void setCreditCardNumber(String ccNumber) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, CreditCardNumber, ccNumber, logger, "CC Number");
    }
    public void setExpiryMonth(String expMonth) {
        Reusable_Actions_PageObject.dropdownByText(driver, expiryMonth, expMonth, logger, "Expiration Month");
    }
    public void setExpiryYear(String expYear) {
        Reusable_Actions_PageObject.dropdownByText(driver, expiryYear, expYear, logger, "Expiration Year");
    }
    public void setCvvNumber(String cvvCode) {
        Reusable_Actions_PageObject.sendKeysMethod(driver, cvvNumber, cvvCode, logger, "CVV Number");
    }
    public void setPlaceOrder() {
        Reusable_Actions_PageObject.clickOnElement(driver, placeOrder, logger, "Place Order");
    }
    public String setErrorMessage() {
        String error = Reusable_Actions_PageObject.captureText(driver, errorMessage, 0, logger, "Error Message");
        logger.log(LogStatus.INFO,"The error message is: " + error);
        return error;
    }
}
