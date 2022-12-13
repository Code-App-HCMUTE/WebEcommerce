package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.StyleDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StyleDaoImpl extends DBConnection implements StyleDao {
    @Override
    public List<StyleModel> findAll() {
        List<StyleModel> styles = new ArrayList<StyleModel>();
        String sql = "SELECT * FROM style";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StyleModel style = new StyleModel();
                style.setId(rs.getInt("_id"));
                style.setName(rs.getString("name"));
                style.setCaId(rs.getInt("categoryIds"));
                style.setIsDelete(rs.getBoolean("isDeleted"));
                style.setCreatedAt(rs.getDate("createdAt"));
                style.setUpdatedAt(rs.getDate("updateAt"));
                styles.add(style);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return styles;
    }

    @Override
    public CategoryModel get(int id) {
        return null;
    }

    @Override
    public void edit(StyleModel style) {

    }

    @Override
    public void insert(StyleModel style) {
        String sql = "INSERT INTO style (name, categoryIds, isDeleted, createdAt, updateAt)  VALUES (?,?,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, style.getName());
            ps.setInt(2, style.getCaId());
            ps.setBoolean(3,style.getIsDelete());
            ps.setDate(4, (Date) style.getCreatedAt());
            ps.setDate(5, (Date) style.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
