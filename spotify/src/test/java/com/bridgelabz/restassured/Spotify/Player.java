package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Player {
    String token = "Bearer BQAv3jE1xgYku1EPnpKULEyFT0qdvs1aqxJp2j5ndAAEEnmREyE8TREkEyblST50VgIuPMzeyAxEA5KQvjq3BQcXSnWaHO-XxAgsdVz9A2xAXBg13O3YEXR1oV62_ijK2XaUW3UFoaxqEJi7qJ2e7e1QvraJPb2HY0FwrlfBTJwmC-ymzpvMiYFKeyUL_NTJbPjmj2us099qsVmbAMTkQmmbZrza_J0Q9wSuTltlR_hScRvQqM95c7snlrHgJDwBjbuE7ZcRho6k8GpJhTfsTkQRrgJg77AzOiFyD4RfjMYzaw";

    @Test
    public void GetRecentlyPlayedTracks_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/recently-played\n");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTheUsersQueue_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/queue");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAAvailableDevices_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/devices\n");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void putPausePlayBack_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .put("https://api.spotify.com/v1/me/player/pause\n");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),403);
    }
}
