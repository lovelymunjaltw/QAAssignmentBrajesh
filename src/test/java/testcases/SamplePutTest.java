package testcases;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utility.Base;
import utility.Employee;


public class SamplePutTest extends Base {

    RequestSpecification httpRequest = Base.setUp();
    Employee emp = new Employee("testGsonPut", "ThoughtWorks");

    @Test
    public void updateRecord() {
        Base.setContentType(httpRequest);
        httpRequest.body(Base.getJson(emp));
        Response response = httpRequest.request(Method.PUT, "/users/2");
        System.out.println("Post Response Body =>  \n" + response.getBody().asString());
        System.out.println("\nResponse code =>  \n" + response.getStatusCode());
        //put any sssertion here
    }
}