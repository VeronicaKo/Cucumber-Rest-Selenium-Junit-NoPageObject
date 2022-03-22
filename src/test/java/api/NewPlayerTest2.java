package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.Test;
import pogo.NewPlayerRequest;
import pogo.NewPlayerResponse;

import static api.MyRequestSpecification.requestSpec;
import static io.restassured.RestAssured.given;

public class NewPlayerTest2 {
    @Test
    public void newPlayer() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://test-api.d6.dev.devcaz.com/")
//                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
//                .addHeaders(forHeaders)
                .build();

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
//                .auth().oauth2("2d6b0a8391742f5d789d7d915755e09e")
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
}
