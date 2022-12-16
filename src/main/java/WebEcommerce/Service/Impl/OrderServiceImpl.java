package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.OrderDaoImpl;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.OrderService;

import java.util.Date;
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

    @Override
    public List<OrderModel> userOrder(int userId) {
        return orderDao.userOrder(userId);
    }

    @Override
    public int LastInserted() {
        return orderDao.LastInserted();
    }
    @Override
    public List<OrderModel> getAlLOrder() {
        // TODO Auto-generated method stub
        return orderDao.getAlLOrder();
    }
    @Override
    public List<OrderModel> getAllOrderCancel() {
        // TODO Auto-generated method stub
        return orderDao.getAllOrderCancel();
    }
    @Override
    public int countAll() {
        // TODO Auto-generated method stub
        return orderDao.countAll();
    }
    @Override
    public int countOrderByDate(Date date) {
        // TODO Auto-generated method stub
        return orderDao.countOrderByDate(date);
    }
    @Override
    public OrderModel getOrderById(int id) {
        // TODO Auto-generated method stub
        return orderDao.getOrderById(id);
    }
    @Override
    public void UpdateStatus(String status,int orderId) {
        orderDao.UpdateStatus(status,orderId);
    }
}
