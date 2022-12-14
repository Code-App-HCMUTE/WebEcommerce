package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Dao.Impl.TransactionDaoImpl;
import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	TransactionDao transactionDao=new TransactionDaoImpl();
	@Override
	public List<TransactionModel> getAll() {
		// TODO Auto-generated method stub
		return transactionDao.getAll();
	}
	@Override
	public void insertTransaction(int sotien) {
		transactionDao.insertTransaction(sotien);
	}

}
