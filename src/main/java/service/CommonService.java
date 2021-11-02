package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import setup.BaseTest;

public class CommonService extends BaseTest {

    private RequestSpecification requestSpecification;

   /* public CommonService() {
        //PropertyReader property = new PropertyReader();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(property.getProperty("domain"))
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build()
            .header("Authorization", property.getProperty("token"))
            .queryParam("key", property.getKey())
            .queryParam("token", property.getToken());
    }*/

}
