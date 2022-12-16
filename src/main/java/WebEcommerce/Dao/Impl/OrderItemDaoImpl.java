package WebEcommerce.Dao.Impl;


import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Dao.OrderItemDao;
import WebEcommerce.Model.OrderItemModel;
import WebEcommerce.Model.OrderModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl extends DBConnection implements OrderItemDao {
    @Override
    public List<OrderItemModel> ListByOrder(int orderId) {
        String sql = "select * from orderitem where orderId= "+orderId;
        List<OrderItemModel> orderItemList= new ArrayList<OrderItemModel>();
        try{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setId(rs.getInt("_id"));
                orderItem.setOrderId(rs.getInt("orderId"));
                orderItem.setCount(rs.getInt("count"));
                orderItem.setProductId(rs.getInt("productId"));
                orderItem.setCreatedAt(rs.getDate("createdAt"));
                orderItem.setUpdatedAt(rs.getDate("updatedAt"));
                orderItemList.add(orderItem);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemList;
    }

    @Override
    public void insert(OrderItemModel orderItem) {
        String sql = "insert into orderitem (orderId,productId,count,createdAt,updatedAt) values(?,?,?,?,?)";
        try{
            Connection con  =  super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,orderItem.getOrderId());
            ps.setInt(2, orderItem.getProductId());
            ps.setInt(3,orderItem.getCount());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
