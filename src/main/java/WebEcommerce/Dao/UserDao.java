package WebEcommerce.Dao;

import WebEcommerce.Model.UserModel;

import java.util.List;

public interface UserDao {
    UserModel login(String email,String password);
    void Register(String email,String phone,String password,String firstName);
    List<UserModel> GetAllUser ();

}
