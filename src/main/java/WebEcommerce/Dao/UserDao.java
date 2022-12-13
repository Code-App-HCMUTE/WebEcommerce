package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;
import WebEcommerce.Model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> findAll();

    UserModel get(int id);

    void edit(UserModel user);

    void insert(UserModel user);

    void delete(int id);
}
