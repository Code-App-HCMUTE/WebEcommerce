package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.UserLevelDaoImpl;
import WebEcommerce.Dao.UserLevelDao;
import WebEcommerce.Model.UserLevelModel;
import WebEcommerce.Service.UserLevelService;

import java.util.List;

public class UserLevelServiceImpl implements UserLevelService {
    UserLevelDao userLevelDao = new UserLevelDaoImpl();
    @Override
    public List<UserLevelModel> findAll() {
        return userLevelDao.findAll();
    }

    @Override
    public UserLevelModel get(int id) {
        return userLevelDao.get(id);
    }

    @Override
    public void edit(UserLevelModel userLevelModel) {
        userLevelDao.edit(userLevelModel);
    }

    @Override
    public void insert(UserLevelModel userLevelModel) {
        userLevelDao.insert(userLevelModel);
    }

    @Override
    public void delete(int id) {
        userLevelDao.delete(id);
    }
}
