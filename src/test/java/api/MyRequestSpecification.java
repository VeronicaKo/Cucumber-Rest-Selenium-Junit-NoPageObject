package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyRequestSpecification {
    public  RequestSpecification requestSpec;

    public static RequestSpecification create() {
//        String authBasic =
//                Base64.getEncoder()
//                        .encodeToString(
//                                String.format("%s:%s", "johndoe", "am9obmRvZTEyMw==").getBytes());
//        Map<String, String> forHeaders = new HashMap<>();
//
//        forHeaders.put("Authorization", ("Basic " + authBasic));

        Map<String, String> forHeaders = new HashMap<>();
//        forHeaders.put("Authorization", ("Basic " + "front_2d6b0a8391742f5d789d7d915755e09e"));


        RequestSpecification requestSpec =
                new RequestSpecBuilder()
                        .setBaseUri("http://test-api.d6.dev.devcaz.com/")
                        .setAccept(ContentType.JSON)
                        .setContentType(ContentType.JSON)
//                        .addHeaders(forHeaders)
                        .build();
        return requestSpec;
    }

}
