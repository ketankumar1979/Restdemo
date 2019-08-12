package com.restassured;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Twitter {
    String Consumerkey = "ov2fIGaHUxp2ZcwA1IPUUp6ow";
    String Consumersecret = "HbKiKAkbJBiDnKIbOfSZz6FUg42rmJhCmNIWdi3rxEwzerUHKt";
    String AccessToken = "1156290924751855616-4cO6U0FCNCq34lyBAt97Om28iLAMCF";
    String TokenSecret = "ID8AZF9DoeDBkWHfz2Nej8HILDfGZkbtVEStqxgjHMMmO";

    @Test
    public void getTweet(){
        Response response = given().auth().oauth(Consumerkey,Consumersecret,AccessToken,TokenSecret).
                when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
    }

}
