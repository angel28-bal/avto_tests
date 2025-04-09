package api.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import api.models.Order;
import api.models.Pet;
import api.models.User;

public class TestDataGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] PET_STATUSES = {"available", "pending", "sold"};
    private static final String[] PET_NAMES = {"Buddy", "Max", "Charlie", "Lucy", "Bailey"};

    public Pet generatePet() {
        return Pet.builder()
                .name(getRandomElement(PET_NAMES))
                .status(getRandomElement(PET_STATUSES))
                .photoUrls(Arrays.asList("http://example.com/photo1.jpg"))
                .category(Pet.Category.builder()
                        .id(generateRandomId())
                        .name("Dogs")
                        .build())
                .tags(Arrays.asList(Pet.Tag.builder()
                        .id(generateRandomId())
                        .name("friendly")
                        .build()))
                .build();
    }

    public Order generateOrder() {
        return Order.builder()
                .petId(generateRandomId())
                .quantity(RANDOM.nextInt(1, 10))
                .shipDate(LocalDateTime.now())
                .status("placed")
                .complete(false)
                .build();
    }

    public User generateUser() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return User.builder()
                .username("user" + uuid)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe." + uuid + "@example.com")
                .password("password123")
                .phone("+1234567890")
                .userStatus(1)
                .build();
    }

    private Long generateRandomId() {
        return RANDOM.nextLong(1, 10000);
    }

    private <T> T getRandomElement(T[] array) {
        return array[RANDOM.nextInt(array.length)];
    }
} 