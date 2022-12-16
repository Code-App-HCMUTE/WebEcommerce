package WebEcommerce.Service;

import java.util.Date;
import java.util.List;

import WebEcommerce.Model.TransactionModel;

public interface TransactionService {
	List<TransactionModel> getAll(int index,int size);
	void insertTransaction(int sotien);
	int countTransaction();
	int doanhthu(Date date);
}
