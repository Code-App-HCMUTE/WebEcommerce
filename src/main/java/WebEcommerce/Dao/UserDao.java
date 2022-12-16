package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.UserModel;

public interface UserDao {
	UserModel login(String email,String password);
    void Register(String email,String phone,String password,String firstName);
    List<UserModel> GetAllUser ();
    void addStaffInStore(UserModel user);
    UserModel getStaffbyPhone(String phone);
    UserModel getUserbyId(int id);
    void Register(UserModel user);
    void update (int id,UserModel user);
    List<UserModel> Search (String query,int size,int index);
    int SearchEmailCount (String query);
    int SearchCount(String query);
    void ResetPassword (int id,String newPass);

    List<UserModel> getUserNew();
}
