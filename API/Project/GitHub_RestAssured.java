package project;

import au.com.dius.pact.core.model.PathToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHub_RestAssured {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    String SSH;
    int petID;

    @BeforeClass
    public void setUp() {
        //create req spec
        requestSpec = new RequestSpecBuilder()
                //  .setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization", "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")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .expectContentType("application/json")
                //    .expectBody("status", equalTo("alive"))
                .build();
    }

    @Test(priority = 1)
    public void postRequest(){
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("id",51234);
        reqBody.put("name","tiger");
        reqBody.put("status","alive");

        Response response = given()
                .spec(requestSpec)
                .body(reqBody)
                .when()
                .post();

        //Extract Id
        petID = response
                .then()
                .extract()
                .path("id");

        response
                .then()
                .spec(responseSpec)
                .body("name", equalTo("tiger"));

    }

    @Test(priority = 2)
    public void getRequest(){
        Response response = given()
                .spec(requestSpec)
                .pathParams("petID",petID)
                .get("/{petID}");

        String body = response.getBody().asPrettyString();

        System.out.println("Response body : " + body);

        response.then().spec(responseSpec);

    }

    @Test(priority = 3)
    public void deleteRequest(){
        Response response =  given(requestSpec)
                .pathParam("petID",petID)
                .when()
                .delete("/{petID}");

        String body = response.getBody().asPrettyString();

        System.out.println("Response body : " + body);

        response.then().spec(responseSpec).body("message", equalTo("" + petID));
    }

}

