package api;

import org.junit.Test;
import pogo.AuthorisationResponse;
import pogo.OwnerPasswordCredentialsGrantRequest;

import static io.restassured.RestAssured.given;


public class ResourceOwnerPasswordCredentialsGrantRequestTest3 {
    @Test
    public void token() {

        OwnerPasswordCredentialsGrantRequest request =
                OwnerPasswordCredentialsGrantRequest.builder()
                        .grantType("password")
                        .username("johndoe")
                        .password("am9obmRvZTEyMw==")
                        .build();

        given()
                .spec(MyRequestSpecification.create())
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
