package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Reqres_in_1 {

    @Test
    public void getDemo(){
        //RestAssured.baseURI = "https://reqres.in/";

        given().baseUri("https://reqres.in/")
                .when().get("/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200).and().body("data.id",hasItems(7,8,9,10,11)).
                and().contentType(ContentType.JSON);

    }

    @Test
    public void postDemo1() {
        //RestAssured.baseURI = "https://reqres.in/";

        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when().post("/api/users")
                .then().log().all()
                .assertThat().statusCode(201).and().
                body("name",equalTo("morpheus"));
        //body("name", is("morpheus"));
    }

      @Test
       public void putDemo(){
       given().baseUri("https://reqres.in/").contentType(ContentType.JSON).body("{\n" +
               "    \"name\": \"morpheus\",\n" +
               "    \"job\": \"tester\"\n" +
               "}")
               .when().put("/api/users/2")
               .then().log().all();
               //assertThat().statusCode(200).and().body("job" , is("tester"));
    }



    }

