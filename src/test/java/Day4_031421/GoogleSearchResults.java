package Day4_031421;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResults {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");



    }
}
