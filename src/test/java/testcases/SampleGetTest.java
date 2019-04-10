package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleGetTest {

    public void getDetails()
    {
        //Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:9000/users";

        //Get the RequestSpecification of the request that you want to sent to the server
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        //Get response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body =>  \n" + responseBody);
        int responseCode = response.getStatusCode();
        System.out.println("\nResponse code =>  \n" + responseCode);

        // Get headers
        System.out.println("\nAll Headers =>  \n" + response.getHeaders());
    }
}