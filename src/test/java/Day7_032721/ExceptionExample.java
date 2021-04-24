package Day7_032721;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class ExceptionExample {

    public static void main(String[] args) throws InterruptedException, IOException {

        Runtime.getRuntime().exec("killall -KILL chromedriver");
        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.bing.com");
        Thread.sleep(1500);

        try {
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Jujutsu Kaisen");
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on Search field." + e);
        }

        try {
            driver.findElement(By.xpath("//*[@for='sb_form']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on search button." + e);
        }

    }
}
