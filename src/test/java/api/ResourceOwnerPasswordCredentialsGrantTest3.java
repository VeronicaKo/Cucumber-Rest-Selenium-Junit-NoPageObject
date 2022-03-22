package api;

import org.junit.Test;
import pogo.AuthorisationResponse;
import pogo.OwnerPasswordCredentialsGrantRequest;

import static api.MyRequestSpecification.requestSpec;
import static io.restassured.RestAssured.given;


public class ResourceOwnerPasswordCredentialsGrantTest3 {
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
                .basePath("/v2/oauth/token")
                .body(request)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200)
                .assertThat().extract().as(AuthorisationResponse.class);

    }
}
