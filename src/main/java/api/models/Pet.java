package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Модель данных для питомца.
 * Используется для отправки и получения данных через API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    /** Уникальный идентификатор питомца */
    private Long id;
    
    /** Категория питомца */
    private Category category;
    
    /** Имя питомца */
    private String name;
    
    /** Список URL фотографий питомца */
    private List<String> photoUrls;
    
    /** Список тегов питомца */
    private List<Tag> tags;
    
    /** Статус питомца в магазине */
    private String status;
    
    /**
     * Категория питомца
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Category {
        private Long id;
        private String name;
    }
    
    /**
     * Тег питомца
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tag {
        private Long id;
        private String name;
    }

    /**
     * Фабричный метод для создания питомца с минимальным набором данных
     * @param name имя питомца
     * @param status статус питомца (available, pending, sold)
     * @return новый объект Pet с установленными базовыми полями
     */
    public static Pet createMinimalPet(String name, String status) {
        return Pet.builder()
                .name(name)
                .status(status)
                .build();
    }
} 