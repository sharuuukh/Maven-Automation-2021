package Day12_041121;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class googleSearch_HTMLReport extends Abstract_Class {

    @Test
    public void SearchForACar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1500);

        Reusable_Actions.sendKeysMethod(driver,"//*[@name='q']","cars",logger,"Search Field");
        Reusable_Actions.submitElement(driver, "//*[@name='btnK']", logger, "Google Search");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "SearchForACar")
    public void getSearchNumber(){
        String result = Reusable_Actions.captureText(driver, "//*[@id='result-stats']", 0, logger, "Search number");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);
    }

}
