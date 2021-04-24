package Google_PageObjects;

import ReusableLibrary.Abstract_Class;

public class Base_Class extends Abstract_Class {

    //this page class is a static reference for the page object classes
    //so we can use it on our test class

    public static Home_Page googleHomePage(){
        Home_Page googleHomePage = new Home_Page(driver);
        return googleHomePage;
    }

    public static Search_Results_Page searchResultsPage(){
        Search_Results_Page searchResultsPage = new Search_Results_Page(driver);
        return searchResultsPage;
    }


}
