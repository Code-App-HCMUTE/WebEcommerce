package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;

import java.util.List;

public interface CategoryDao {
    List<CategoryModel> findAll();

    CategoryModel get(int id);

    void edit(CategoryModel product);

    void insert(CategoryModel product);

    void delete(int id);
}
