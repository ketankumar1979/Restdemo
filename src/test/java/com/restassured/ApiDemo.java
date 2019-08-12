package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiDemo {
    public static void main (String[]args){
        //RestAssured.baseURI="https://maps.googleapis.com";
        String location = "-33.8670522,151.1957362";
        String radius = "1500";
        String key = "AIzaSyCkIgOSCDSfQFAdsvTE0M1zwn9vPL7704E";

      Response response =  given().param(location,radius,key).
                 // param("location","33.8670522,151.1957362").
                 // param("radius","1500").
                  //param("key","AIzaSyC0FDOTSldOUIgRf_I2AitMpK7akgz9vQc").

                  when().get("https://maps.googleapis.com/maps/api/place/nearbysearch/json");
      response.prettyPrint();
                  //get("/maps/api/place/nearbysearch/json").
                response.then().assertThat().and().statusCode(200).and().contentType("application/json; charset=UTF-8");
    }
}
