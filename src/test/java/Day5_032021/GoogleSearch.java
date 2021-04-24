package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException { //InterruptedException is needed for "sleep"

        //set the property of the ChromeDriver and define
        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");
        //driver.manage().window().maximize();

        //Sometimes a pause if necessary if system is faster
        //Thread.sleep(1000);

        //driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Jujutsu Kaisen");

        //Clicks on the link for "Gmail" on home page
        driver.findElement(By.xpath("//*[text()='Gmail']")).click();

        //driver.findElement(By.xpath("//*[@name='btnK']")).submit(); //presses "enter" on keyboard to search

        //Thread.sleep(1000);

        //capture search result and print number of search results
        //String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //split and extract the number
        //String[] arrayResults = searchResult.split(" ");

        //print
        //System.out.println("The number of search results is " + arrayResults[1] + ".");


    }
}
