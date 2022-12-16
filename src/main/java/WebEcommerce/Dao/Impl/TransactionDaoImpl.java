package WebEcommerce.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Model.TransactionModel;
import vn.iotstar.util.Constant;

public class TransactionDaoImpl extends DBConnection implements TransactionDao {

	@Override
    public List<TransactionModel> getAll(int index,int size) {
        List<TransactionModel> transactions = new ArrayList<TransactionModel>();
        //String sql = "SELECT * FROM economies.transaction where economies.transaction.storeId=?";
        String sql = "with x as(select *,row_number() over(order by createdAt desc)as r from economies.transaction where storeId = ? order by _id)\n" +
				"select * from x where r between ?*?-? and ?*?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Constant.idStore);
            ps.setInt(2,index);
			ps.setInt(3,size);
			ps.setInt(4,size-1);
			ps.setInt(5,index);
			ps.setInt(6,size);
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
		String sql = "INSERT INTO transaction (userId, storeId, isUp, amount, createdAt, updatedAt)  VALUES (1,?,0,?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Constant.idStore);
            ps.setInt(2, sotien);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public int countTransaction() {
		String sql = "SELECT count(*) FROM economies.transaction where storeId = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
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
	public int doanhthu(Date date) {
		String sql = "SELECT sum(amount) FROM economies.transaction where storeId = ? and createdAt = ?";
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

}
