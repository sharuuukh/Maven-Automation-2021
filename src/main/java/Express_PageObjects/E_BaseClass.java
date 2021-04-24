package Express_PageObjects;

import ReusableLibrary.Abstract_Class;

public class E_BaseClass extends Abstract_Class {

    public static E_HomePage ExpressHomePage(){
        E_HomePage ExpressHomePage = new E_HomePage(driver);
        return ExpressHomePage;
    }

    public static E_SweatersPage ExpressSweaterPage(){
        E_SweatersPage ExpressSweaterPage = new E_SweatersPage(driver);
        return ExpressSweaterPage;
    }

    public static E_SizeSelectionPage ExpressSizePage(){
        E_SizeSelectionPage ExpressSizePage = new E_SizeSelectionPage(driver);
        return ExpressSizePage;
    }

    public static E_CartPage ExpressCartPage(){
        E_CartPage ExpressCartPage = new E_CartPage(driver);
        return ExpressCartPage;
    }

    public static E_CheckoutPage ExpressCheckoutPage(){
        E_CheckoutPage ExpressCheckoutPage = new E_CheckoutPage(driver);
        return ExpressCheckoutPage;
    }
}
