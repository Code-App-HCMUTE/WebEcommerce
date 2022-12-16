package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.StoreLevelDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StoreLevelModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreLevelDaoImpl extends DBConnection implements StoreLevelDao {
    @Override
    public List<StoreLevelModel> findAll() {
        List<StoreLevelModel> storeLevels = new ArrayList<StoreLevelModel>();
        String sql = "SELECT * FROM storelevel";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StoreLevelModel storeLevel = new StoreLevelModel();
                storeLevel.setId(rs.getInt("_id"));
                storeLevel.setName(rs.getString("name"));
                storeLevel.setMinPoint(rs.getInt("minPoint"));
                storeLevel.setDiscount(rs.getInt("discount"));
                storeLevel.setIsDeleted(rs.getBoolean("isDeleted"));
                storeLevel.setCreatedAt(rs.getDate("createdAt"));
                storeLevel.setUpdatedAt(rs.getDate("updatedAt"));
                storeLevels.add(storeLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeLevels;
    }

    @Override
    public StoreLevelModel get(int id) {

        String sql = "SELECT * FROM storelevel WHERE _id=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StoreLevelModel storeLevel = new StoreLevelModel();
                storeLevel.setId(rs.getInt("_id"));
                storeLevel.setName(rs.getString("name"));
                storeLevel.setMinPoint(rs.getInt("minPoint"));
                storeLevel.setDiscount(rs.getInt("discount"));
                storeLevel.setIsDeleted(rs.getBoolean("isDeleted"));
                storeLevel.setCreatedAt(rs.getDate("createdAt"));
                storeLevel.setUpdatedAt(rs.getDate("updatedAt"));
                return storeLevel;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void edit(StoreLevelModel storeLevel) {
        String sql = "UPDATE  storelevel SET `name`=?, `minPoint`=?, `discount`=?, `isDeleted`=?, `updatedAt`=? WHERE `_id`=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, storeLevel.getName());
            ps.setInt(2, storeLevel.getMinPoint());
            ps.setInt(3, storeLevel.getDiscount());
            ps.setBoolean(4, storeLevel.getIsDeleted());
            ps.setDate(5, (Date) storeLevel.getUpdatedAt());
            ps.setInt(6, storeLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(StoreLevelModel storeLevel) {
        String sql = "INSERT INTO storelevel (`name`, `minPoint`, `discount`, `isDeleted`, `createdAt`, `updatedAt`)" +
                " VALUES (?,?,?,?,?,?);";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, storeLevel.getName());
            ps.setInt(2, storeLevel.getMinPoint());
            ps.setInt(3, storeLevel.getDiscount());
            ps.setBoolean(4, storeLevel.getIsDeleted());
            ps.setDate(5, (Date) storeLevel.getCreatedAt());
            ps.setDate(6, (Date) storeLevel.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM storelevel WHERE  `_id`= ? ";

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
