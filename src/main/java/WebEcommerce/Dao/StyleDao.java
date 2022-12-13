package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;

import java.util.List;

public interface StyleDao {
    List<StyleModel> findAll();

    CategoryModel get(int id);

    void edit(StyleModel style);

    void insert(StyleModel style);

    void delete(int id);
}
