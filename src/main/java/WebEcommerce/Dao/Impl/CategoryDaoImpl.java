package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.CategoryDao;
import WebEcommerce.Model.CategoryModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends DBConnection implements CategoryDao {
    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> categorys = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setId(rs.getInt("_id"));
                category.setName(rs.getString("name"));
                category.setSlug(rs.getString("slug"));
                category.setCartId(rs.getInt("categoryId"));
                category.setImage(rs.getString("image"));
                category.setIsDeleted(rs.getBoolean("isDeleted"));
                category.setCreatedAt(rs.getDate("createdAt"));
                category.setUpdatedAt(rs.getDate("updatedAt"));
                categorys.add(category);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return categorys;
    }
    @Override
    public CategoryModel get(int id) {
        return null;
    }

    @Override
    public void edit(CategoryModel product) {

    }

    @Override
    public void insert(CategoryModel category) {
        String sql =  "INSERT INTO category (name, slug, categoryId, image, isDeleted, createdAt, updatedAt)  VALUES (?,?,?,?,?,?,?)";
        try{
            Connection con  =  super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2, category.getSlug());
            ps.setInt(3,category.getCartId());
            ps.setString(4, category.getName());
            ps.setBoolean(5, category.getIsDeleted());
            ps.setDate(6, (Date) category.getCreatedAt());
            ps.setDate(7, (Date) category.getUpdatedAt());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
