package FedEx_PageObjects;

import ReusableLibrary.Abstract_Class;

public class F_BaseClass extends Abstract_Class {

    public static F_HomePage FedExHomePage(){
        F_HomePage FedExHomePage = new F_HomePage(driver);
        return FedExHomePage;
    }

    public static F_PrintOnlinePage FedExPrintOnlinePage(){
        F_PrintOnlinePage FedExPrintOnlinePage = new F_PrintOnlinePage(driver);
        return FedExPrintOnlinePage;
    }

    public static F_DocumentPrintingPage FedExDocumentPrintingPage(){
        F_DocumentPrintingPage FedExDocumentPrintingPage = new F_DocumentPrintingPage(driver);
        return FedExDocumentPrintingPage;
    }

    public static F_UploadPage FedExUploadPage(){
        F_UploadPage FedExUploadPage = new F_UploadPage(driver);
        return FedExUploadPage;
    }

    public static F_CartPage FedExCartPage(){
        F_CartPage FedExCartPage = new F_CartPage(driver);
        return FedExCartPage;
    }

    public static F_DeliveryPage FedExDeliveryPage(){
        F_DeliveryPage FedExDeliveryPage = new F_DeliveryPage(driver);
        return FedExDeliveryPage;
    }
}
