package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель данных для пользователя.
 * Используется для отправки и получения данных через API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /** Уникальный идентификатор пользователя */
    private Long id;
    
    /** Имя пользователя (логин) */
    private String username;
    
    /** Имя */
    private String firstName;
    
    /** Фамилия */
    private String lastName;
    
    /** Email адрес */
    private String email;
    
    /** Пароль */
    private String password;
    
    /** Телефонный номер */
    private String phone;
    
    /** Статус пользователя (0 - неактивный, 1 - активный) */
    private Integer userStatus;
} 