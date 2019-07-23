package com.restassured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ApiDemo {
    public static void main (String[]args){
        RestAssured.baseURI="https://maps.googleapis.com";

          given().
                  param("location","33.8670522,151.1957362").
                  param("radius","1500").
                  param("key","AIzaSyC0FDOTSldOUIgRf_I2AitMpK7akgz9vQc").

                  when().
                  get("/maps/api/place/nearbysearch/json").
                  then().assertThat().and().statusCode(200).and().contentType("application/json; charset=UTF-8").and().
    }
}
