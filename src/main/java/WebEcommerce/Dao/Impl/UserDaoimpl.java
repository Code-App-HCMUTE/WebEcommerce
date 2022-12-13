package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.UserDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.UserModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl extends DBConnection implements UserDao {
    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = new ArrayList<UserModel>();
        String sql = "SELECT * FROM user";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setFistName(rs.getString("fistName"));
                user.setLastName(rs.getString("lastname"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getString("id_card"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setIsPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setPoint(rs.getInt("point"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserModel get(int id) {
        return null;
    }

    @Override
    public void edit(UserModel user) {

    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO user (`fistName`, `lastName`, `slug`, `id_card`, `email`, `phone`, `isEmalActive`, `isPhoneActive`, `salt`, `hashed_password`, `role`, `address`, `avatar`, `cover`, `point`, `e_wallet`, `createdAt`, `updatedAt`) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFistName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getId_card());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setBoolean(7, true);
            ps.setBoolean(8, true);
            ps.setString(9, user.getSalt());
            ps.setString(10, user.getHashed_password());
            ps.setString(11, user.getRole());
            ps.setString(12, user.getAddress());
            ps.setString(13, user.getAvatar());
            ps.setString(14, user.getCover());
            ps.setInt(15, user.getPoint());
            ps.setInt(16, user.getE_wallet());
            ps.setDate(17, (Date) user.getCreatedAt());
            ps.setDate(18, (Date) user.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
