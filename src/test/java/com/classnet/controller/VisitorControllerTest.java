package com.classnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.with;
import java.util.Random;
import static org.hamcrest.Matchers.*;



public class VisitorControllerTest {
    public final static String ROOT_URL = "http://localhost/";
    private static final short PORT = 8080;
    
    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new HomeController());
    }

    @Test
    public void testRegistrationSuccessCode() {
        given()
            .when()
                .baseUri(ROOT_URL)
                .port(PORT)
                .basePath("/classnet/registration")
                .get()
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(anything()));
    }
    
    @Test
    public void testRegistration() {
        given()
            .when()
                .baseUri(ROOT_URL)
                .port(PORT)
                .basePath("/classnet/registration")
                .get()
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(anything("Register")));
    }
    
    @Test
    public void testLoginPageRender() {
        given()
            .when()
                .baseUri(ROOT_URL)
                .port(PORT)
                .basePath("/classnet/login")
                .get()
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(anything()));
    }
    
    @Test
    public void testLoginPage() {
        given()
            .when()
                .baseUri(ROOT_URL)
                .port(PORT)
                .basePath("/classnet/login")
                .get()
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(anything("Login")));
    }
    
    @Test
    public void testLogin() {
       given().urlEncodingEnabled(true)
            .contentType(ContentType.URLENC)
            .accept(ContentType.HTML)
                .param("email", "201912106@daiict.ac.in")
                .param("pass", "123456")
            .when()
                .request("POST", "/classnet/login")
            .then()
                .log().ifValidationFails()
                .statusCode(302);
    }
}