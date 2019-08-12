package com.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LibraryApi {

    @Test
    public void post1(){
        Response response = given().when().get("http://216.10.245.166/Library/GetBook.php?ID=3389");
        response.prettyPrint();
    }


}
