package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public final class MyRequestSpecification {
    public static final String user = "front_2d6b0a8391742f5d789d7d915755e09e";
    public static RequestSpecification requestSpec;

    @Before
    public void initSpec() {

        Map<String, String> forHeaders = new HashMap<>();
        forHeaders.put("Authorization", ("Basic " + "front_2d6b0a8391742f5d789d7d915755e09e"));

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://test-api.d6.dev.devcaz.com/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addHeaders(forHeaders)
                .build();
    }
}
