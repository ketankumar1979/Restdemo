package com.restassured;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class OauthApi{


    @Test
    public void getCourseDetails(){

       given().queryParam("access_token" , "ya29.a0AfH6SMAiISBU8RVP-8HzS3jcRHytyUNluxsqh8qh4yez5gvHVya2344vh2LQxX1o65HGOf_Xo6ydI9hzvy2OPXfrGg-945xQEV3-D2l-ttDOrFaYBddB-c48F7m60kzrSK-ibeBTDKvhYdCLxRTjsEXG5HxWUdCoHUTi")
                .when().post("https://rahulshettyacademy.com/getCourse.php")
                .then().log().all();

    }

 }