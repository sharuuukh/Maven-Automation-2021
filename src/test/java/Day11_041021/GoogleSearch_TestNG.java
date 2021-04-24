package Day11_041021;

import Day9_040321.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearch_TestNG {
    /** capture search result for google **/

    //declare global variables outside of annotation method
    WebDriver driver;

    //use before suite when you have multiple @test method
    @BeforeSuite
    public void setupDriver() {
        driver = Reusable_Methods.defineTheDriver();
    } //end of driver setup

    //navigate to google, enter a keyword and hit submit
    @Test (priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);
        //enter a keyword
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "cars", "Google Search");
        Reusable_Methods.submitElement(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2500);
    } //end of google search

    //capture search number from result page
    @Test (dependsOnMethods = "googleSearch")
    public void captureSearchNumber() {
        String result = Reusable_Methods.captureText(driver, "//*[@id='result-stats']", 0, "Result Output");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    } //end of google search

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

}
