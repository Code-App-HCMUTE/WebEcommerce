package WebEcommerce.Dao;

import java.util.Date;
import java.util.List;

import WebEcommerce.Model.TransactionModel;

public interface TransactionDao {
	List<TransactionModel> getAll(int index,int size);
	void insertTransaction(int sotien);
	int countTransaction();
	int doanhthu(Date date);
    List<TransactionModel> findAll();

    TransactionModel get(int id);

    void edit(TransactionModel transaction);

    void insert(TransactionModel transaction);

    void delete(int id);
    int sumMoneyTransaction(int year);
}
