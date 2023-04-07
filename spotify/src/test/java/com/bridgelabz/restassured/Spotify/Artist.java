package com.bridgelabz.restassured.Spotify;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Artist {
    String token = ("Bearer BQCa-s39vsJI5Yu5vdZn8a8_FbZRbybus6i2GMvklaWG2tKU1IoUueoHufhp4MuMg7ZuskYQRtMEWGq27WkCkFpjwSoZr_nObvqlK0ckOvTnIUeZDPwq47Gy2zske5v68vjfW1whdLvxP2FnFeAVj_bjrNc4t1SU6_AKTPgOEC1eAoCqzh5xtOBGs0Z3ykWpJIVqUnNuZeuVsTt4MwiMgkYukjw_AmfsdCTtwsqrllQ7Q7oRudqNmvxLKiNio2Kt-wAqft5eel60SYHNXWiVbcrwbeh5ya_7Uks");

    @Test
    public void getArtistAlbums_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id","6WPmTGeeoymoVlXVtsCwz7")
                .get("\thttps://api.spotify.com/v1/artists/{id}/albums");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void getArtist_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id","6WPmTGeeoymoVlXVtsCwz7")
                .get("https://api.spotify.com/v1/artists/{id}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getSeveralArtist_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids","6WPmTGeeoymoVlXVtsCwz7")
                .get("https://api.spotify.com/v1/artists");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void getArtistRelatedArtist_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Artist id","6WPmTGeeoymoVlXVtsCwz7")
                .get("https://api.spotify.com/v1/artists/{Artist id}/related-artists");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getArtistTopTracks_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id","6WPmTGeeoymoVlXVtsCwz7")
                .queryParam("market","ES")
                .get("https://api.spotify.com/v1/artists/{id}/top-tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
}
