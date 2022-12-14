package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.TransactionModel;

public interface TransactionDao {
	List<TransactionModel> getAll();
	void insertTransaction(int sotien);
}
