package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Model.TransactionModel;

public class TransactionDaoImpl extends DBConnection implements TransactionDao {

	@Override
    public List<TransactionModel> getAll() {
        List<TransactionModel> transactions = new ArrayList<TransactionModel>();
        String sql = "SELECT * FROM economies.transaction where economies.transaction.storeId=6";
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
	public void insertTransaction(int sotien) {
		String sql = "INSERT INTO transaction (userId, storeId, isUp, amount, createdAt, updatedAt)  VALUES (1,6,0,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sotien);
            ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
