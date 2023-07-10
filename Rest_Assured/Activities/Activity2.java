package Activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    String baseURI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void postRequest() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/java/activities/activity2Input.json");
        String reqBody = new String(inputJSON.readAllBytes());

        Response response = given().header("Content-Type", "application/json").body(reqBody).when().post(baseURI);
        response.then().statusCode(200).body("message", equalTo("6767"));
        inputJSON.close();
    }

    @Test(priority = 2)
    public void getRequest() throws IOException {
        File outputJSON = new File("src/test/java/activities/activity2GetResponse.json");
        Response response = given().headers("Content-Type", "application/json").pathParam("username", "TomanFirst").
                when().get(baseURI + "/{username}");
        String responseBody = response.getBody().asPrettyString();
        outputJSON.createNewFile();
        FileWriter writer = new FileWriter(outputJSON.getPath());
        writer.write(responseBody);
        writer.close();
        response.then().body("id", equalTo(6767));
        response.then().body("username", equalTo("TomanFirst"));
        response.then().body("firstName", equalTo("Baji"));
        response.then().body("lastName", equalTo("Keisuke"));
        response.then().body("email", equalTo("baji.keisuke@gmail.com"));
        response.then().body("password", equalTo("Toman123"));
        response.then().body("phone", equalTo("9874456350"));

    }

    @Test(priority = 3)
    public void deleteRequest() {
        given().headers("Content-Type", "application/json").pathParam("username", "TomanFirst").
                when().delete(baseURI + "/{username}").then().statusCode(200).body("message", equalTo("TomanFirst"));
    }
}
