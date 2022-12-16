package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.OrderDetailDao;
import WebEcommerce.Dao.Impl.OrderDetailDaoImpl;
import WebEcommerce.Model.OrderDetailModel;
import WebEcommerce.Service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	@Override
	public List<OrderDetailModel> getAllOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.getAllOrderByOrderId(orderId);
	}

}
