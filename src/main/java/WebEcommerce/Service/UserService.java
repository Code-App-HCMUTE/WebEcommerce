package WebEcommerce.Service;

import WebEcommerce.Model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> GetAllUser ();
    void addStaffInStore(UserModel user);
    UserModel getStaffbyPhone(String phone);
    UserModel getUserbyId(int id);
    UserModel login(String email, String password);
    void Register(UserModel user);
    void update (int id,UserModel user);
    void ResetPassword (int id,String newPass);
    List<UserModel> Search (String query,int size,int index);
    int SearchEmailCount(String query);
    int SearchCount(String query);
    List<UserModel> getUserNew();

}
