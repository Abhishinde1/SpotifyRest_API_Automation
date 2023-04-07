package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Albums {
    String token = "Bearer BQDbAo62Y-wJ7YnYVqcNzxZ9nXWH-JQh9Vpe87339UaDdkuTswqhlD-MlTiVcaWFNFWOjWljTIf4l5s4CZYW93AEEEyQbqPzQtboiiv-chl7ip-qIuxiHpqC4knmo_4VkVCmlvL1iQ3NvniojP9-WTAuJgqupBkCFGPqCza3O9iFbA0okaUDHlxsVWZnVoEBaRorjmoTrHFaVlJxcSB2_atEF-1F-PzFkeqGd6dmx-vVRpcBiXwGyQWsyYVi0U7MdrT_QJVeUhBjKXbRf-8u1BCk9XR4OTREwZ4";

    @Test
    public void getAlbums_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id","7fL3C5d4cFW7XLZHq4jPwX")
                .get("https://api.spotify.com/v1/albums/{id}\n");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAlbumsTracks_ReturnOKStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id","4aawyAB9vmqN3uQ7FjRGTy")
                .get("https://api.spotify.com/v1/albums/{id}/tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getSeveralAlbums_ReturnOKStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids","5kiZkGMkfKm3tIlh2Tgfi5")
                .get("https://api.spotify.com/v1/albums");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
}
