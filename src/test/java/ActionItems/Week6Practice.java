package ActionItems;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Week6Practice extends Abstract_Class {

    @Test
    public void expressCheckout() throws IOException, BiffException, InterruptedException, WriteException {

        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ExpressCheckout.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ExpressResults.xls"), readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        int rowCount = writableSheet.getRows();

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
            Reusable_Actions.clickOnElement(driver, "//*[@id='closeModal']", logger, "Pop-up Close Button");

            //Step 2. Hover over Men tab
            Reusable_Actions.mouseHover(driver, "//a[text()='Men']", logger, "Men Tab");
            Thread.sleep(1000);

            //Step 3. Click on Sweatshirts & Hoodies
            Reusable_Actions.clickOnElement(driver, "//a[text()='Sweatshirts & Hoodies']", logger, "Sweatshirts");
            Thread.sleep(1000);

            //Step 4. Click on first item
            Reusable_Actions.clickOnElement(driver, "//a[@class='_1-wQg']", logger,  "First item");
            Thread.sleep(1500);

            //Step 5. Click on a size
            Reusable_Actions.clickOnElement(driver, "//button[@value='" + Size + "']", logger,  "Size Selection");

            //Step 6. Click on Add to Bag
            Reusable_Actions.clickOnElement(driver, "//button[text()='Add to Bag']", logger,  "Add to Bag");
            Thread.sleep(1000);

            //Step 7. Click on View Bag from Pop-up
            Reusable_Actions.clickOnElement(driver, "//*[text()='View Bag']", logger,  "View Bag");

            //Step 8. Change the Quantity
            Reusable_Actions.dropdownByText(driver,"//*[@id='qdd-0-quantity']", Quantity, logger, "Quantity of Item");

            //Step 9. Click on Checkout
            Reusable_Actions.clickOnElement(driver, "//button[text()='Checkout']", logger, "Checkout Button");

            //Step 10. Click on Continue as Guest
            Reusable_Actions.clickOnElement(driver, "//button[text()='Checkout as Guest']", logger, "Guest Checkout");
            Thread.sleep(1500);

            //Step 11-15. Enter First Name, Last Name, Email, Confirm Email, Phone Number
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='firstname']", firstName, logger, "First Name");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='lastname']", lastName, logger,"Last Name");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='email']", eMail, logger, "Email Address");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='confirmEmail']", eMail, logger,"Confirm Email Address");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='phone']", Phone, logger,"Phone Number");
            Thread.sleep(1500);

            //Step 16. Click on Continue
            Reusable_Actions.clickOnElement(driver, "//span[text()='Continue']",logger, "Continue Button");
            Thread.sleep(1500);

            //Step 17-20. Enter Address, Zip, City, State.
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='shipping.line1']", Address, logger,"Street Address");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='shipping.postalCode']", zipCode, logger, "Zip Code");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='shipping.city']", City, logger,"City");
            Reusable_Actions.dropdownByText(driver, "//select[@name='shipping.state']", State, logger,"State");

            //Step 21. Click on Continue
            Reusable_Actions.clickOnElement(driver, "//span[text()='Continue']", logger,"Continue Button");
            Thread.sleep(4000);

            //Click on Continue again
            Reusable_Actions.clickOnElement(driver, "//span[text()='Continue']", logger,"Continue Button");
            Thread.sleep(1500);

            //Step 22-25. Enter CC number, expiration month and year, CVV
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='creditCardNumber']", ccNumber, logger,"CC Number");
            Reusable_Actions.dropdownByText(driver, "//select[@name='expMonth']", expMonth, logger,"Exp Month");
            Reusable_Actions.dropdownByText(driver, "//select[@name='expYear']", expYear, logger,"Exp Year");
            Reusable_Actions.sendKeysMethod(driver, "//input[@name='cvv']", cvvCode, logger, "CVV");
            Thread.sleep(1500);

            //Step 26. Click on Place Order
            Reusable_Actions.clickOnElement(driver, "//span[text()='Place Order']", logger,"Continue Button");
            Thread.sleep(1000);

            //Step 27. Capture error message and write it back to Excel
            String errorMessage = Reusable_Actions.captureText(driver,"//div[@class='dOxMH labelError']",0, logger,"Error Message");
            Label error = new Label(14,i, errorMessage);
            writableSheet.addCell(error);
            logger.log(LogStatus.INFO,"The error message is: " + errorMessage);

        } //end of loop

        //Write back to WorkBook and close it
        writableWorkbook.write();
        writableWorkbook.close();


    } //end of main

} //end of class
