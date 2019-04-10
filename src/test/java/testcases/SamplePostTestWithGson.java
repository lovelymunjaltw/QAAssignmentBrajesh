package testcases;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utility.Base;
import utility.Employee;

import java.util.Arrays;

public class SamplePostTestWithGson extends Base {

    RequestSpecification httpRequest = Base.setUp();
    Employee emp = new Employee("testGsonPut2", "ThoughtWorks", "Haryana","CityABC");

    @Test
    public void createNewRecord() {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(Base.getJson(Arrays.asList(emp)));  //Post accept only json array as per our service
        Response response = httpRequest.request(Method.POST, "/users");
        System.out.println("Post Response Body =>  \n" + response.getBody().asString());
        System.out.println("\nResponse code =>  \n" + response.getStatusCode());
        //put any asssertion here
    }
}