package ActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Week3 {

    public static void main(String[] args) throws InterruptedException, IOException {

        String[] purchasePrice = new String[3];
        purchasePrice[0] = "200000";
        purchasePrice[1] = "450000";
        purchasePrice[2] = "500000";

        String[] downPayment = new String[3];
        downPayment[0] = "10";
        downPayment[1] = "15";
        downPayment[2] = "20";

        String[] mortgageTerm = new String[3];
        mortgageTerm[0] = "15";
        mortgageTerm[1] = "20";
        mortgageTerm[2] = "25";

        String[] interestRate = new String[3];
        interestRate[0] = "2";
        interestRate[1] = "3";
        interestRate[2] = "6";

        String[] PMI = new String[3];
        PMI[0] = "0.40";
        PMI[1] = "0.50";
        PMI[2] = "0.60";

        String[] startMonth = new String[3];
        startMonth[0] = "Jan";
        startMonth[1] = "Jun";
        startMonth[2] = "Nov";

        String[] startYear = new String[3];
        startYear[0] = "2025";
        startYear[1] = "2030";
        startYear[2] = "2035";

        //Runtime.getRuntime().exec("killall /F /IM chromedriver /T");

        System.setProperty("webdriver.chrome.driver", "/Users/sharukh/Desktop/QA Course/Maven Automation/src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < 3; i++){

            driver.navigate().to("https://www.mlcalc.com");

            Thread.sleep(1500);

            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Auto Mortgage Calculator")) {
                System.out.println("Actual title is: " + actualTitle);
            } else {
                System.out.println("Failed! Actual title is: " + actualTitle);
            }

            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys(purchasePrice[i]);

            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys(downPayment[i]);

            WebElement mTerm = driver.findElement(By.xpath("//*[@name='mt']"));
            mTerm.clear();
            mTerm.sendKeys(mortgageTerm[i]);

            WebElement iRate = driver.findElement(By.xpath("//*[@name='ir']"));
            iRate.clear();
            iRate.sendKeys(interestRate[i]);

            WebElement pmiPercentage = driver.findElement(By.xpath("//*[@name='mi']"));
            pmiPercentage.clear();
            pmiPercentage.sendKeys(PMI[i]);

            WebElement Month = driver.findElement(By.xpath("//*[@id='fpdd']"));
            Select dropMenu = new Select(Month);
            dropMenu.selectByVisibleText(startMonth[i]);

            WebElement Year = driver.findElement(By.xpath("//*[@id='fpdy']"));
            Select dropMenu2 = new Select(Year);
            dropMenu2.selectByVisibleText(startYear[i]);

            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            Thread.sleep(1500);

            String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
            System.out.println("Your monthly payment is $" + mntPayment);

        }//end of loop

    }
}
