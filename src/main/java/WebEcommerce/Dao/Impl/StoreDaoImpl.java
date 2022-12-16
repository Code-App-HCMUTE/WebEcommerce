package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.StoreDao;
import WebEcommerce.Model.StoreModel;

public class StoreDaoImpl extends DBConnection implements StoreDao {

    @Override
    public List<StoreModel> getAllStore() {
        List<StoreModel> stores = new ArrayList<StoreModel>();
        String sql = "SELECT * FROM store";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StoreModel store = new StoreModel();
                store.set_id(rs.getInt("_id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStaffIds(rs.getString("staffIds"));
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
            ps.setString(4, "1");
            ps.setString(5, null);
            ps.setString(6, store.getAvatar());
            ps.setString(7, store.getCover());
            ps.setString(8, store.getFeatured_images());
            ps.setString(9, null);
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
                store.setStaffIds(rs.getString("staffIds"));
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
        // TODO Auto-generated method stub

    }


    @Override
    public List<StoreModel> search(String query, int size, int index) {
        List<StoreModel> stores = new ArrayList<StoreModel>();
        String sql = "with x as(select *,row_number() over(order by createdAt desc)as r from economies.store where name like '%" + query + "%')\n" +
                "select * from x where r between ?*?-? and ?*?";
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
                StoreModel store = new StoreModel();
                store.set_id(rs.getInt("_id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStaffIds(rs.getString("staffIds"));
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
            System.out.println(stores.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return stores;
    }

}
