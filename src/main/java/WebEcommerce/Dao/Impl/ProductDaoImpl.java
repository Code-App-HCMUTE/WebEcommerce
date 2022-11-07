package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl extends DBConnection implements ProductDao
{
    @Override
    public List<ProductModel> findAll() {
        List<ProductModel> products = new ArrayList<ProductModel>();
        String sql = "SELECT * FROM product";
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
//                product.setListImages(rs.getArray("listImages"));
                product.setCategoryId(rs.getInt("categoryId"));
//                product.setStyleValueIds((Arrays) rs.getArray("styleValueIds"));
                product.setStoreId(rs.getInt("storeId"));
                product.setRating(rs.getInt("rating"));
                product.setCreatedAt(rs.getDate("createdAt"));
                product.setUpdatedAt(rs.getDate("updatedAt"));

                products.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductModel get(int id) {
        return null;
    }

    @Override
    public void edit(ProductModel product) {
        String sql = "UPDATE Category SET categoryName = ?,images = ?, status=? WHERE categoryId = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.setString(2,product.getName());

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void insert(ProductModel product) {
        String sql = "INSERT INTO economies.product ( name, description, price, promotionalPrice, quantity, sold, categoryId, storeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2,product.getDescription());
            ps.setDouble(3,product.getPrice());
            ps.setDouble(4,product.getPromotionalPrice());
            ps.setInt(5,product.getQuantity());
            ps.setInt(6,product.getSold());
            ps.setInt(7, product.getCategoryId());
            ps.setInt(8,product.getStoreId());


            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
