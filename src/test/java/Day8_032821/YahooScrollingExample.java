package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YahooScrollingExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        driver.findElement(By.xpath("//*[@id='ybar-search']")).click();

        Thread.sleep(1500);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,5000)");

        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        String[] arrayResult = result.split("Next");
        String[] arrayNumber = arrayResult[1].split("results");

        System.out.println("My print number is " + arrayNumber[0]);

        jse.executeScript("scroll(0,-5000)");
        driver.findElement(By.xpath("//*[@id='ysignin']")).click();
    }
}
