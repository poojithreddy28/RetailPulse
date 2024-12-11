package com.poojith.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import static org.hamcrest.Matchers.notNullValue;

@Import(com.poojith.microservices.product.TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	static MongoDBContainer mongoDbContainer;

	@LocalServerPort
	private int port;

	@BeforeAll
	static void startContainer() {
		mongoDbContainer = new MongoDBContainer("mongo:7.0.5");
		mongoDbContainer.start();
	}

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
    {
     "name": "iphone 16 Pro Max",
     "description": "Latest iphone test",
     "price": 100
    }
    """;
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("Id", notNullValue())
				.body("name", Matchers.equalTo("iphone 16 Pro Max"))
				.body("description", Matchers.equalTo("Latest iphone test"))
				.body("price", Matchers.equalTo(100));
	}
}