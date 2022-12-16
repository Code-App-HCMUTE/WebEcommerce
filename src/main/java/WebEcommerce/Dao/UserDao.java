package WebEcommerce.Dao;

import WebEcommerce.Model.UserModel;

import java.util.List;

public interface UserDao {
    UserModel login(String email,String password);
    void Register(UserModel user);
    List<UserModel> GetAllUser ();
    void update (int id,UserModel user);
    List<UserModel> Search (String query,int size,int index);
    int SearchEmailCount (String query);
    int SearchCount(String query);
    void ResetPassword (int id,String newPass);

    List<UserModel> getUserNew();
}
