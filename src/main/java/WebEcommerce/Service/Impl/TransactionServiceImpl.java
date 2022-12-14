package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.TransactionDaoImpl;
import WebEcommerce.Dao.TransactionDao;
import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    TransactionDao transactionDao = new TransactionDaoImpl();
    @Override
    public List<TransactionModel> findAll() {
        return transactionDao.findAll();
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
        transactionDao.insert(transaction);
    }

    @Override
    public void delete(int id) {

    }
}
