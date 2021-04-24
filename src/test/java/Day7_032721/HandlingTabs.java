package Day7_032721;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class HandlingTabs {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.oxhp.com");
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[contains(@onmouseover, '/images/home/members_hm_on')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[contains(text(), 'Find a Physician')]")).click();

        ArrayList<String>tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(1000);

        try {
            driver.findElements(By.xpath("//*[@target='_blank']")).get(0).click();
        } catch (Exception e) {
            System.out.println("Element for 'Metro' not correct." + e);
        }

        //driver.close();
        driver.switchTo().window(tabs.get(0));


    }

}
