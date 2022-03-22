package api;

import org.junit.Test;
import pogo.NewPlayerResponse;

import java.util.HashMap;
import java.util.Map;

import static api.MyRequestSpecification.requestSpec;
import static io.restassured.RestAssured.given;

public class SinglePlayerProfileTest4_5 {
    @Test
    public void singlePlayerProfile() {
        Map<String, String> forHeaders = new HashMap<>();
        forHeaders.put("Authorization", ("Basic " + "front_2d6b0a8391742f5d789d7d915755e09e"));

        given()
                .spec(requestSpec)
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
