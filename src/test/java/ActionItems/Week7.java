package ActionItems;

import Express_PageObjects.E_BaseClass;
import ReusableLibrary.Abstract_Class;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Week7 extends Abstract_Class {

    @Test
    public void ExpressE2ECheckout() throws InterruptedException, BiffException, IOException, WriteException {

        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ExpressCheckout.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ExpressResults.xls"), readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        int rowCount = writableSheet.getRows();

        for (int i = 1; i < rowCount; i++) {

            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String eMail = writableSheet.getCell(4, i).getContents();
            String Phone = writableSheet.getCell(5, i).getContents();
            String Address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String ccNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();

            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(1500);
            E_BaseClass.ExpressHomePage().setPopUpClose();
            E_BaseClass.ExpressHomePage().setMenTab();
            E_BaseClass.ExpressHomePage().setSweatersTab();
            Thread.sleep(1500);
            E_BaseClass.ExpressSweaterPage().setFirstItemSelection();
            Thread.sleep(1500);
            E_BaseClass.ExpressSizePage().setSizeSelection(Size);
            E_BaseClass.ExpressSizePage().setAddToBag();
            E_BaseClass.ExpressSizePage().setViewBag();
            Thread.sleep(1500);
            E_BaseClass.ExpressCartPage().setChangeQuantity(Quantity);
            E_BaseClass.ExpressCartPage().setCheckoutButton();
            E_BaseClass.ExpressCartPage().setGuestCheckoutButton();
            Thread.sleep(1500);
            E_BaseClass.ExpressCheckoutPage().setFirstName(firstName);
            E_BaseClass.ExpressCheckoutPage().setLastName(lastName);
            E_BaseClass.ExpressCheckoutPage().setEmail(eMail);
            E_BaseClass.ExpressCheckoutPage().setConfirmEmail(eMail);
            E_BaseClass.ExpressCheckoutPage().setPhoneNumber(Phone);
            Thread.sleep(1500);
            E_BaseClass.ExpressCheckoutPage().setContinueButton();
            Thread.sleep(1500);
            E_BaseClass.ExpressCheckoutPage().setStreetAddress(Address);
            E_BaseClass.ExpressCheckoutPage().setZipCode(zipCode);
            E_BaseClass.ExpressCheckoutPage().setCity(City);
            E_BaseClass.ExpressCheckoutPage().setState(State);
            E_BaseClass.ExpressCheckoutPage().setContinueButton();
            Thread.sleep(4000);
            E_BaseClass.ExpressCheckoutPage().setContinueButton();
            Thread.sleep(3000);
            E_BaseClass.ExpressCheckoutPage().setCheckoutPopup();
            E_BaseClass.ExpressCheckoutPage().setCreditCardNumber(ccNumber);
            E_BaseClass.ExpressCheckoutPage().setExpiryMonth(expMonth);
            E_BaseClass.ExpressCheckoutPage().setExpiryYear(expYear);
            E_BaseClass.ExpressCheckoutPage().setCvvNumber(cvvCode);
            Thread.sleep(1500);
            E_BaseClass.ExpressCheckoutPage().setPlaceOrder();
            Thread.sleep(1000);
            String errorMessage = E_BaseClass.ExpressCheckoutPage().setErrorMessage();
            Label error = new Label(14,i, errorMessage);
            writableSheet.addCell(error);
        } //end of loop
        writableWorkbook.write();
        writableWorkbook.close();
    } //end of test
} //end of class