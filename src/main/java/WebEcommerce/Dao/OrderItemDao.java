package WebEcommerce.Dao;

import WebEcommerce.Model.OrderItemModel;

import java.util.List;

public interface OrderItemDao {
    List<OrderItemModel> ListByOrder (int orderId);
    void insert (OrderItemModel orderItem);
}
