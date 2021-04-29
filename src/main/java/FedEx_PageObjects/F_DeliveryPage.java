package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_DeliveryPage extends Abstract_Class {


    ExtentTest logger1;
    public F_DeliveryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//select[@id='radiusSelect']")
    WebElement RadiusSelect;
    @FindBy(xpath = "//input[@name='locSearchTxt']")
    WebElement ZipCodeInput;
    @FindBy(xpath = "//a[@id='saveNContBtn']")
    WebElement ContinueButton;
    @FindBy(xpath = "//li[@id='5621']")
    WebElement FirstResult;

    public void setRadiusSelect() {
        Reusable_Actions_PageObject.dropdownByText(driver, RadiusSelect, "5 Miles", logger, "Radius Select");
    }
    public void setZipCodeInput(){
       Reusable_Actions_PageObject.sendKeysMethod(driver, ZipCodeInput,"11218", logger, "Zip Code Input");
    }
    public void setContinueButton(){
       Reusable_Actions_PageObject.clickOnElement(driver, ContinueButton, logger, "Continue Button");
    }
    public void setFirstResult(){
        Reusable_Actions_PageObject.captureText(driver, FirstResult, 0, logger, "First Result");
    }
}
