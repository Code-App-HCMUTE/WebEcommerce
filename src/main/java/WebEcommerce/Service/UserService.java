package WebEcommerce.Service;

import WebEcommerce.Model.UserModel;

import java.util.List;

public interface UserService {
    UserModel login(String email, String password);
    void Register(String email,String phone,String password,String firstName);
    List<UserModel> GetAllUser ();
}
