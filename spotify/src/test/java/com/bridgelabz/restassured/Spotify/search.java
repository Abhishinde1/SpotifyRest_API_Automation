package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class search {

    String token = "Bearer BQDbAo62Y-wJ7YnYVqcNzxZ9nXWH-JQh9Vpe87339UaDdkuTswqhlD-MlTiVcaWFNFWOjWljTIf4l5s4CZYW93AEEEyQbqPzQtboiiv-chl7ip-qIuxiHpqC4knmo_4VkVCmlvL1iQ3NvniojP9-WTAuJgqupBkCFGPqCza3O9iFbA0okaUDHlxsVWZnVoEBaRorjmoTrHFaVlJxcSB2_atEF-1F-PzFkeqGd6dmx-vVRpcBiXwGyQWsyYVi0U7MdrT_QJVeUhBjKXbRf-8u1BCk9XR4OTREwZ4";

    @Test
    public void SearchForItem_ReturnOKStatus() {
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .queryParam("q","Arjit singh")
                .queryParam("type", "album")
                .get("\thttps://api.spotify.com/v1/search");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(), 200);
    }
}
