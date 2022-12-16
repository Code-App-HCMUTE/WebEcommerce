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
    public void Register(UserModel user) {
        dao.Register(user);
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

	@Override
	public UserModel getUserbyId(int id) {
		// TODO Auto-generated method stub
		return dao.getUserbyId(id);
	}

    @Override
    public void update(int id,UserModel user) {
        dao.update(id,user);
    }

    @Override
    public void ResetPassword(int id, String newPass) {
        dao.ResetPassword(id,newPass);
    }

    @Override
    public List<UserModel> Search(String query, int size, int index) {
        return dao.Search(query,size,index);
    }

    @Override
    public int SearchEmailCount(String query) {
        return dao.SearchEmailCount(query);
    }

    @Override
    public int SearchCount(String query) {
        return dao.SearchCount(query);
    }

    @Override
    public List<UserModel> getUserNew() {
        return dao.getUserNew();
    }
}
