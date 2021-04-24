package Day12_041121;

import Day9_040321.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {

    @Test
    public void assertions(){
        WebDriver driver = Reusable_Methods.defineTheDriver();

        driver.navigate().to("https://www.google.com");

        //Hard Assert to verify title
        //Test stop if hard assert fails
        //Assert.assertEquals("Google", driver.getTitle());

        //Soft Assert to verify title
        //Test won't stop if this fails
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("google", driver.getTitle());

        //enter something on search box
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "cars", "Google Search");

        //This command prints out any failures and error messages
        softAssert.assertAll();
    }
}
