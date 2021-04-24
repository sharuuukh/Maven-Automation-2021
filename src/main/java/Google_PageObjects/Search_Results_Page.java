package Google_PageObjects;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Results_Page extends Abstract_Class {

    ExtentTest logger1;
    public Search_Results_Page(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger1 = Abstract_Class.logger;
    }

    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement googleSearchResult;

    public void getSearchNumber(){
        String result = Reusable_Actions_PageObject.captureText(driver, googleSearchResult, 0, logger, "Search Result Number");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO, "Search number is " + arrayResult[1]);
    }
}