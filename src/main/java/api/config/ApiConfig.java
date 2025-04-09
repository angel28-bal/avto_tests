package api.config;

public class ApiConfig {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String PET_ENDPOINT = BASE_URL + "/pet";
    public static final String STORE_ENDPOINT = BASE_URL + "/store";
    public static final String USER_ENDPOINT = BASE_URL + "/user";
    
    private ApiConfig() {
        // Приватный конструктор для утилитного класса
    }
    
    public static class Endpoints {
        // Pet endpoints
        public static final String PETS = "/pet";
        public static final String PET_BY_ID = "/pet/{petId}";
        public static final String FIND_BY_STATUS = "/pet/findByStatus";
        
        // Store endpoints
        public static final String STORE_ORDER = "/store/order";
        public static final String STORE_ORDER_BY_ID = "/store/order/{orderId}";
        public static final String STORE_INVENTORY = "/store/inventory";
        
        // User endpoints
        public static final String USER = "/user";
        public static final String USER_BY_USERNAME = "/user/{username}";
        public static final String USER_LOGIN = "/user/login";
        public static final String USER_LOGOUT = "/user/logout";
    }
} 