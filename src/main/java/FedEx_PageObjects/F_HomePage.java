package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_HomePage extends Abstract_Class {

    ExtentTest logger1;
    public F_HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@aria-label='Open Design & Print menu']")
    WebElement DesignPrintTab;
    @FindBy(xpath = "//*[@aria-label='Upload a Print-Ready File']")
    WebElement UploadFileTab;

    public void setDesignPrintTab() {
        Reusable_Actions_PageObject.clickOnElement(driver, DesignPrintTab, logger, "Design & Print Tab");
    }
    public void setUploadFileTab() {
        Reusable_Actions_PageObject.clickOnElement(driver, UploadFileTab, logger, "Upload File Tab");
    }






}
