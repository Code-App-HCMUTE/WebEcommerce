package WebEcommerce.Dao;

import WebEcommerce.Model.CommissionModel;

import java.util.List;

public interface CommissionDao {
    List<CommissionModel> findAll();
    CommissionModel get(int id);
}
