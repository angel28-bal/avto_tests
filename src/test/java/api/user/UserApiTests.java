package api.user;

import api.client.UserClient;
import api.models.User;
import api.utils.TestDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для API пользователей.
 * Проверяет основные операции с пользователями: создание, чтение, обновление, удаление.
 */
@Epic("Pet Store API Tests")
@Feature("User Operations")
public class UserApiTests {
    private UserClient userClient;
    private TestDataGenerator generator;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        generator = new TestDataGenerator();
    }

    @Test
    @Description("Test creating a new user")
    public void testCreateUser() {
        User newUser = generator.generateUser();
        User createdUser = userClient.createUser(newUser);
        
        assertNotNull(createdUser);
        assertEquals(newUser.getUsername(), createdUser.getUsername());
        assertEquals(newUser.getEmail(), createdUser.getEmail());
    }

    @Test
    @Description("Test getting a user by username")
    public void testGetUserByUsername() {
        User newUser = generator.generateUser();
        userClient.createUser(newUser);
        
        User retrievedUser = userClient.getUserByUsername(newUser.getUsername());
        
        assertNotNull(retrievedUser);
        assertEquals(newUser.getUsername(), retrievedUser.getUsername());
        assertEquals(newUser.getEmail(), retrievedUser.getEmail());
    }

    @Test
    @Description("Test updating a user")
    public void testUpdateUser() {
        User newUser = generator.generateUser();
        userClient.createUser(newUser);
        
        newUser.setEmail("updated" + newUser.getEmail());
        User updatedUser = userClient.updateUser(newUser.getUsername(), newUser);
        
        assertEquals(newUser.getEmail(), updatedUser.getEmail());
    }

    @Test
    @Description("Test deleting a user")
    public void testDeleteUser() {
        User newUser = generator.generateUser();
        userClient.createUser(newUser);
        
        userClient.deleteUser(newUser.getUsername());
        // Проверка успешного удаления может быть реализована через проверку статус кода
        // или попытку получить удаленного пользователя
    }

    @Test
    @Description("Test user login")
    public void testUserLogin() {
        User newUser = generator.generateUser();
        userClient.createUser(newUser);
        
        String token = userClient.login(newUser.getUsername(), newUser.getPassword());
        assertNotNull(token);
    }

    @Test
    @Description("Test user logout")
    public void testUserLogout() {
        userClient.logout();
        // Здесь можно добавить проверку успешного выхода из системы
    }
} 