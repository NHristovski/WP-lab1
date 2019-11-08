package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private Long currentId = 0L;

    private synchronized Long incrementAndGetId(){
        currentId = currentId + 1;
        return currentId;
    }

    @Override
    public Order placeOrder(String pizzaType,String pizzaSize, String clientName, String address) {
        return new Order(incrementAndGetId(),pizzaType,pizzaSize,clientName,address);
    }
}
