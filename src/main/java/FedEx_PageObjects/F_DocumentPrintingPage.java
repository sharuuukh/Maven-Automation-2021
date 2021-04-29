package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_DocumentPrintingPage extends Abstract_Class {

    ExtentTest logger1;
    public F_DocumentPrintingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@title='Copies & Custom Projects']")
    WebElement CopiesCustomProjects;

    public void setCopiesCustomProjects() {
        Reusable_Actions_PageObject.clickOnElement(driver, CopiesCustomProjects, logger, "Copies Custom Projects Image");
    }




}
