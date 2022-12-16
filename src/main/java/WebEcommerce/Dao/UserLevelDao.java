package WebEcommerce.Dao;

import WebEcommerce.Model.UserLevelModel;

import java.util.List;

public interface UserLevelDao {
    List<UserLevelModel> findAll();

    UserLevelModel get(int id);

    void edit(UserLevelModel userLevel);

    void insert(UserLevelModel userLevel);

    void delete(int id);
}
