package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.DeliveryDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.DeliveryModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDaoImpl extends DBConnection implements DeliveryDao {
    @Override
    public List<DeliveryModel> findAll() {

        List<DeliveryModel> deliverys = new ArrayList<DeliveryModel>();
        String sql = "SELECT * FROM delivery";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeliveryModel delivery = new DeliveryModel();
                delivery.set_id(rs.getInt("_id"));
                delivery.setName(rs.getString("name"));
                delivery.setDescription(rs.getString("description"));
                delivery.setPrice(rs.getInt("price"));
                delivery.setIsDeleted(rs.getBoolean("isDeleted"));
                delivery.setCreatedAt(rs.getDate("createdAt"));
                delivery.setUpdatedAt(rs.getDate("updatedAt"));
                deliverys.add(delivery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliverys;
    }

    @Override
    public DeliveryModel get(int id) {
        return null;
    }

    @Override
    public void edit(DeliveryModel delivery) {

    }

    @Override
    public void insert(DeliveryModel delivery) {
        String sql = "INSERT INTO delivery (name, description, price, isDeleted, createdAt, updatedAt)  VALUES (?,?,?,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, delivery.getName());
            ps.setString(2, delivery.getDescription());
            ps.setDouble(3, delivery.getPrice());
            ps.setBoolean(4, delivery.getIsDeleted());
            ps.setDate(5, (Date) delivery.getCreatedAt());
            ps.setDate(6, (Date) delivery.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
