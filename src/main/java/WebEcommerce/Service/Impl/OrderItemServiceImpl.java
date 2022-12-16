package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.OrderItemDaoImpl;
import WebEcommerce.Dao.OrderItemDao;
import WebEcommerce.Model.OrderItemModel;
import WebEcommerce.Service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao dao = new OrderItemDaoImpl();
    @Override
    public List<OrderItemModel> ListByOrder(int orderId) {
        return dao.ListByOrder(orderId);
    }

    @Override
    public void insert(OrderItemModel orderItem) {
        dao.insert(orderItem);
    }
}
