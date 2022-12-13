package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DBConnection implements OrderDao {
    @Override
    public List<OrderModel> findAll() {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        String sql = "SELECT * FROM economies.order";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
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
    public OrderModel get(int id) {
        return null;
    }

    @Override
    public void edit(OrderModel product) {

    }

    @Override
    public void insert(OrderModel product) {

    }

    @Override
    public void delete(int id) {

    }
}