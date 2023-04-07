package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class tracks {
    String token = "Bearer BQDE-Gzt3w-sMRxGd7lFY-DkA0ToHzLooU7NTkP9MahGIl2kxB6YfwjbqKqOmnsvdxo7lui1zl3Lxj2XEICTdKWyRS6InEqu1_LkS3N1Udv8MOvH76QNyUMrECVJcrTonv7tmT1bOqiXaTrKX4mHur2WpAMJtzC0FG8LnBIoSfgdWUcIJVq2bWUKjZuN6iHpA6X6eWr_oeMObzQgwo2HlYAwqpHeD3ssCfI2MTSFUnuQ1qZhocbirpyCde8wsyIccBNg_RZOC0MaV5DhwnUAk84eNR4GPsrnsD8";
    @Test
    public void getTrack_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/tracks/4iV5W9uYEdYUVa79Axb7Rh\n");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getSeveralTracks_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/tracks?ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }


    @Test
    public void getTrackAudiosFeatures_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/audio-features/4iV5W9uYEdYUVa79Axb7Rh");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTracksAudiosFeaturesus_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/audio-features?ids=4iV5W9uYEdYUVa79Axb7Rh");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTracksAudiosAnalysis_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/audio-analysis/4iV5W9uYEdYUVa79Axb7Rh");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
