package WebEcommerce.Service;

import WebEcommerce.Model.OrderModel;

import java.util.List;

public interface OrderService {
    List<OrderModel> findAll();
    OrderModel get(int id);

    void edit(OrderModel order);
    void insert(OrderModel order);
    void delete(int id);
}
