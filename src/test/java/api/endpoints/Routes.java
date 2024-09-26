package api.endpoints;

// Swagger URI -> https://petstore.swagger.io/

// create user POST --> https://petstore.swagger.io/v2/user
// Get user GET --> https://petstore.swagger.io/v2/user/{username}
// Update user PUT --> https://petstore.swagger.io/v2/user/{username}
// Delete user DELETE --> https://petstore.swagger.io/v2/user/{username}

public class Routes {

    public static String base_url = "https://petstore.swagger.io/v2";

    // USER MODEL

    public static String postUrl = base_url+"/user";
    public static String getUrl = base_url+"/user/{username}";
    public static String updateUrl = base_url+"/user/{username}";
    public static String deleteUrl = base_url+"/user/{username}";

}
