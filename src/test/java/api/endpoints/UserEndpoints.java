package api.endpoints;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.*;


// UserEndpoints.java
// Create to perform CREATE, READ, UPDATE and DELETE request to the User API

public class UserEndpoints {

    public static Response createUser(User payload){
        // Returning a Response
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postUrl);
    }

    public static Response readUser(String userName){
        // Returning a Response
        return given()
                .pathParam("username", userName)
                .when()
                .get(Routes.getUrl);
    }

    public static Response updateUser(String userName, User payload){
        // Returning a Response
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routes.updateUrl);
    }

    public static Response deleteUser(String userName){
        // Returning a Response
        return given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.deleteUrl);
    }

}
