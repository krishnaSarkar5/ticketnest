package com.ticketnest.location_service.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import com.ticketnest.location_service.AbstractIntegrationTesting;
import com.ticketnest.location_service.core.ResponseStatus;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

@Sql("/test-data.sql")
class LocationControllerTest extends AbstractIntegrationTesting {

    @Test
    void shouldReturnProducts() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/v1/location/get-all-countries")
                .then()
                .statusCode(200)
                .body("data", hasSize(7))
                .body("status", is(ResponseStatus.SUCCESS.getStatus()))
                .body("statusCode", is(200));
    }
}
