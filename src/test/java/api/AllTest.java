package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import pogo.*;

import java.util.HashMap;
import java.util.Map;

import static api.MyRequestSpecification.requestSpec;
import static io.restassured.RestAssured.given;

public class AllTest {
    public static RequestSpecification requestSpec;
    public static String token;

    @Before
    public void initSpec() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://test-api.d6.dev.devcaz.com/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void authorization() {

        AuthorisationRequest request =
                AuthorisationRequest.builder()
                        .grant_type("client_credentials")
                        .scope("guest:default") //scope1:read scope1:write scope2:read
                        .build();

        token = given()
//                .header("Authorisation", "Basic front_2d6b0a8391742f5d789d7d915755e09e")
//                .header("Authorisation", "Basic c29tZWNsaWVudDphbmRpdHNzZWNyZXQ=")
//                .auth().oauth2("front_2d6b0a8391742f5d789d7d915755e09e")
//                .auth().oauth2("c29tZWNsaWVudDphbmRpdHNzZWNyZXQ=")
//                .auth().basic("user","front_2d6b0a8391742f5d789d7d915755e09e")
//                .auth().basic("Basic","c29tZWNsaWVudDphbmRpdHNzZWNyZXQ=")
                .spec(requestSpec)
                .basePath("v2/oauth2/token")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200).assertThat()
                .extract().as(AuthorisationResponse.class).getAccess_token();
    }

    @Test
    public void newPlayer() {

        NewPlayerRequest request =
                NewPlayerRequest.builder()
                        .username("janedoe")
                        .password_change("am9obmRvZTEyMw==")
                        .password_repeat("am9obmRvZTEyMw==")
                        .email("janedoe@example.com")
                        .name("Jane")
                        .surname("Doe")
                        .currency_code("EUR")
                        .build();

        NewPlayerResponse response = given()
                .spec(requestSpec)
                .auth().oauth2(token)
                .basePath("/v2/players")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(201)
                .assertThat()
                .extract().as(NewPlayerResponse.class);
    }

    @Test
    public void resourceOwnerPasswordCredentialsGrant() {

        OwnerPasswordCredentialsGrantRequest request =
                OwnerPasswordCredentialsGrantRequest.builder()
                        .grantType("password")
                        .username("johndoe")
                        .password("am9obmRvZTEyMw==")
                        .build();

        given()
                .spec(requestSpec)
                .auth().oauth2(token)
                .basePath("/v2/oauth/token")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200)
                .assertThat().extract().as(AuthorisationResponse.class);

    }

    @Test
    public void singlePlayerProfile() {

        given()
                .spec(requestSpec)
                .auth().oauth2(token)
                .basePath("v2/players/1")
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .extract().as(NewPlayerResponse.class);
    }

}
