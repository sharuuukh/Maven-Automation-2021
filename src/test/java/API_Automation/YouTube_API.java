package API_Automation;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class YouTube_API extends Abstract_Class {

    String apiKey = "AIzaSyB_XsvUMzsOiH1y63C-v2k4ShhpX1SIt5s";
    @Test(priority = 1)
    public void YouTubeAPITest() throws InterruptedException {
        RestAssured.baseURI = "https://www.googleapis.com/customsearch";
        RestAssured.basePath = "/v1";
        Response Resp=
                given().
                        queryParam("key", apiKey)
                        .queryParam("cx", "bd919b631be1cce39")
                        .queryParam("q", "air coolers")
                        .when()
                        .get()
                        .then()
                        .extract()
                        .response(); //similar to getText for json

        //verify if status code is 200
        if (Resp.statusCode() == 200){
            System.out.println("Status code is 200 and successful.");
        } else {
            System.out.println("Status code is not successful: " + Resp.statusCode());
        }

        //verify link count on "items" is at least 1 or more
        ArrayList linkCount = Resp.path("items.link");
        if (linkCount.size() >= 1){
            System.out.println("Link count is greater than 1. Link count is " + linkCount.size() + ".");
        } else {
            System.out.println("Link count is not valid: " + linkCount.size() + ".");
        }

        //run a loop and navigate to the first 5 links and verify if titles match
        for (int i = 0; i < 5; i++){
            String linkURL = Resp.path("items.link["+i+"]");
            driver.navigate().to(linkURL);
            Thread.sleep(2000);
            //Actual Title
            String ActualTitle = Resp.path("items.title["+i+"]");
            String[]ActualTitle2 = ActualTitle.split(" - YouTube");
            String ActualTitle3 = ActualTitle2[0];
            //Expected Title
            String ExpectedTitle = Reusable_Actions.captureText(driver, "(//h1[contains(@class, 'title')])[1]", 0, logger, "Expected Title");
            //Set titles equal to each other
            if (ExpectedTitle.equals(ActualTitle3)) {
                logger.log(LogStatus.PASS, "Title matches!");
                System.out.println("Title matches!");
            } else {
                logger.log(LogStatus.FAIL, "Title does not match. Actual title is: " + ActualTitle3);
                System.out.println("Title does not match. Actual title is: " + ActualTitle3);
            }
        } //end of loop

    }//end of method

} //end of class
