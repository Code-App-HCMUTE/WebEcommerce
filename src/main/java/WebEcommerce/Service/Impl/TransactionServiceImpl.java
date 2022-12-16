package WebEcommerce.Service.Impl;

import java.util.Date;
import java.util.List;

import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Dao.Impl.TransactionDaoImpl;
import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	TransactionDao transactionDao=new TransactionDaoImpl();
	@Override
	public List<TransactionModel> getAll(int index,int size) {
		// TODO Auto-generated method stub
		return transactionDao.getAll(index,size);
	}
	@Override
	public void insertTransaction(int sotien) {
		transactionDao.insertTransaction(sotien);
	}
	@Override
	public int countTransaction() {
		// TODO Auto-generated method stub
		return transactionDao.countTransaction();
	}
	@Override
	public int doanhthu(Date date) {
		// TODO Auto-generated method stub
		return transactionDao.doanhthu(date);
	}
    @Override
    public List<TransactionModel> findAll() {
        return transactionDao.findAll();
    }

    @Override
    public TransactionModel get(int id) {
        return transactionDao.get(id);
    }

    @Override
    public void edit(TransactionModel transaction) {
        transactionDao.edit(transaction);
    }

    @Override
    public void insert(TransactionModel transaction) {
        transactionDao.insert(transaction);
    }

    @Override
    public void delete(int id) {
        transactionDao.delete(id);
    }

    @Override
    public int sumMoneyTransaction(int year) {
        return transactionDao.sumMoneyTransaction(year);
    }
}
