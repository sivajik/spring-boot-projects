package com.sprms.order_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {
    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @LocalServerPort
    int port;

	static {
        mySQLContainer.start();
    }

    @BeforeEach
    void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldCreateOrder() {
        String requestBody = """
                {
                    "skuCode": "iphone_pro",
                    "price": 100,
                    "quantity": 2
                }
                """;
        String responseString = RestAssured.given().contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/order")
                .then()
                .statusCode(201)
				.extract()
				.asPrettyString();
		System.out.println(responseString);
    }

    @Test
    void shouldPullOrders() {
        RestAssured.given().contentType("application/json")
                .when()
                .get("/api/order")
                .then()
                .statusCode(200)
                .body("skuCode[0]", Matchers.equalTo("iphone_pro"))
                .body("price[0]", Matchers.equalTo(100.0F))
                .body("quantity[0]", Matchers.equalTo(2));
    }

}
