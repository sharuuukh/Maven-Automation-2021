package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_PrintOnlinePage extends Abstract_Class {

    ExtentTest logger1;
    public F_PrintOnlinePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@title='Document Printing']")
    WebElement DocumentPrinting;

    public void setVerifyTitle() {
        Reusable_Actions_PageObject.verifyTitle(driver, "Fedex Office Print", logger);
    }
    public void setDocumentPrinting() {
        Reusable_Actions_PageObject.clickOnElement(driver, DocumentPrinting, logger, "Document Printing Image");
    }

}
