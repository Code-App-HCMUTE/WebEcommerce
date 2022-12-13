package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Dao.Impl.OrderDaoImpl;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.OrderService;

public class OrderServiveImpl implements OrderService{
	OrderDao orderDao=new OrderDaoImpl();
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

}
