package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Модель данных для заказа.
 * Используется для отправки и получения данных через API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /** Уникальный идентификатор заказа */
    private Long id;
    
    /** Идентификатор питомца */
    private Long petId;
    
    /** Количество */
    private Integer quantity;
    
    /** Дата доставки */
    private LocalDateTime shipDate;
    
    /** Статус заказа */
    private String status;
    
    /** Флаг завершенности заказа */
    private Boolean complete;
} 