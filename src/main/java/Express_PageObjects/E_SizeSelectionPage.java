package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_SizeSelectionPage extends Abstract_Class {

    ExtentTest logger1;
    public E_SizeSelectionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//button[text()='Add to Bag']")
    WebElement addToBag;
    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement viewBag;

    public void setSizeSelection(String Size) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@value='" + Size + "']"))).click();
        }
        catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on size: " + Size + " " + e);
            Reusable_Actions_PageObject.getScreenShot(driver, "Size Selection", logger);
        }
    }
    public void setAddToBag() {
        Reusable_Actions_PageObject.clickOnElement(driver, addToBag, logger, "Add to Bag");
    }
    public void setViewBag() {
        Reusable_Actions_PageObject.clickOnElement(driver, viewBag, logger, "View Bag");
    }



}
