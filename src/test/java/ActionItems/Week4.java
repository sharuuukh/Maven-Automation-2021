package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;


public class Week4 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> findLocationByZip = new ArrayList<>();
        findLocationByZip.add("11218");
        findLocationByZip.add("10305");
        findLocationByZip.add("10004");

        ArrayList<String> locationType = new ArrayList<>();
        locationType.add("Collection Boxes");
        locationType.add("Self-Service Kiosks");
        locationType.add("Contract Postal Unit");

        ArrayList<String> locationMile = new ArrayList<>();
        locationMile.add("10 Miles");
        locationMile.add("25 Miles");
        locationMile.add("50 Miles");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        Actions mouseAction = new Actions(driver);

        //start of iteration
        for (int i = 0; i < 3; i++) {

            //Navigate to USPS.com
            try {
                driver.navigate().to("https://www.usps.com");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error navigating to website." + e);
            }

            //Verify Title
            try {
                String actualTitle = driver.getTitle();
                if (actualTitle.equals("Welcome | USPS")) {
                    System.out.println("Actual title is: " + actualTitle);
                } else {
                    System.out.println("Failed! Actual title is: " + actualTitle);
                }
            } catch (Exception e) {
                System.out.println("Error verifying title of website." + e);
            }

            //Hover over 'send' tab
            try {
                WebElement send = driver.findElement(By.xpath("//*[text()='Send']"));
                mouseAction.moveToElement(send).perform();
            } catch (Exception e) {
                System.out.println("Error hovering over 'Send' tab." + e);
            }

            //Click on 'Find USPS Locations'
            try {
                WebElement locations = driver.findElement(By.xpath("//*[@class='tool-find']"));
                mouseAction.moveToElement(locations).click().perform();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error clicking on 'Find USPS Locations'." + e);
            }

            //Enter zip codes on text field
            try {
                WebElement zips = driver.findElement(By.xpath("//*[@id='city-state-input']"));
                mouseAction.moveToElement(zips).click().sendKeys(findLocationByZip.get(i)).perform();
            } catch (Exception e) {
                System.out.println("Error sending zip codes to text field." + e);
            }

            //Select location type from drop down menu
            try {
                WebElement locType = driver.findElement(By.xpath("//*[@id='post-offices-select']"));
                locType.click();
                driver.findElement(By.xpath("//*[text()='"+locationType.get(i)+"']")).click();
            } catch (Exception e) {
                System.out.println("Error selecting location type." + e);
            }

            //Select mile radius from drop down menu
            try {
                WebElement withinMiles = driver.findElement(By.xpath("//*[@id='within-select']"));
                withinMiles.click();
                driver.findElement(By.xpath("//*[text()='"+locationMile.get(i)+"']")).click();
            } catch (Exception e) {
                System.out.println("Error selecting mile radius." + e);
            }

            //Click on Search Button
            try {
                driver.findElement(By.xpath("//*[@id='searchLocations']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Error clicking on search button." + e);
            }

            //Iterate clicking the 1st, 2nd, 3rd search results using different methods
            try {
                ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class='location-address']")));
                if (i == 0) {
                    links.get(0).click();
                } else if (i == 1) {
                    links.get(1).click();
                } else {
                    links.get(2).click();
                }
            } catch (Exception e) {
                System.out.println("Error clicking on search results." + e);
            }

            //Capture and print the address
            try {
                String address = driver.findElement(By.xpath("//*[@id='detailAddress']")).getText();
                String address2 = driver.findElement(By.xpath("//*[@id='cityStateZip']")).getText();
                System.out.println(address + " " + address2);
            } catch (Exception e) {
                System.out.println("Error printing the address of the selected location." + e);
            }

            Thread.sleep(2000);

            //Capture the hours
            try {
                String hours = driver.findElement(By.xpath("//*[text()='Hours']")).getText();
                System.out.println(hours);
                String time = driver.findElement(By.xpath("//div[@class='hours-flex-section']")).getText();
                System.out.println(time);
            } catch (Exception e) {
                System.out.println("Error printing the hours of operation." + e);
            }

        }//end of iteration

    }//end of main
}
