package activities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    String BaseUri = "https://petstore.swagger.io/v2/pet";
    int petId;
    @Test(priority = 1)
    public void postReq(){
        Map reqBody = new HashMap<String, Object>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(BaseUri);

        petId = response.then().extract().path("id");
        //ASSERTIONS
        response.then().body("name",equalTo("Riley"));
        response.then().body("id",equalTo(77232));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 2)
    public void getReq(){
        Response response = given().contentType(ContentType.JSON)
                .pathParams("petId",petId)
                .when()
                .get(BaseUri+ "/{petId}");

        String body = response.asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().body("name",equalTo("Riley"));
        response.then().body("id",equalTo(77232));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 3)
    public void delReq(){
        Response response = given().contentType(ContentType.JSON)
                .pathParams("petId",petId)
                .when()
                .delete(BaseUri+ "/{petId");
        String body = response.asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message",equalTo(petId));
    }
}
