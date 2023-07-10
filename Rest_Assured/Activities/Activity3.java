package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Activity3 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp() {

        //Request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json").build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][]{
                {4456, "Mikey", "alive"},
                {4457, "Draken", "alive"}
        };
        return testData;
    }


    @Test(priority = 1)
    public void postRequestTest() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 4456);
        reqBody.put("name", "Mikey");
        reqBody.put("status", "alive");

        //Send POST Request
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        response.then().spec(responseSpec);

        reqBody.put("id", 4457);
        reqBody.put("name", "Draken");
        reqBody.put("status", "alive");
        response = given().spec(requestSpec).body(reqBody).log().all().when().post();

        response.then().spec(responseSpec);

    }

    @Test(dataProvider = "petInfoProvider", priority = 2)
    public void getRequestTest(int id, String name, String status) {
        given().spec(requestSpec).pathParam("petId", id).
                when().get("/{petId}").
                then().spec(responseSpec).body("name", equalTo(name)).body("id", equalTo(id)).body("status", equalTo(status));
    }

    @Test(dataProvider = "petInfoProvider", priority = 3)
    public void deleteRequestTest(int id, String name, String status) {
        given().spec(requestSpec).pathParam("petId", id).
                when().delete("/{petId}").
                then().statusCode(200);
    }
}
