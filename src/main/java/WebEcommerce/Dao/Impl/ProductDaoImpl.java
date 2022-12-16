package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;
import vn.iotstar.util.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDaoImpl extends DBConnection implements ProductDao {
	
	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM economies.product where storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
		String sql = "SELECT * FROM economies.product where _id = ? and storeId = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void edit(ProductModel product) {
		String sql = "UPDATE product SET name = ?,slug = ?, description = ?, price = ?, promotionalPrice = ?, quantity = ?, listImages = ?, isSelling = ?, categoryId = ? , updatedAt = ? WHERE _id = ? and storeId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getName());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getPromotionalPrice());
			ps.setInt(6, product.getQuantity());
			ps.setString(7, product.getListImages());
			ps.setBoolean(8, product.getIsSelling());
			ps.setInt(9, product.getCategoryId());
			ps.setDate(10, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(11, product.getId());
			ps.setInt(12, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getPromotionalPrice());
			ps.setInt(6, product.getQuantity());
			ps.setString(7, product.getListImages());
			ps.setInt(8, product.getCategoryId());
			ps.setString(9, "1");
			ps.setInt(10, Constant.idStore);
			ps.setDate(11, (java.sql.Date) product.getCreatedAt());
			ps.setDate(12, (java.sql.Date) product.getUpdatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE _id = ? and storeId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductModel> getAllProductIsActive() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product where isActive = 1 and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public List<ProductModel> getAllProductUnActive() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product where isActive = 0 and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public List<ProductModel> getAllProductNoQuantity() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product where quantity = 0 and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public List<ProductModel> getAllProductQuantity() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product where quantity > 0 and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public List<ProductModel> searchProduct(String txtSearch) {
		List<ProductModel> products = new ArrayList<ProductModel>();
        String sql = "SELECT * FROM product where name like ? and storeId = ? order by _id";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+txtSearch+"%");
            ps.setInt(2, Constant.idStore);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public List<ProductModel> search(String query, int size, int index) {
		String sql = "with x as(select *,row_number() over(order by createdAt desc)as r from product where storeId = ? and name like '%"+query+"%')\n" +
				"select * from x where r between ?*?-? and ?*?";
		List<ProductModel> products = new ArrayList<ProductModel>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Constant.idStore);
			ps.setInt(2,index);
			ps.setInt(3,size);
			ps.setInt(4,size-1);
			ps.setInt(5,index);
			ps.setInt(6,size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
	public int CountProduct(String txt) {
		String sql = "SELECT count(*) FROM economies.product where storeId = ? and economies.product.name like ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ps.setString(2, "%"+txt+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1)/10; 
            }
        } catch (Exception e) {	
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int countProductByDate(Date date) {
		String sql = "SELECT count(*) FROM economies.product where storeId = ? and createdAt = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ps.setDate(2, (java.sql.Date) date);
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
	public int countAll() {
		String sql = "SELECT count(*) FROM economies.product where storeId = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
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
	public ProductModel getTop1Sold() {
		String sql = "SELECT * FROM economies.product where storeId = ? ORDER BY sold DESC limit 1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription((rs.getString("description")));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
