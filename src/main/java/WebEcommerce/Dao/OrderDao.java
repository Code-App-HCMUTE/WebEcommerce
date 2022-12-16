package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.OrderModel;

import java.util.List;

public interface OrderDao {
    List<OrderModel> findAll();

    OrderModel get(int id);

    void edit(OrderModel order);

    void insert(OrderModel order);

    void delete(int id);

    int CountOrder(int loai);

    int SumMoneySell(int year);
}
