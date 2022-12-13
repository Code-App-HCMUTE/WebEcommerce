package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.UserModel;

public interface UserDao {
	UserModel login(String email,String password);
    void Register(String email,String phone,String password,String firstName);
    List<UserModel> GetAllUser ();
    void addStaffInStore(UserModel user);
    UserModel getStaffbyPhone(String phone);
}
