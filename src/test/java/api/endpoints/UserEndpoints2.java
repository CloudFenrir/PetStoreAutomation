package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpoints2 {

    static ResourceBundle getURL() {
        return ResourceBundle.getBundle("routes"); // Load properties file --- Return routes from properties file
    }

    public static Response createUser(User payload){

        String post_url = getURL().getString("post_url");

        // Returning a Response
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
    }

    public static Response readUser(String userName){
        String get_url = getURL().getString("get_url");

        // Returning a Response
        return given()
                .pathParam("username", userName)
                .when()
                .get(get_url);
    }

    public static Response updateUser(String userName, User payload){
        String update_url = getURL().getString("update_url");

        // Returning a Response
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(update_url);
    }

    public static Response deleteUser(String userName){
        String delete_url = getURL().getString("delete_url");

        // Returning a Response
        return given()
                .pathParam("username", userName)
                .when()
                .delete(delete_url);
    }

}
