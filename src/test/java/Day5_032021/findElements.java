package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElements {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        //use findElements to click on "Store" on home page //get(1) basically chooses the 2nd "class", like an array
        driver.findElements(By.xpath("//*[@class='MV3Tnb']")).get(1).click();
    }
}
