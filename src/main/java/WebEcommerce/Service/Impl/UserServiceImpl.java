package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.UserDaoImpl;
import WebEcommerce.Dao.UserDao;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public UserModel login(String email, String password) {
        return dao.login(email,password);
    }

    @Override
    public void Register(String email, String phone, String password, String firstName) {
        dao.Register(email,phone,password,firstName);
    }

    @Override
    public List<UserModel> GetAllUser() {
        return dao.GetAllUser();
    }

	@Override
	public void addStaffInStore(UserModel user) {
		dao.addStaffInStore(user);
	}

	@Override
	public UserModel getStaffbyPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.getStaffbyPhone(phone);
	}
}