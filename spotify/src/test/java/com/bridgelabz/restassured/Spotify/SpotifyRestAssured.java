package com.bridgelabz.restassured.Spotify;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class SpotifyRestAssured {
    String token = "Bearer BQAdXxVE8JFVpf7SkrzAvKLHMGGusdU5BggVZY84LYADT_kfxPhmdH_6J_dzplz3f92sceSJI3ixwz2-nQCN-_8wrjs4rnTHeg8Ip7k6gupyLbCkpQxYYOSnzQsTrelGkjcRHJY9jJkHMO3AkI3iEUlFuappwQzs11Gw1P8Hj8_RWJwfoXvFwVIXRD2PdQEXCd350-PKQ3j0cAOw7UuQ9pHKRdNg3MYQrzbcQ7_E5sWhHVfRsD27NxHqmiqbhtsOgtr4z-LkL-GSiaLg3dQZWN4uDD_-tXqjcANWQAaDahComMqU";

    @Test
    public void getCurrentUserProfileApiExecution() {
        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/me")
                .then().log().all();
    }

    @Test
    public void getUserProfile_ReturnOkStatus() {
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)

                .get("https://api.spotify.com/v1/users/31ccvyocxru7k5r3lb4zd776iuze");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getCurrentUserPlaylist_ReturnOkStatus() {
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/me/playlists\n");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);

    }
        @Test
        public void getPlaylistItem_ReturnOkStatus() {
            Response getResult = given().accept("application/json")
                    .contentType("application/json")
                    .header("Authorization", token)
                    .get("https://api.spotify.com/v1/playlists/5sXOAy1zVLUmL8teN8ZuKR/tracks\n");
            getResult.prettyPrint();
            getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersPlaylist_ReturnOkStatus() {
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/users/31ccvyocxru7k5r3lb4zd776iuze/playlists\n");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void DeletePlaylistItems_ReturnStatusCodeOK(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", token)
                .body("{ \"tracks\": [{ \"uri\": \"spotify:track:7vfdwi6d1KEUlzqESyDHLy\" },{ \"uri\": \"spotify:track:1301WleyT98MSxVHPZCA6M\" }] }")
                .when()
                .delete("https://api.spotify.com/v1/playlists/5sXOAy1zVLUmL8teN8ZuKR/tracks\n");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }


    @Test
    public void UpdatePlaylistItems_ReturnStatusCodeOK() {
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "  \"range_start\": 0,\n" +
                        "  \"insert_before\": 1,\n" +
                        "  \"range_length\": 1\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/5sXOAy1zVLUmL8teN8ZuKR/tracks\n");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void ChangePlaylistDetails_ReturnStatusCodeOK() {
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"kumar\",\n" +
                        "  \"description\": \"Updated playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/5sXOAy1zVLUmL8teN8ZuKR\n");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }
}
