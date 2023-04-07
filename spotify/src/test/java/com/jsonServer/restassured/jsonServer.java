package com.jsonServer.restassured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class jsonServer {
    @Test
    public void createPost_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"id\" : 20,\n" +
                        "        \"title\": \"infosys\",\n" +
                        "        \"author\": \" developer\"\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/posts");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);
    }

    @Test
    public void getAllPosts_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/posts");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getSpecificPosts_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("id","17")
                .get(" http://localhost:3000/posts/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void updateSpecificPost_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"title\": \"TATA\",\n" +
                        "        \"author\": \"Ratan Tata\"\n" +
                        "    }")
                .pathParam("id","17")
                .put(" http://localhost:3000/posts/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void deleteSpecificPost_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("id","20")
                .delete(" http://localhost:3000/posts/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void addComments_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"id\": 10,\n" +
                        "        \"body\": \"comment\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);
    }

    @Test
    public void updateSpecificComments_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"body\": \"Tenth\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .pathParam("id","10")
                .when()
                .put(" http://localhost:3000/comments/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllComments_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllCommentsForSpecificPostId_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .queryParam("postId","3")
                .get(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }


    @Test
    public void deleteSpecificComments_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("id","10")
                .delete(" http://localhost:3000/comments/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllProfiles_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/profile");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void addProfile_ReturnOkStatus() {
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"Id\" : 8,\n" +
                        "        \"Name\" : \"Akshay\",\n" +
                        "        \"City\": \"Goa\",\n" +
                        "        \"postId\": 4\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/profile");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);
    }

}
