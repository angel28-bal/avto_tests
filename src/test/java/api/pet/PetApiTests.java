package api.pet;

import api.client.PetClient;
import api.models.Pet;
import api.utils.TestDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Pet Store API Tests")
@Feature("Pet Operations")
public class PetApiTests {
    private PetClient petClient;
    private TestDataGenerator generator;

    @BeforeEach
    public void setUp() {
        petClient = new PetClient();
        generator = new TestDataGenerator();
    }

    @Test
    @Description("Test creating a new pet")
    public void testCreatePet() {
        Pet newPet = generator.generatePet();
        Pet createdPet = petClient.createPet(newPet);
        
        assertNotNull(createdPet.getId());
        assertEquals(newPet.getName(), createdPet.getName());
        assertEquals(newPet.getStatus(), createdPet.getStatus());
    }

    @Test
    @Description("Test getting a pet by ID")
    public void testGetPetById() {
        Pet newPet = generator.generatePet();
        Pet createdPet = petClient.createPet(newPet);
        
        Pet retrievedPet = petClient.getPetById(createdPet.getId());
        
        assertEquals(createdPet.getId(), retrievedPet.getId());
        assertEquals(createdPet.getName(), retrievedPet.getName());
    }

    @Test
    @Description("Test updating an existing pet")
    public void testUpdatePet() {
        Pet newPet = generator.generatePet();
        Pet createdPet = petClient.createPet(newPet);
        
        createdPet.setName("Updated " + createdPet.getName());
        Pet updatedPet = petClient.updatePet(createdPet);
        
        assertEquals(createdPet.getName(), updatedPet.getName());
    }

    @Test
    @Description("Test deleting a pet")
    public void testDeletePet() {
        Pet newPet = generator.generatePet();
        Pet createdPet = petClient.createPet(newPet);
        
        petClient.deletePet(createdPet.getId());
        // Проверка успешного удаления может быть реализована через проверку статус кода
        // или попытку получить удаленного питомца
    }

    @Test
    @Description("Test finding pets by status")
    public void testFindPetsByStatus() {
        Pet[] pets = petClient.getPetsByStatus("available");
        assertNotNull(pets);
        assertTrue(pets.length > 0);
    }
} 