package Day14_041821;

import Google_PageObjects.Base_Class;
import ReusableLibrary.Abstract_Class;
import org.testng.annotations.Test;

public class Google_Search_PageObject extends Abstract_Class {

    @Test
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Base_Class.googleHomePage().EnterKeywordOnGoogleSearch("cars");
        Base_Class.googleHomePage().SubmitGoogleSearchButton();
        Thread.sleep(1500);
    }

    @Test(dependsOnMethods = "googleSearch")
    public void searchResults(){
        Base_Class.searchResultsPage().getSearchNumber();
    }
}
