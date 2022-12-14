package WebEcommerce.Service;

import java.util.List;

import WebEcommerce.Model.TransactionModel;

public interface TransactionService {
	List<TransactionModel> getAll();
	void insertTransaction(int sotien);
}
