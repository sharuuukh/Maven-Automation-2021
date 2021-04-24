package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingIterationWithGoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        /** iterate through multiple cities on google search and print out the number each time **/

        //declare and define array list
        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Bronx";

        //set the driver path and define it
        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //the actual use case from start to finish should be within the for/while loop for multiple iterations
        for (int i = 0; i < cities.length; i++) {

            driver.navigate().to("https://www.google.com");

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            Thread.sleep(1000);

            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            String[] arrayResults = searchResult.split(" ");

            System.out.println("The number of search results for " + cities[i] + " is " + arrayResults[1] + ".");

        }//end of for loop

        driver.quit();
    }
}
