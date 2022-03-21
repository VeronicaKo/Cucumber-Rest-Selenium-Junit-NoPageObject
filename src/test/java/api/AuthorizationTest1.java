package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import pogo.AuthorisationRequest;
import pogo.AuthorisationResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

public class AuthorizationTest1 {
    @Test
    public void authorization() {

        AuthorisationRequest request =
                AuthorisationRequest.builder()
                        .grantType("client_credentials")
                        .scope("guest:default") //scope1:read scope1:write scope2:read
                        .build();

        AuthorisationResponse response = given()
                .spec(MyRequestSpecification.create())
//                .auth()
//                .basic("Bearer","2YotnFZFEjr1zCsicMWpAA")
//                .oauth2("front_2d6b0a8391742f5d789d7d915755e09e")
                .basePath("v2/oauth2/token")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200).assertThat()
                .extract().as(AuthorisationResponse.class);



    }
}
