package WebEcommerce.Service;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.TransactionModel;

import java.util.List;

public interface TransactionService {
    List<TransactionModel> findAll();
    TransactionModel get(int id);

    void edit(TransactionModel transaction);
    void insert(TransactionModel transaction);
    void delete(int id);
}
