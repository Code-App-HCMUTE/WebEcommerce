package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.OrderDaoImpl;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao =  new OrderDaoImpl();
    @Override
    public List<OrderModel> findAll() {
        return orderDao.findAll();
    }

    @Override
    public OrderModel get(int id) {
        return null;
    }

    @Override
    public void edit(OrderModel order) {
        orderDao.edit(order);
    }

    @Override
    public void insert(OrderModel order) {
        orderDao.insert(order);
    }

    @Override
    public void delete(int id) {
        orderDao.delete(id);
    }
}
