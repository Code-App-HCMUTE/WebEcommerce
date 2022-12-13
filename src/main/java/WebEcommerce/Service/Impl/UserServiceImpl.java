package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.UserDaoimpl;
import WebEcommerce.Dao.UserDao;
import WebEcommerce.Model.StyleModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao user =  new UserDaoimpl();
    @Override
    public List<UserModel> findAll() {
        return user.findAll();
    }

    @Override
    public UserModel get(int id) {
        return null;
    }

    @Override
    public void edit(UserModel user) {

    }

    @Override
    public void insert(UserModel user) {

    }

    @Override
    public void delete(int id) {

    }
}
