package ActionItems;

import Day9_040321.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Week5 {

    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {


        //set the driver using reusable method
        WebDriver driver = Reusable_Methods.defineTheDriver();

        //locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ExpressCheckout.xls"));

        //create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ExpressResults.xls"), readableBook);

        //read everything from writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //get the row count
        int rowCount = writableSheet.getRows();

        //Start of loop
        for (int i = 1; i < rowCount; i++) {

            String Size = writableSheet.getCell(0,i).getContents();
            String Quantity = writableSheet.getCell(1,i).getContents();
            String firstName = writableSheet.getCell(2,i).getContents();
            String lastName = writableSheet.getCell(3,i).getContents();
            String eMail = writableSheet.getCell(4,i).getContents();
            String Phone = writableSheet.getCell(5,i).getContents();
            String Address = writableSheet.getCell(6,i).getContents();
            String zipCode = writableSheet.getCell(7,i).getContents();
            String City = writableSheet.getCell(8,i).getContents();
            String State = writableSheet.getCell(9,i).getContents();
            String ccNumber = writableSheet.getCell(10,i).getContents();
            String expMonth = writableSheet.getCell(11,i).getContents();
            String expYear = writableSheet.getCell(12,i).getContents();
            String cvvCode = writableSheet.getCell(13,i).getContents();


            //Step 1. Navigate to Express' website
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1500);

            //Close Pop-Up Tab
            Reusable_Methods.clickOnElement(driver, "//*[@id='closeModal']", "Pop-up Close Button");

            //Step 2. Hover over Men tab
            Reusable_Methods.mouseHover(driver, "//a[text()='Men']", "Men Tab");
            Thread.sleep(1000);

            //Step 3. Click on Sweatshirts & Hoodies
            Reusable_Methods.clickOnElement(driver, "//a[text()='Sweatshirts & Hoodies']", "Sweatshirts");
            Thread.sleep(1000);

            //Step 4. Click on first item
            Reusable_Methods.clickOnElement(driver, "//a[@class='_1-wQg']", "First item");
            Thread.sleep(1500);

            //Step 5. Click on a size
            Reusable_Methods.clickOnElement(driver, "//button[@value='" + Size + "']", "Size Selection");

            //Step 6. Click on Add to Bag
            Reusable_Methods.clickOnElement(driver, "//button[text()='Add to Bag']", "Add to Bag");
            Thread.sleep(1000);

            //Step 7. Click on View Bag from Pop-up
            Reusable_Methods.clickOnElement(driver, "//*[text()='View Bag']", "View Bag");

            //Step 8. Change the Quantity
            Reusable_Methods.dropdownByText(driver,"//*[@id='qdd-0-quantity']", Quantity, "Quantity of Item");

            //Step 9. Click on Checkout
            Reusable_Methods.clickOnElement(driver, "//button[text()='Checkout']", "Checkout Button");

            //Step 10. Click on Continue as Guest
            Reusable_Methods.clickOnElement(driver, "//button[text()='Checkout as Guest']", "Guest Checkout");
            Thread.sleep(1500);

            //Step 11-15. Enter First Name, Last Name, Email, Confirm Email, Phone Number
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='firstname']", firstName, "First Name");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='lastname']", lastName, "Last Name");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='email']", eMail, "Email Address");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='confirmEmail']", eMail, "Confirm Email Address");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='phone']", Phone, "Phone Number");
            Thread.sleep(1500);

            //Step 16. Click on Continue
            Reusable_Methods.clickOnElement(driver, "//span[text()='Continue']", "Continue Button");
            Thread.sleep(1500);

            //Step 17-20. Enter Address, Zip, City, State.
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.line1']", Address, "Street Address");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.postalCode']", zipCode, "Zip Code");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.city']", City, "City");
            Reusable_Methods.dropdownByText(driver, "//select[@name='shipping.state']", State, "State");

            //Step 21. Click on Continue
            Reusable_Methods.clickOnElement(driver, "//span[text()='Continue']", "Continue Button");
            Thread.sleep(4000);

            //Click on Continue again
            Reusable_Methods.clickOnElement(driver, "//span[text()='Continue']", "Continue Button");
            Thread.sleep(1500);

            //Step 22-25. Enter CC number, expiration month and year, CVV
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='creditCardNumber']", ccNumber, "CC Number");
            Reusable_Methods.dropdownByText(driver, "//select[@name='expMonth']", expMonth, "Exp Month");
            Reusable_Methods.dropdownByText(driver, "//select[@name='expYear']", expYear, "Exp Year");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='cvv']", cvvCode, "CVV");
            Thread.sleep(1500);

            //Step 26. Click on Place Order
            Reusable_Methods.clickOnElement(driver, "//span[text()='Place Order']", "Continue Button");
            Thread.sleep(1000);

            //Step 27. Capture error message and write it back to Excel
            String errorMessage = Reusable_Methods.captureText(driver,"//div[@class='dOxMH labelError']",0,"Error Message");
            Label error = new jxl.write.Label(14,i, errorMessage);
            writableSheet.addCell(error);

        } //end of loop

        //Write back to WorkBook and close it
        writableWorkbook.write();
        writableWorkbook.close();


    } //end of main

} //end of class
