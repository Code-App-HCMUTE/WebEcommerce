package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.CommissionModel;

import java.util.List;

public interface CommissionDao {
    List<CommissionModel> findAll();

    CommissionModel get(int id);

    void edit(CommissionModel product);

    void insert(CommissionModel product);

    void delete(int id);
}
