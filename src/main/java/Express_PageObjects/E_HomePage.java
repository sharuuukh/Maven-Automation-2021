package Express_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_HomePage extends Abstract_Class {

    ExtentTest logger1;
    public E_HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@id='closeModal']")
    WebElement popUpClose;
    @FindBy(xpath = "//a[text()='Men']")
    WebElement menTab;
    @FindBy(xpath = "//a[text()='Sweatshirts & Hoodies']")
    WebElement sweatersTab;

    public void setPopUpClose() {
        Reusable_Actions_PageObject.popUpMessage(driver, popUpClose, logger, "Pop Up Close Button");
    }
    public void setMenTab() {
        Reusable_Actions_PageObject.mouseHover(driver, menTab, logger, "Men's Tab");
    }
    public void setSweatersTab() {
        Reusable_Actions_PageObject.clickOnElement(driver, sweatersTab, logger, "Sweater's Tab");
    }




}
