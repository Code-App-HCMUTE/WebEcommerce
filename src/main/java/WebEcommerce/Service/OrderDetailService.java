package WebEcommerce.Service;

import java.util.List;

import WebEcommerce.Model.OrderDetailModel;

public interface OrderDetailService {
	List<OrderDetailModel> getAllOrderByOrderId(int orderId); 
}
