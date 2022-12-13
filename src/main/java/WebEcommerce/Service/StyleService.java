package WebEcommerce.Service;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;

import java.util.List;

public interface StyleService {
    List<StyleModel> findAll() ;

    StyleModel get(int id);

    void edit(StyleModel style);
    void insert(StyleModel style);
    void delete(int id);
}
