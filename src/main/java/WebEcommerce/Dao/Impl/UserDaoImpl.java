package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.UserDao;
import WebEcommerce.Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnection implements UserDao {
    @Override
    public UserModel login(String email, String password) {
        String sql = "select * from user where email = ? and hashed_password = ?;";
        try {
            Connection connection = super.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                return user;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void Register(UserModel user) {
        String sql = "INSERT INTO user (firstName,email,hashed_password,phone,isEmalActive,createdAt,updatedAt,role)" +
                " values (?,?,?,?,1,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getHashed_password());
            ps.setString(4,user.getPhone());
            ps.setDate(5, (java.sql.Date) user.getCreatedAt());
            ps.setDate(6, (java.sql.Date) user.getUpdatedAt());
            ps.setString(7,"user");
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }



    @Override
    public List<UserModel> GetAllUser() {
        List<UserModel> users = new ArrayList<UserModel>();
        String query = "select * from user";
        try{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(int id,UserModel user) {
        String sql = "update user set email=?, firstName=?, lastName=?, phone=?, address=?, createdAt=?, updatedAt=?, avatar=? where _id = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getFirstName());
            ps.setString(3,user.getLastName());
            ps.setString(4,user.getPhone());
            ps.setString(5,user.getAddress());
            ps.setDate(6, (java.sql.Date) user.getCreatedAt());
            ps.setDate(7, (java.sql.Date) user.getUpdatedAt());
            ps.setString(8,user.getAvatar());
            ps.setInt(9,id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    @Override
    public List<UserModel> Search(String query, int size, int index) {
        String sql = "with x as(select *,row_number() over(order by createdAt desc)as r" +
                " from user where concat(firstName,lastName) like '%"+query+"%')\n" +
                "select * from x where r between ?*?-? and ?*?";
        List<UserModel> users = new ArrayList<UserModel>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,index);
            ps.setInt(2,size);
            ps.setInt(3,size-1);
            ps.setInt(4,index);
            ps.setInt(5,size);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int SearchEmailCount(String query) {
        List<UserModel> users = new ArrayList<UserModel>();
        String sql = "select * from user where email like '%"+query+"%'";
        try{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users.size();
    }

    @Override
    public int SearchCount(String query) {
        List<UserModel> users = new ArrayList<UserModel>();
        String sql = "select * from user where concat(firstName,lastName) like '%"+query+"%'";
        try{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users.size();
    }

    @Override
    public void ResetPassword(int id, String newPass) {
        String sql = "update user set hashed_password=? where _id=?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,newPass);
            ps.setInt(2,id);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    @Override
    public List<UserModel> getUserNew(){
        List<UserModel> users = new ArrayList<UserModel>();
        String query = "select * from user ORDER BY createdAt DESC LIMIT 0, 5";
        try{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user=new UserModel();
                user.set_id(rs.getInt("_id"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setSlug(rs.getString("slug"));
                user.setId_card(rs.getInt("id_card"));
                user.setPhone(rs.getString("phone"));
                user.setSalt(rs.getString("salt"));
                user.setHashed_password(rs.getString("hashed_password"));
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setE_wallet(rs.getInt("e_wallet"));
                user.setIsEmailActive(rs.getBoolean("isEmalActive"));
                user.setPhoneActive(rs.getBoolean("isPhoneActive"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setPoint(rs.getInt("point"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
