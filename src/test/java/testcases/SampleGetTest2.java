package testcases;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Base;
import java.util.List;
import java.util.Map;

public class SampleGetTest2 extends Base {

    RequestSpecification httpRequest = Base.setUp();

    //create separate test methods for different assertions
    @Test (priority = 0)
    public void verifyContentType()
    {
        Response resp = httpRequest.request(Method.GET, "/users/1");
        System.out.println("\nresponseBody :" + resp.getBody().asString());
        String contentType = Base.getContentType(resp);
        System.out.println("\nContent Type :" + contentType);
        Assert.assertEquals(contentType,"application/json");
    }

    @Test (priority = 1)
    public void verifyUserName()
    {
        Response response = httpRequest.request(Method.GET, "/users/1");
        String userName = response.jsonPath().get("userName");
        System.out.println("\nUser Name :" + userName);
        Assert.assertEquals(userName,"Robert");
    }

    @Test (priority = 2)
    public void verifyNoOfRecords()
    {
        Response response = httpRequest.request(Method.GET, "/users");
        System.out.println("\nresponseBody :" + response.getBody().asString());
        List<Map<String, String>> userId = response.jsonPath().getList("userId");
        System.out.println("\nNo. of records :" + userId.size());
        Assert.assertEquals(7,userId.size());
    }

    @Test (priority = 3)
    public void verifyNamePresent()
    {
        Response response = httpRequest.request(Method.GET, "/users");
        //Get list of names inside list of Map
        List<Map<String, String>> names = response.jsonPath().getList("userName");
        System.out.println("\n'first Name' in first record :" + names.get(0)); //Get any name from List of names
        boolean b =  names.contains("Dan"); // will return true if List contain value "Dan"
        Assert.assertEquals(b,true);// verify whether list contain name: "Dan"
    }

    @Test (priority = 3)
    public void verifyState()
    {
        Response response = httpRequest.request(Method.GET, "/users");
        //Get location json object of any record in Map
        Map<String, String> locations = response.jsonPath().getMap("location[0]");
        String state = locations.get("state");
        System.out.println("\nState of 1st locations: " + state);
        Assert.assertEquals(state,"California");
    }
}