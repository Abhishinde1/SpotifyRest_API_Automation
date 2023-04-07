package com.bridgelabz.restassured.Spotify;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Audiobooks {
    String token = ("Bearer BQDYDfnjuVoIy1CIKtI46m1T8_LtnWJMgD1_82ng1E5Emp6kuK8I08ZKR0sic4sCbC5j9AOx4TdVqurhoECc2dxQ2Hswz7p2AcFzAC0V_JroWcxPfDMGkgsw6Ec0O0e0Pxq9-JD9SwaIXJ03s8U2SZjJ92Hh-q98OdYk-sgLT-okXHv0aqnTF4zqpnQeDHIQI1QeH3EitI7HhHwJWnkXJnB01SFIgKNQgkhy3wW4Ev1BM0l5cLwH2N5JBB9tz18z6tlQFCbeugsM36A4yFBRSbwxssVlco4Fs8c");

    @Test
    public void getSeveraAudiobook_ReturnOkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids","18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ")
                .get("https://api.spotify.com/v1/audiobooks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAnAudiobookThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/audiobooks/{id}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAnAudiobookChaptersThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/audiobooks/{id}/chapters");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
