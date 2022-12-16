package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;
import vn.iotstar.util.Constant;

public class OrderDaoImpl extends DBConnection implements OrderDao {

	@Override
	public List<OrderModel> getAlLOrder() {
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM economies.order where storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<OrderModel> getAllOrderCancel() {
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM economies.order where economies.order.status = ? and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "cancelled");
			ps.setInt(2, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public int countAll() {
		String sql = "SELECT count(*) FROM economies.order where storeId = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
        } catch (Exception e) {	
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int countOrderByDate(Date date) {
		String sql = "SELECT count(*) FROM economies.order where storeId = ? and createdAt = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ps.setDate(2, (java.sql.Date) date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
        } catch (Exception e) {	
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public OrderModel getOrderById(int id) {
		String sql = "SELECT * FROM economies.order where economies.order._id = ? and storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateStatus(String status,int orderId) {
		String sql = "UPDATE economies.order SET status = ?, updatedAt = ? WHERE _id = ? and storeId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(3, orderId);
			ps.setInt(4, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
