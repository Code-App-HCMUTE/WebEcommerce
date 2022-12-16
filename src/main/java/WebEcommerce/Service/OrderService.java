package WebEcommerce.Service;

import java.util.Date;
import java.util.List;

import WebEcommerce.Model.OrderModel;

public interface OrderService {
	List<OrderModel> getAlLOrder();
	List<OrderModel> getAllOrderCancel();
	int countAll();
	int countOrderByDate(Date date);
	OrderModel getOrderById(int id);
	void UpdateStatus(String status,int orderId);

    List<OrderModel> findAll();
    OrderModel get(int id);

    void edit(OrderModel order);
    void insert(OrderModel order);
    void delete(int id);
    List<OrderModel> userOrder(int userId);
    int LastInserted ();

}
