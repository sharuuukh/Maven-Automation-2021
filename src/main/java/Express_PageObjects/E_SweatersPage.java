package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_SweatersPage extends Abstract_Class {

    ExtentTest logger1;
    public E_SweatersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//a[@class='_1-wQg']")
    WebElement firstItemSelection;

    public void setFirstItemSelection() {
        Reusable_Actions_PageObject.clickOnElement(driver, firstItemSelection, logger, "First Item Selection");
    }
}
