package api.client;

import api.config.ApiConfig;
import api.models.Order;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class StoreClient {
    
    public StoreClient() {
        io.restassured.RestAssured.baseURI = ApiConfig.BASE_URL;
    }
    
    public Order getOrderById(Long orderId) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(ApiConfig.STORE_ENDPOINT + "/order/" + orderId)
                .then()
                .statusCode(200)
                .extract()
                .as(Order.class);
    }

    public Order createOrder(Order order) {
        return given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(ApiConfig.STORE_ENDPOINT + "/order")
                .then()
                .statusCode(200)
                .extract()
                .as(Order.class);
    }

    public void deleteOrder(Long orderId) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(ApiConfig.STORE_ENDPOINT + "/order/" + orderId)
                .then()
                .statusCode(200);
    }

    public Object getInventory() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(ApiConfig.STORE_ENDPOINT + "/inventory")
                .then()
                .statusCode(200)
                .extract()
                .as(Object.class);
    }
} 