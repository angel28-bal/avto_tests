package api.client;

import api.config.ApiConfig;
import api.models.Pet;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class PetClient {
    
    public PetClient() {
        io.restassured.RestAssured.baseURI = ApiConfig.BASE_URL;
    }
    
    public Pet getPetById(Long petId) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(ApiConfig.PET_ENDPOINT + "/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public Pet[] getPetsByStatus(String status) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam("status", status)
                .when()
                .get(ApiConfig.PET_ENDPOINT + "/findByStatus")
                .then()
                .statusCode(200)
                .extract()
                .as(Pet[].class);
    }

    public Pet createPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(ApiConfig.PET_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public Pet updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(ApiConfig.PET_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public void deletePet(Long petId) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(ApiConfig.PET_ENDPOINT + "/" + petId)
                .then()
                .statusCode(200);
    }
} 


