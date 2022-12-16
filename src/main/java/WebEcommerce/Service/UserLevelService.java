package WebEcommerce.Service;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.UserLevelModel;

import java.util.List;

public interface UserLevelService {
    List<UserLevelModel> findAll();
    UserLevelModel get(int id);

    void edit(UserLevelModel category);
    void insert(UserLevelModel category);
    void delete(int id);
}
