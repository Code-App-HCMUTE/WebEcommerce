package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.UserLevelDao;
import WebEcommerce.Model.UserLevelModel;
import WebEcommerce.Model.UserLevelModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserLevelDaoImpl extends DBConnection implements UserLevelDao {
    @Override
    public List<UserLevelModel> findAll() {
        List<UserLevelModel> userLevels = new ArrayList<UserLevelModel>();
        String sql = "SELECT * FROM userlevel";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserLevelModel userLevel = new UserLevelModel();
                userLevel.setId(rs.getInt("_id"));
                userLevel.setName(rs.getString("name"));
                userLevel.setMinPoint(rs.getInt("minPoint"));
                userLevel.setDiscount(rs.getInt("discount"));
                userLevel.setIsDeleted(rs.getBoolean("isDeleted"));
                userLevel.setCreatedAt(rs.getDate("createdAt"));
                userLevel.setUpdatedAt(rs.getDate("updatedAt"));
                userLevels.add(userLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLevels;
    }

    @Override
    public UserLevelModel get(int id) {

        String sql = "SELECT * FROM userlevel WHERE _id=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserLevelModel userLevel= new UserLevelModel();
                userLevel.setId(rs.getInt("_id"));
                userLevel.setName(rs.getString("name"));
                userLevel.setMinPoint(rs.getInt("minPoint"));
                userLevel.setDiscount(rs.getInt("discount"));
                userLevel.setIsDeleted(rs.getBoolean("isDeleted"));
                userLevel.setCreatedAt(rs.getDate("createdAt"));
                userLevel.setUpdatedAt(rs.getDate("updatedAt"));
                return userLevel;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void edit(UserLevelModel userLevel) {
        String sql = "UPDATE  userlevel SET `name`=?, `minPoint`=?, `discount`=?, `isDeleted`=?, `updatedAt`=? WHERE `_id`=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userLevel.getName());
            ps.setInt(2, userLevel.getMinPoint());
            ps.setInt(3, userLevel.getDiscount());
            ps.setBoolean(4, userLevel.getIsDeleted());
            ps.setDate(5, (Date) userLevel.getUpdatedAt());
            ps.setInt(6, userLevel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(UserLevelModel userLevel) {
        String sql = "INSERT INTO userlevel (`name`, `minPoint`, `discount`, `isDeleted`, `createdAt`, `updatedAt`)" +
                " VALUES (?,?,?,?,?,?);";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userLevel.getName());
            ps.setInt(2, userLevel.getMinPoint());
            ps.setInt(3, userLevel.getDiscount());
            ps.setBoolean(4, userLevel.getIsDeleted());
            ps.setDate(5, (Date) userLevel.getCreatedAt());
            ps.setDate(6, (Date) userLevel.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM userlevel WHERE  `_id`= ? ";

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
