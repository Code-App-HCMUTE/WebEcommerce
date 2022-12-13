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
		String sql = "select * from user where email = ? and hashed_password = ?";
		try {
			Connection connection = super.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setFistName(rs.getString("fistName"));
				user.setLastName(rs.getString("lastName"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getInt("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.setRole(rs.getString("role"));
				user.setEmail(rs.getString("email"));
				user.setE_wallet(rs.getInt("e_wallet"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
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
	public void Register(String email, String phone, String password, String firstName) {
		String sql = "INSERT INTO user (firstName,email,hashed_password,phone,isEmalActive) values (?,?,?,?,1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, phone);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	@Override
	public List<UserModel> GetAllUser() {
		List<UserModel> users = new ArrayList<UserModel>();
		String query = "select * from user";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setFistName(rs.getString("fistName"));
				user.setLastName(rs.getString("lastName"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getInt("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.setRole(rs.getString("role"));
				user.setEmail(rs.getString("email"));
				user.setE_wallet(rs.getInt("e_wallet"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
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
	public void addStaffInStore(UserModel user) {
		String sql = "INSERT INTO user (fistName,lastName,email,hashed_password,phone,isEmalActive,role,createdAt,updatedAt) values (?,?,?,?,?,1,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFistName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, "123456789");
			ps.setString(5, user.getPhone());
			ps.setString(6, "user");
			ps.setDate(7, (java.sql.Date) user.getCreatedAt());
			ps.setDate(8, (java.sql.Date) user.getUpdatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public UserModel getStaffbyPhone(String phone) {
		String sql = "select * from user where phone = ?";
		try {
			Connection connection = super.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setAddress(rs.getString("address"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setFistName(rs.getString("fistName"));
				user.setLastName(rs.getString("lastName"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getInt("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.setRole(rs.getString("role"));
				user.setEmail(rs.getString("email"));
				user.setE_wallet(rs.getInt("e_wallet"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
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
}