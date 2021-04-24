package Day12_041121;

import ReusableLibrary.Abstract_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class gettingLinkCount extends Abstract_Class {

    @Test
    public void linkCount() throws InterruptedException {

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);

        //Store the arrayList with class attribute for the links
        ArrayList<WebElement> linkCount = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '_yb_12gb1')]")));

        System.out.println("Number of links is " + linkCount.size());
    }
}
