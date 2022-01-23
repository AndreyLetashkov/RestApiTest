package adapters;

import io.restassured.RestAssured;
import utils.ScenarioContext;

public class ApiUtils {
    public String post(String headerKey, String headerValue, String body, String url) {
        ScenarioContext.getInstance().put(
                "statusCode",
                RestAssured.given().header(headerKey, headerValue).
                body(body).
                when().
                post(url).
                then().
                log().all().
                extract().statusCode()
        );

        return RestAssured.given().header(headerKey, headerValue).
                body(body).
                when().
                post(url).
                then().
                log().all().
                extract().body().asString();
    }

    public String get(String url) {
        ScenarioContext.getInstance().put(
                "statusCode",
                RestAssured.when().
                get(url).
                then().extract().statusCode()
        );

        return RestAssured.when().
                get(url).
                then().
                log().all().
                extract().body().asString();
    }
}