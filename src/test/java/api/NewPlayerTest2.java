package api;

import org.junit.Test;
import pogo.NewPlayerRequest;
import pogo.NewPlayerResponse;

import static io.restassured.RestAssured.given;

public class NewPlayerTest2 {
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
                .spec(MyRequestSpecification.create())
                .auth().oauth2("2d6b0a8391742f5d789d7d915755e09e")
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
