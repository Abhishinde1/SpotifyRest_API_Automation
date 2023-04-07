package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Episodes {
    String token = "Bearer BQAA6umc0pzyWR9WoB3_aUdVPsXW0A8NGmQYU8KYawLqsGpgbUL-TnPPNGrnk2goi7GrlJjc6MZ3hWUFdzIJkQYCXpcQ0gxgHBM8V0lbIEICQBjqpou6pgujA8vHA6l_MrepKEnv4qbnqdNHiG-3eb_D4q5nc9EdTbNDj8ZtgR3YoZl9Rb5a4BsMiitq9B4cpiCdd7oYTrMG6RTTTaWuMv0_CYJCrgNq_bIGt3Y67kE-JcR6I4YdmYUBO-fsBVYNmfjyjk7ojTlYa9Bv0PFmgnJwxsdIOnwnFymY7Pg0";
    @Test
    public void GetSeveralEpisodes_ReturnOKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids", "4VXhxxLLO8GumiABoJU9Mh")
                .get("https://api.spotify.com/v1/episodes");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
