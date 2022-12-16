package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.CartDao;
import WebEcommerce.Model.CartModel;
import WebEcommerce.Model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends DBConnection implements CartDao {

    @Override
    public void addToCart(CartModel cart) {
        String sql = "insert into cart (storeId,productId,count,createdAt,updatedAt,userId) values(?,?,?,?,?,?)";
        try{
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,cart.getStoreId());
            ps.setInt(2,cart.getProductId());
            ps.setInt(3,cart.getCount());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(6,cart.getUserId());
            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductModel> ListItemOfUser(int id) {
        String sql = "select product._id ,name,slug,description,price,promotionalPrice,quantity,listImages,count  from cart join product on cart.productId = product._id where userId = "+id;
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
                product.setListImages(rs.getString("listImages"));
                product.setCount(rs.getInt("count"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void update(CartModel cart) {
        String sql = "update  cart set storeId=?, productId=?, count=? ,createdAt=?, updatedAt=?, userId=? where _id=?";
        try{
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,cart.getStoreId());
            ps.setInt(2,cart.getProductId());
            ps.setInt(3,cart.getCount());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(6,cart.getUserId());
            ps.setInt(7,cart.get_id());
            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from cart where userId = "+id;
        try{
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
