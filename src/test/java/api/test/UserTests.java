package api.test;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.LogManager;

public class UserTests {

    Faker faker;
    User userPayload;
    public Logger logger;

    @BeforeClass
    public void setupData() {

        faker = new Faker();
        userPayload = new User();


        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        // logs
        logger = LoggerFactory.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){

        logger.info("******* Creating user *****************");
        Response response = UserEndpoints.createUser(this.userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******* user is created *****************");
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        logger.info("******* Reading user info *****************");
        Response response = UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******* user info is displayed *****************");
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        logger.info("******* Updating user *****************");

        // Update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());


        Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

        // Checking data after update
        Response responseAfterUpdate = UserEndpoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
        logger.info("******* user is updated *****************");
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){

        logger.info("******* Deleting user *****************");
        Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******* user deleted *****************");
    }

}
