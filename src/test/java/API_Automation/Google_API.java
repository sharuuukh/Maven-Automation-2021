package API_Automation;

import ReusableLibrary.Abstract_Class;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Google_API extends Abstract_Class {

    String apiKey = "AIzaSyB_XsvUMzsOiH1y63C-v2k4ShhpX1SIt5s";
    @Test(priority = 1)
    public void googleSearchAPITest() throws InterruptedException {
        RestAssured.baseURI = "https://www.googleapis.com/customsearch";
        RestAssured.basePath = "/v1";
        Response Resp=
                given().
                        queryParam("key", apiKey)
                        .queryParam("cx", "04563202f3f211f44")
                        .queryParam("q", "BMW")
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
            String linkTitle = Resp.path("items.title["+i+"]");


        }




    }

}
