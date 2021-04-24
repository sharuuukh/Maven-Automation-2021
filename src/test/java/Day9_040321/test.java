package Day9_040321;

import org.openqa.selenium.WebDriver;

public class test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Reusable_Methods.defineTheDriver();

        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);

        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']", "Cars", "Search Word");
        Reusable_Methods.submitElement(driver, "//*[@name='btnK']", "Google Search");

    }
}
