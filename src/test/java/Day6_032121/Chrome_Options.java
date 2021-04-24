package Day6_032121;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized"); //DOES NOT WORK ON MAC
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); //Other way to maximize. Use this on Mac

        driver.navigate().to("https://www.yahoo.com");
   }
}
