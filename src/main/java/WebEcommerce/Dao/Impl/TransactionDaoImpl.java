package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.TransactionModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl extends DBConnection implements TransactionDao {
    @Override
    public List<TransactionModel> findAll() {
        List<TransactionModel> transactions = new ArrayList<TransactionModel>();
        String sql = "SELECT * FROM transaction";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TransactionModel transaction = new TransactionModel();
                transaction.setId(rs.getInt("_id"));
                transaction.setUserId(rs.getInt("userId"));
                transaction.setStoreId(rs.getInt("storeId"));
                transaction.setIsUp(rs.getBoolean("isUp"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setCreatedAt(rs.getDate("createdAt"));
                transaction.setUpdatedAt(rs.getDate("updatedAt"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public TransactionModel get(int id) {
        return null;
    }

    @Override
    public void edit(TransactionModel transaction) {

    }

    @Override
    public void insert(TransactionModel transaction) {
        String sql = "INSERT INTO transaction (userId, storeId,isUp, amount, createdAt, updatedAt)  VALUES (?,?,?,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, transaction.getUserId());
            ps.setInt(2, transaction.getStoreId());
            ps.setBoolean(3, transaction.getIsUp());
            ps.setDouble(4, transaction.getAmount());
            ps.setDate(5, (Date) transaction.getCreatedAt());
            ps.setDate(6, (Date) transaction.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
