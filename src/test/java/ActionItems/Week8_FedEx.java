package ActionItems;

import ReusableLibrary.Abstract_Class;
import org.testng.annotations.Test;

import static FedEx_PageObjects.F_BaseClass.*;

public class Week8_FedEx extends Abstract_Class {

    @Test
    public void FedExE2ETest() throws InterruptedException {

        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(1500);
        FedExHomePage().setDesignPrintTab();
        FedExHomePage().setUploadFileTab();
        Thread.sleep(5000);
        FedExPrintOnlinePage().setVerifyTitle();
        FedExPrintOnlinePage().setDocumentPrinting();
        Thread.sleep(2000);
        FedExDocumentPrintingPage().setCopiesCustomProjects();
        Thread.sleep(1000);
        FedExUploadPage().setUploadFileButton();
        FedExUploadPage().setUploadImage();
        Thread.sleep(8000);
        FedExUploadPage().setLowResPopUp();
        FedExUploadPage().setItemQuantityField();
        Thread.sleep(1000);
        FedExUploadPage().setAddToCart();
        Thread.sleep(1500);
        FedExCartPage().setCheckoutButton();
        FedExCartPage().setContinueAsGuest();
        Thread.sleep(2500);
        FedExDeliveryPage().setRadiusSelect();
        FedExDeliveryPage().setZipCodeInput();
        FedExDeliveryPage().setContinueButton();
        Thread.sleep(3500);
        FedExDeliveryPage().setFirstResult();


    }
}
