package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.CommissionDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.CommissionModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommissionDaoImpl extends DBConnection implements CommissionDao {

    @Override
    public List<CommissionModel> findAll() {
        List<CommissionModel> Commissions = new ArrayList<>();
        String sql = "SELECT * FROM commission";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommissionModel Commission = new CommissionModel();
                Commission.setId(rs.getInt("_id"));
                Commission.setName(rs.getString("name"));
                Commission.setCost(rs.getInt("cost"));
                Commission.setDescription(rs.getString("description"));
                Commission.setIsDelete(rs.getBoolean("isDeleted"));
                Commission.setCreatedAt(rs.getDate("createdAt"));
                Commission.setUpdatedAt(rs.getDate("updatedAt"));
                Commissions.add(Commission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Commissions;
    }

    @Override
    public CommissionModel get(int id) {

        String sql = "SELECT * FROM commission WHERE _id=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommissionModel Commission = new CommissionModel();
                Commission.setId(rs.getInt("_id"));
                Commission.setName(rs.getString("name"));
                Commission.setCost(rs.getInt("cost"));
                Commission.setDescription(rs.getString("description"));
                Commission.setIsDelete(rs.getBoolean("isDeleted"));
                Commission.setCreatedAt(rs.getDate("createdAt"));
                Commission.setUpdatedAt(rs.getDate("updatedAt"));
                return Commission;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void edit(CommissionModel commission) {
        String sql = "UPDATE  commission SET name=?,cost=?, description=?, isDeleted=?, updatedAt=? WHERE _id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commission.getName());
            ps.setInt(2, commission.getCost());
            ps.setString(3, commission.getDescription());
            ps.setBoolean(4, commission.getIsDelete());
            ps.setDate(5, (Date) commission.getUpdatedAt());
            ps.setInt(6, commission.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(CommissionModel commission) {
        String sql = "INSERT INTO commission (name,cost, description, isDeleted, createdAt, updatedAt)  VALUES (?,?,?,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commission.getName());
            ps.setInt(2, commission.getCost());
            ps.setString(3, commission.getDescription());
            ps.setBoolean(4, commission.getIsDelete());
            ps.setDate(5, (Date) commission.getCreatedAt());
            ps.setDate(6, (Date) commission.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM commission WHERE _id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
