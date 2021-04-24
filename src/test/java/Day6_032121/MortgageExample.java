package Day6_032121;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MortgageExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(2000);

        //Verify the title with your expected
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("mortgage calculator")){
            System.out.println("Title matches.");
        } else{
            System.out.println("Title does not match actual title: " + actualTitle);
        }//end of condition

        //store home value
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear previous data
        homeValue.clear();
        //enter the new home value
        homeValue.sendKeys("450000");

        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("220000");

        //store the locator
        WebElement months = driver.findElement(By.xpath("//*[@name= 'param[start_month]']"));
        //Select the locator
        Select dropDown = new Select(months);
        //use visible text command to choose month
        dropDown.selectByVisibleText("Jun");


        //if drop down is not under select tag, then you have to use the click command twice
        //months.click();
        //driver.findElement(By.xpath("//*[text()='May']")).click();

        //click on Calculate button
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(3000);

        //capture monthly payment using findElements //div used here to be more specific
        String mntPayment = driver.findElements(By.xpath("//div[@class='left-cell']")).get(0).getText();
        System.out.println("My total monthly payment is " + mntPayment);

    }//end of main
}//end of class