package mk.ukim.finki.wp.lab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;


}
