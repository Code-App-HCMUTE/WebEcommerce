package WebEcommerce.Dao;

import java.util.Date;
import java.util.List;

import WebEcommerce.Model.OrderModel;

public interface OrderDao {
	List<OrderModel> getAlLOrder();
	List<OrderModel> getAllOrderCancel();
	int countAll();
	int countOrderByDate(Date date);
	OrderModel getOrderById(int id);
	void UpdateStatus(String status,int orderId);
}
