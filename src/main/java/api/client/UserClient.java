package api.client;

import api.config.ApiConfig;
import api.models.User;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class UserClient {
    
    public UserClient() {
        io.restassured.RestAssured.baseURI = ApiConfig.BASE_URL;
    }
    
    public User getUserByUsername(String username) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(ApiConfig.USER_ENDPOINT + "/" + username)
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);
    }

    public User createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ApiConfig.USER_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);
    }

    public User updateUser(String username, User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(ApiConfig.USER_ENDPOINT + "/" + username)
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);
    }

    public void deleteUser(String username) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(ApiConfig.USER_ENDPOINT + "/" + username)
                .then()
                .statusCode(200);
    }

    public String login(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get(ApiConfig.USER_ENDPOINT + "/login")
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }

    public void logout() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(ApiConfig.USER_ENDPOINT + "/logout")
                .then()
                .statusCode(200);
    }
} 