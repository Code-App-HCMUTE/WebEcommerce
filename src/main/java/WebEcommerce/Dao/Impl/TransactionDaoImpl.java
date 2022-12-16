package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.TransactionDao;
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

        String sql = "SELECT * FROM transaction WHERE _id =?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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
                return transaction;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void edit(TransactionModel transaction) {
        String sql = "UPDATE transaction SET userId=?, storeId=?,isUp=?, amount=?, updatedAt=?  WHERE _id =?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, transaction.getUserId());
            ps.setInt(2, transaction.getStoreId());
            ps.setBoolean(3, transaction.getIsUp());
            ps.setInt(4, transaction.getAmount());
            ps.setDate(5, (Date) transaction.getUpdatedAt());
            ps.setInt(6, transaction.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            ps.setInt(4, transaction.getAmount());
            ps.setDate(5, (Date) transaction.getCreatedAt());
            ps.setDate(6, (Date) transaction.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM transaction WHERE _id =?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int sumMoneyTransaction(int year) {
        int yearF = year;
        int yearL = year + 1;
        String sql = "SELECT * FROM transaction WHERE createdAt BETWEEN CAST('" + yearF + "-01-01' AS DATE) AND CAST('" + yearL + "-01-01' AS DATE)";
        int sum = 0;
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = sum + rs.getInt("amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

}
