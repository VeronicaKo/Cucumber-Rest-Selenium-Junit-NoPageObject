package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import pogo.*;

import static io.restassured.RestAssured.given;

public class AllTest {
    public static RequestSpecification requestSpec;
    public static String token;
    public static int playerID;
    public static String playerToken;

    @Before
    public void initSpec() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://test-api.d6.dev.devcaz.com/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public String OurAuthorization(String autorisation) {

        AuthorisationRequest requestAuthorisation =
                AuthorisationRequest.builder()
                        .grant_type("client_credentials")
                        .scope("guest:default") //scope1:read scope1:write scope2:read
                        .build();

        token = given()
                .header("Authorisation", "Basic front_2d6b0a8391742f5d789d7d915755e09e")
                .spec(requestSpec)
                .basePath("v2/oauth2/token")
                .body(requestAuthorisation)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200).assertThat()
                .extract().as(AuthorisationResponse.class).getAccess_token();

        return token;
    }

    @Test
    public void player() {

        //authorisation as admin
        token = OurAuthorization("Basic front_2d6b0a8391742f5d789d7d915755e09e");

        //NewPlayer
        NewPlayerRequest requestPlayer =
                NewPlayerRequest.builder()
                        .username("janedoe")
                        .password_change("am9obmRvZTEyMw==")
                        .password_repeat("am9obmRvZTEyMw==")
                        .email("janedoe@example.com")
                        .name("Jane")
                        .surname("Doe")
                        .currency_code("EUR")
                        .build();

        playerID = given()
                .spec(requestSpec)
                .header("Authorisation", "Basic " + token)
                .basePath("/v2/players")
                .body(requestPlayer)
                .when()
                .post()
                .then()
                .statusCode(201)
                .assertThat()
                .extract().as(NewPlayerResponse.class).getId();


        //authorisation as player
        OwnerPasswordCredentialsGrantRequest request =
                OwnerPasswordCredentialsGrantRequest.builder()
                        .grant_type("password")
                        .username("janedoe")
                        .password("am9obmRvZTEyMw==")
                        .build();

        playerToken = given()
                .spec(requestSpec)
                .basePath("/v2/oauth/token")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200)
                .assertThat().extract().as(AuthorisationResponse.class).getAccess_token();


        //get data of  authorised player
        given()
                .spec(requestSpec)
                .header("Authorisation", "Basic " + playerToken)
                .basePath("v2/players/" + playerID)
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .extract().as(NewPlayerResponse.class);


        //get data other player
        given()
                .spec(requestSpec)
                .header("Authorisation", "Basic " + playerToken)
                .basePath("v2/players/" + "123")
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(404)
                .assertThat()
                .extract().as(NewPlayerResponse.class);

    }

}
