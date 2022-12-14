package WebEcommerce.Service;

import WebEcommerce.Model.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> findAll();
    CategoryModel get(int id);

    void edit(CategoryModel category);
    void insert(CategoryModel category);
    void delete(int id);
}
