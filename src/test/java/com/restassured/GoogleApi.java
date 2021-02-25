package com.restassured;

import extraResource.Payload;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GoogleApi {


    @Test
    public void postDemo() {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                /*.body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")*/
                . body(Payload.googleApipost())
                .when().post("/maps/api/place/add/json?key =qaclick123")
                .then().log().all()
               .assertThat().statusCode(200).and().body("scope", is("APP")).and().contentType(ContentType.JSON);
    }

    @Test
    public void deleteDemo() {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON).
                body("{\n" +
                        "    \"place_id\":\"61580fb7e8ceb1da29d19ecdd53e605b\"\n" +
                        "}")
                .when().delete("/maps/api/place/delete/json?key =qaclick123")
                .then().log().all();
        //assertThat().body("status", is("OK"));
    }

    @Test
    public void putDemo() {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON).
                body("{\n" +
                        "\"place_id\":\"17e06621f7719fd5305acdf1053e0320\",\n" +
                        "\"address\":\"70 Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json?key =qaclick123")
                .then().log().all();
        //assertThat().body("status", is("OK"));
    }

    @Test
    public void getDemo() {
        //RestAssured.baseURI = "https://reqres.in/";

        given().baseUri("https://rahulshettyacademy.com")
                .when().get("/maps/api/place/get/json?key =qaclick123&place_id=17e06621f7719fd5305acdf1053e0320")
                .then().log().all();
    }
}