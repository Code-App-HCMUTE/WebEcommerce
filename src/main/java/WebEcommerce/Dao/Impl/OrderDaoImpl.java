package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DBConnection implements OrderDao {
    @Override
    public List<OrderModel> findAll() {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        String sql = "SELECT * FROM `economies`.`order`";
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
    public void edit(OrderModel order) {

    }

    @Override
    public void insert(OrderModel order) {
        String sql =  "INSERT INTO `economies`.`order` (`userId`, `storeId`, `deliveryId`, `commissionId`, `address`, `phone`, `status`, `isPaidBefore`, `amountFromUser`, `amountFromStore`, `amountToStore`, `amountToGD`, `createdAt`, `updatedAt`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try{
            Connection con  =  super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,order.getUserId());
            ps.setInt(2, order.getStoreId());
            ps.setInt(3,order.getDeliveryId());
            ps.setInt(4, order.getCommissionId());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getPhone());
            ps.setString(7, order.getStatus());
            ps.setBoolean(8, order.getIsPaidBefore());
            ps.setDouble(9, order.getAmountFromUser());
            ps.setDouble(10, order.getAmountFromStore());
            ps.setDouble(11, order.getAmountToStore());
            ps.setDouble(12, order.getAmountToGD());
            ps.setDate(13, (Date) order.getCreatedAt());
            ps.setDate(14, (Date) order.getUpdatedAt());
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<OrderModel> userOrder(int userId) {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        String sql = "SELECT * FROM `economies`.`order` where userId = " +userId;
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
    public int LastInserted() {
        String sql = "SELECT _id FROM economies.order ORDER BY _id DESC LIMIT 1";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            return rs.getInt("_id");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}