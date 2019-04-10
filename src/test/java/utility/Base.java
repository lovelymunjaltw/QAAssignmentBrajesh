package utility;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpRequest;
import org.testng.annotations.BeforeTest;
import io.restassured.response.Response;
import com.google.gson.Gson;


public class Base {

    private static String propertyFileName = "test1.properties";
    //private static String propertuFilePath = "src/test/resources/";
    //private static String propertyfile = propertuFilePath + propertuFileName;

    @BeforeTest
    public static RequestSpecification setUp(){
        RestAssured.baseURI = getBaseURL();
        return RestAssured.given();
    }

    public Base(){
        Helper.loadProperties(propertyFileName);
    }

    public static String getBaseURL(){
        return Helper.getPropertyValue("base-url");
    }

    public static String getContentType (Response response){
        return response.getHeader("Content-Type");
    }

    public static void setContentType (RequestSpecification httpRequest){
        httpRequest.header("Content-Type", "application/json");
    }

    public static String getJson (Object emp){
        Gson gson= new Gson();
        String json = gson.toJson(emp);
        return json;
    }
}
