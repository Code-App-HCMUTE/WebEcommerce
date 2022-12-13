package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.OrderModel;

import java.util.List;

public interface OrderDao {
    List<OrderModel> findAll();

    OrderModel get(int id);

    void edit(OrderModel product);

    void insert(OrderModel product);

    void delete(int id);
}
