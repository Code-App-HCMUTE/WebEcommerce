package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends DBConnection implements ProductDao {
	@Override
	public List<ProductModel> findAll() {
		String sql = "SELECT * FROM product";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getBoolean("IsActive"));
				product.setIsSelling(rs.getBoolean("IsSelling"));
				product.setListImages(rs.getString("listImages"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueIds(rs.getString("styleValueIds"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ProductModel get(int id) {
		String sql = "select * from product where _id =" +id;
		try{
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getBoolean("IsActive"));
				product.setIsSelling(rs.getBoolean("IsSelling"));
				product.setListImages(rs.getString("listImages"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueIds(rs.getString("styleValueIds"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				return product;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void edit(ProductModel product) {

	}

	@Override
	public void insert(ProductModel product) {
		String sql = "INSERT INTO product (name, slug, description, price, promotionalPrice, quantity, sold, isActive, isSelling,listImages, categoryId, styleValueIds, storeId, rating, createdAt, updatedAt) VALUES "
				+ "(?,?,?,?,?,?,0,1,1,?,?,?,?,3,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setDouble(5, product.getPromotionalPrice());
			ps.setInt(6, product.getQuantity());
			ps.setString(7, product.getListImages());
			ps.setInt(8, 1);
			ps.setString(9, "1");
			ps.setInt(10, 1);
			ps.setDate(11, (java.sql.Date) product.getCreatedAt());
			ps.setDate(12, (java.sql.Date) product.getUpdatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public List<ProductModel> search(String query,int size,int index) {
		String sql = "with x as(select *,row_number() over(order by createdAt desc)as r from product where name like '%"+query+"%')\n" +
				"select * from x where r between ?*?-? and ?*?";
		List<ProductModel> products = new ArrayList<ProductModel>();
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
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getBoolean("IsActive"));
				product.setIsSelling(rs.getBoolean("IsSelling"));
				product.setListImages(rs.getString("listImages"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueIds(rs.getString("styleValueIds"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public int SearchCount(String query) {
		String sql = "SELECT * FROM product where name like '%"+query+"%'";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getBoolean("IsActive"));
				product.setIsSelling(rs.getBoolean("IsSelling"));
				product.setListImages(rs.getString("listImages"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueIds(rs.getString("styleValueIds"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products.size();
	}

}
