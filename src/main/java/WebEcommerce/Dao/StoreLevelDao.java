package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StoreLevelModel;

import java.util.List;

public interface StoreLevelDao {
    List<StoreLevelModel> findAll();

    StoreLevelModel get(int id);

    void edit(StoreLevelModel storeLevel);

    void insert(StoreLevelModel storeLevel);

    void delete(int id);
}
