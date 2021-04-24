package Google_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends Abstract_Class{

    //constructor is a method which uses the same name as java class to
    //store information that you want to use locally to this class
    //especially dealing with page object

    //declare local logger so you can use it in your page class
    ExtentTest logger1;
    public Home_Page(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    } //end of constructor class

    //define all WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement googleSearch;
    @FindBy (xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

    //create a method for google search
    public void EnterKeywordOnGoogleSearch(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver, googleSearch, userValue, logger, "Google Search");
    }

    //create a method for google search button
    public void SubmitGoogleSearchButton(){
        Reusable_Actions_PageObject.submitElement(driver, googleSearchButton, logger, "Google Search Button");
    }


}
