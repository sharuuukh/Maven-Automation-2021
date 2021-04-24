package Day9_040321;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {

    //create a reusable method to navigate to a page
    public static WebDriver defineTheDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);


        return driver;
    } //end of navigate method


    public static void sendKeysMethod(WebDriver driver,String xpathLocator, String userValue,String elementName){

        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }
    }


    public static void submitElement(WebDriver driver, String xpathLocator, String elementName){

        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //use try and catch to locate an element and submit it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
        } catch (Exception e){
            System.out.println("Unable to submit element " + elementName + " " + e);
        }
    }


    public static void clickOnElement(WebDriver driver, String xpathLocator, String elementName) {

        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //use try and catch to locate an element and submit it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
        }
    }


    public static void dropdownByText(WebDriver driver, String xpath, String userValue, String elementName){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select dropdown " + elementName + " " + e);
        }
    }

        public static void mouseHover(WebDriver driver, String xpath, String elementName) {

            Actions mouseAction = new Actions(driver);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                mouseAction.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to locate 'Men's tab' element." + e);
            }

        }


    public static String captureText(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;

    }


} //end of class


