package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.OrderDetailModel;

public interface OrderDetailDao {
	List<OrderDetailModel> getAllOrderByOrderId(int orderId); 
}
