package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDetailDao;
import WebEcommerce.Model.OrderDetailModel;
import vn.iotstar.util.Constant;

public class OrderDetailDaoImpl extends DBConnection implements OrderDetailDao {

	@Override
	public List<OrderDetailModel> getAllOrderByOrderId(int orderId) {
		List<OrderDetailModel> orderdetails = new ArrayList<OrderDetailModel>();
		String sql = "SELECT economies.orderitem.productId  FROM economies.orderitem inner join economies.order on economies.orderitem.orderId = economies.order._id where economies.order.storeId = ? and economies.order._id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ps.setInt(2, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetailModel orderdetail = new OrderDetailModel();
				orderdetail.setProductId(rs.getInt("productId"));	
				orderdetails.add(orderdetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderdetails;
	}

}
