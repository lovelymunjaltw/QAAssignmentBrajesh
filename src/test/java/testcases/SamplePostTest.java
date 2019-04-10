package testcases;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utility.Base;
import utility.Employee;

public class SamplePostTest extends Base {

    RequestSpecification httpRequest = Base.setUp();

    @Test
    public void createNewRecord() {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body("[{\"userName\":\"Test12\",\"employer\":\"Google\",\"location\":{\"state\":\"California\",\"city\":\"Mountain View\"}}]");
        Response response = httpRequest.request(Method.POST, "/users");
        System.out.println("Post Response Body =>  \n" + response.getBody().asString());
        System.out.println("\nResponse code =>  \n" + response.getStatusCode());
        //put any sssertion here
    }
}