package com.PetstoreSwagger;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class PetStore {
    @Test
    public void uploadFileToPetStore() {

        File file = new File("C:\\Users\\Shree\\Pictures\\7-lucky-horse-painting-hd.JPG");

        given().accept("application/json")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1234/uploadImage")
                .then()
                .log().ifStatusCodeIsEqualTo(200);
    }

        @Test
        public void AddNewPetToTheStore_ReturnOkStatus(){
            Response getResult = given().contentType("application/json")
                    .accept("application/json")
                    .body("{\n" +
                            "  \"id\": 2,\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 2,\n" +
                            "    \"name\": \"stanny\"\n" +
                            "  },\n" +
                            "  \"name\": \"doggie\",\n" +
                            "  \"photoUrls\": [\n" +
                            "    \"string\"\n" +
                            "  ],\n" +
                            "  \"tags\": [\n" +
                            "    {\n" +
                            "      \"id\": 2,\n" +
                            "      \"name\": \"string\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"status\": \"available\"\n" +
                            "}")
                    .when()
                    .post("https://petstore.swagger.io/v2/pet");
            getResult.prettyPrint();
            getResult.then().assertThat().statusCode(200);
        }

    @Test
    public void updateAnExistingPet_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"style\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 2,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .put("https://petstore.swagger.io/v2/pet");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void FindPetById_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("id","1")
                .get("https://petstore.swagger.io/v2/pet/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void deletePet_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("id","1")
                .delete("https://petstore.swagger.io/v2/pet/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void GetPetByStatus_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .queryParam("status","available")
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }
    }

