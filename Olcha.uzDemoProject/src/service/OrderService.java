package service;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        for (Order order1 : orders) {
            if (order1 != null) {
                if (order1.getOrderId() == order.getOrderId()) {
                    return false;
                }
            }
        }
        orders.add(order);
        return true;
    }
}
