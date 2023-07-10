package Activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void postRequest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77321);
        reqBody.put("name", "Mikey");
        reqBody.put("status", "alive");

        Response response = given().header("Content-Type", "application/json").body(reqBody).when().post(baseURI);
        response.then().statusCode(200).body("status", equalTo("alive")).body("id", equalTo(77321))
                .body("name", equalTo("Mikey"));
    }

    @Test(priority = 2)
    public void getRequest() {
        given().headers("Content-Type", "application/json").pathParam("petId", 77321).
                when().get(baseURI + "/{petId}").then().statusCode(200).body("status", equalTo("alive")).
                body("name", equalTo("Mikey")).body("id", equalTo(77321));
    }

    @Test(priority = 3)
    public void deleteRequest() {
        given().headers("Content-Type", "application/json").pathParam("petId", 77321).
                when().delete(baseURI + "/{petId}").then().statusCode(200).body("message", equalTo("77321"));
    }
}
