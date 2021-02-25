package com.restassured;

import extraResource.Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.oracle.jrockit.jfr.Transition.To;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class ReqresDemo {

    Properties prop = new Properties();
    //@BeforeTest
   // public void getData() throws IOException {

       // FileInputStream fis = new FileInputStream("C:\\Users\\ketan\\Restdemo\\src\\Resources\\env.properties");
       // prop.load(fis);
        //prop.get("HOST");
    //}

    @Test
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\ketan\\Restdemo\\src\\test\\Resources\\env.properties");
        prop.load(fis);
        //Response response = given().when().get("https://reqres.in/api/users?page=2");
        Response response = given().when().get(prop.getProperty("HOST"));
        response.prettyPrint();
        response.then().assertThat().body("data.id",hasItems(7,8));
        //response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).body("page",is(2),"data[0].id",is(4));
    }
    @Test
    public void post1(){
       // Response response = given().contentType(ContentType.JSON).when().body("{\n" +
               // "    \"name\": \"morpheus\",\n" +
               // "    \"job\": \"leader\"\n" +
               // "}").post("https://reqres.in/api/users");
        Response response = given().contentType(ContentType.JSON).when().body(Payload.getData()).post("https://reqres.in/api/users");
        response.prettyPrint();
        //response.then().assertThat().body("name",is("morpheus"));
    }
    @Test
    public void postRegister(){
        Response response = given().contentType(ContentType.JSON).when().body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}").post("https://reqres.in/api/register");
        response.prettyPrint();
        response.then().assertThat().body("token",is("QpwL5tke4Pnpja7X4"));
    }
    @Test
    public void get5() throws IOException {
        FileInputStream isr = new FileInputStream("C:\\Users\\ketan\\Restdemo\\src\\test\\Resources\\env.properties");
        prop.load(isr);
        Response response = given().when().get(prop.getProperty("HOST"));
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("data.id",hasItems(1,2,3)).
                and().
                body("page",is(1)).and().body("data.name",hasItem("aqua sky"));

    }
    @Test
    public void postdata() throws IOException {
        Response response = given().contentType(ContentType.JSON).when().body(Payload.postData()).post("https://reqres.in/api/users");
        response.prettyPrint();
        response.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().
                body("name",is("morpheus")).and().body("job",is("leader"));
    }
    @Test
    public void putdata(){
        Response response = given().contentType(ContentType.JSON).when().body(Payload.putData()).put("https://reqres.in/api/users2");
        response.prettyPrint();
        response.then().assertThat().body("name",is("morpheus"));
    }
    @Test
    public void deletedata(){
        Response response = given().when().delete("https://reqres.in/api/users2");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
    }




}
