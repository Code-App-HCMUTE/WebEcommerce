package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.OrderModel;

public interface OrderDao {
	List<OrderModel> getAlLOrder();
}
