package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Order;

public interface OrderService {
    Order placeOrder(String pizzaType, String pizzaSize, String clientName, String address);
}
