package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Base;

public class WithBasicAuthGetTest extends Base {

    RequestSpecification httpRequest = Base.setUp();
    @Test
    public void getDetails()
    {
        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification httpRequest = RestAssured.given().auth().basic(Base.getUserName(),Base.getPassword());
        Response response = httpRequest.request(Method.GET);

        //Get response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body =>  \n" + responseBody);
        int responseCode = response.getStatusCode();
        System.out.println("\nResponse code =>  \n" + responseCode);
        Assert.assertEquals(responseCode, 200);
    }
}