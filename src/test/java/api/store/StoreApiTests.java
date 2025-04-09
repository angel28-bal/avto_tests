package api.store;

import api.client.StoreClient;
import api.models.Order;
import api.utils.TestDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Pet Store API Tests")
@Feature("Store Operations")
public class StoreApiTests {
    private StoreClient storeClient;
    private TestDataGenerator generator;

    @BeforeEach
    public void setUp() {
        storeClient = new StoreClient();
        generator = new TestDataGenerator();
    }

    @Test
    @Description("Test placing an order for a pet")
    public void testPlaceOrder() {
        Order newOrder = generator.generateOrder();
        Order createdOrder = storeClient.createOrder(newOrder);
        
        assertNotNull(createdOrder.getId());
        assertEquals(newOrder.getPetId(), createdOrder.getPetId());
        assertEquals(newOrder.getQuantity(), createdOrder.getQuantity());
    }

    @Test
    @Description("Test getting an order by ID")
    public void testGetOrderById() {
        Order newOrder = generator.generateOrder();
        Order createdOrder = storeClient.createOrder(newOrder);
        
        Order retrievedOrder = storeClient.getOrderById(createdOrder.getId());
        
        assertEquals(createdOrder.getId(), retrievedOrder.getId());
        assertEquals(createdOrder.getPetId(), retrievedOrder.getPetId());
    }

    @Test
    @Description("Test deleting an order")
    public void testDeleteOrder() {
        Order newOrder = generator.generateOrder();
        Order createdOrder = storeClient.createOrder(newOrder);
        
        storeClient.deleteOrder(createdOrder.getId());
        // Проверка успешного удаления может быть реализована через проверку статус кода
        // или попытку получить удаленный заказ
    }

    @Test
    @Description("Test getting store inventory")
    public void testGetInventory() {
        Object inventory = storeClient.getInventory();
        assertNotNull(inventory);
    }
} 