package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(1000);

        Actions mouseAction = new Actions(driver);

        //hover over Quick Tools
        try {
            WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
            mouseAction.moveToElement(quickTools).perform();
        } catch (Exception e) {
            System.out.println("Unable to locate 'Quick Tools' element." + e);
        }

        //Click on track a package
        try {
            WebElement track = driver.findElement(By.xpath("//*[text()='Track a Package']"));
            mouseAction.moveToElement(track).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to locate 'Track a Package' element." + e);
        }

        Thread.sleep(2000);

        //Enter Text on a field
        try {
            WebElement trackingNo =  driver.findElement(By.xpath("//*[@id='tracking-input']"));
            mouseAction.moveToElement(trackingNo).click().sendKeys("123456789").perform();
        } catch (Exception e) {
            System.out.println("Unable to input tracking number." + e);
        }

    } //end of class

}