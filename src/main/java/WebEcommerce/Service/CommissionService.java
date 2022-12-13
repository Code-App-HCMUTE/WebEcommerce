package WebEcommerce.Service;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.CommissionModel;

import java.util.List;

public interface CommissionService {
    List<CommissionModel> findAll();
    CommissionModel get(int id);

    void edit(CommissionModel commission);
    void insert(CommissionModel commission);
    void delete(int id);
}
