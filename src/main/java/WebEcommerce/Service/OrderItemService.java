package WebEcommerce.Service;

import WebEcommerce.Model.OrderItemModel;

import java.util.List;

public interface OrderItemService {
    List<OrderItemModel> ListByOrder (int orderId);
    void insert (OrderItemModel orderItem);
}
