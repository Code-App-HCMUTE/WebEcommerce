package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.StoreDao;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import vn.iotstar.util.Constant;

public class StoreDaoImpl extends DBConnection implements StoreDao {

	@Override
	public List<StoreModel> getStore(int id) {
		List<StoreModel> stores = new ArrayList<StoreModel>();
		String sql = "SELECT * FROM economies.store where ownerId = ? or staffIds = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.set_id(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setStaffIds(rs.getInt("staffIds"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("cover"));
				store.setFeatured_images(rs.getString("featured_images"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setPoint(rs.getInt("point"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getInt("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}

	@Override
	public void insertStore(StoreModel store) {
		String sql = "INSERT INTO store (name,bio,slug,ownerId,staffIds,isActive,isOpen,avatar,cover,featured_images,commissionId,point,rating,e_wallet,createdAt,updatedAt) VALUES "
											+ "(?,?,?,?,?,1,1,?,?,?,?,0,3,0,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setString(3, store.getName());
			ps.setInt(4, store.getOwnerId());
			ps.setString(5, null);
			ps.setString(6, store.getAvatar());
			ps.setString(7, store.getCover());
			ps.setString(8, store.getFeatured_images());
			ps.setInt(9, store.getCommissionId());
			ps.setDate(10, (java.sql.Date) store.getCreatedAt());
			ps.setDate(11, (java.sql.Date) store.getUpdatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public StoreModel getStoreById(int id) {
		StoreModel store = new StoreModel();
		String sql = "SELECT * FROM economies.store where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				store.set_id(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setStaffIds(rs.getInt("staffIds"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("cover"));
				store.setFeatured_images(rs.getString("featured_images"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setPoint(rs.getInt("point"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getInt("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	@Override
	public void editStore(StoreModel store) {
		String sql = "UPDATE store SET name = ?,slug = ?, bio = ?, avatar = ?, cover = ?, featured_images = ?, updatedAt = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getName());
			ps.setString(3, store.getBio());
			ps.setString(4, store.getAvatar());
			ps.setString(5, store.getCover());
			ps.setString(6, store.getFeatured_images());
			ps.setDate(7, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(8, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public UserModel getOwnerStore() {
		UserModel owner=new UserModel();
		String sql = "SELECT user._id, user.fistName, user.lastName, user.address, user.avatar, user.phone, user.email, user.hashed_password FROM store inner join user on store.ownerId = user._id where store._id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				owner.set_id(rs.getInt("_id"));
				owner.setFistName(rs.getString("fistName"));
				owner.setLastName(rs.getString("lastName"));
				owner.setAddress(rs.getString("address"));
				owner.setAvatar(rs.getString("avatar"));
				owner.setPhone(rs.getString("phone"));
				owner.setEmail(rs.getString("email"));
				owner.setHashed_password(rs.getString("hashed_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return owner;
	}

	@Override
	public int countStaffInStore() {
		String sql = "SELECT count(staffIds) FROM store where _id = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.idStore);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public void updateStaffStore(int id) {
		String sql = "UPDATE store SET staffIds = ?, updatedAt = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(3, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserModel getStaff() {
		UserModel staff=new UserModel();
		String sql = "SELECT user._id, user.fistName, user.lastName, user.address, user.phone, user.email FROM store inner join user on store.staffIds = user._id where store._id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				staff.set_id(rs.getInt("_id"));
				staff.setFistName(rs.getString("fistName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setAddress(rs.getString("address"));
				staff.setPhone(rs.getString("phone"));
				staff.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public void Ruttien(int sotien) {
		String sql = "UPDATE economies.store SET economies.store.e_wallet = economies.store.e_wallet - ?, updatedAt = ?  WHERE economies.store._id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sotien);
			ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(3, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StoreModel getStoreByName(String name) {
		String sql = "SELECT * FROM economies.store where name like ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.set_id(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setStaffIds(rs.getInt("staffIds"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("cover"));
				store.setFeatured_images(rs.getString("featured_images"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setPoint(rs.getInt("point"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getInt("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
