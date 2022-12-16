package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.StyleDaoImpl;
import WebEcommerce.Dao.StyleDao;
import WebEcommerce.Model.StyleModel;
import WebEcommerce.Service.StyleService;

import java.util.List;

public class StyleServiceImpl implements StyleService {
    StyleDao styleDao = new StyleDaoImpl();

    @Override
    public List<StyleModel> findAll() {
        return styleDao.findAll();
    }

    @Override
    public StyleModel get(int id) {
        return styleDao.get(id);
    }

    @Override
    public void edit(StyleModel style) {
        styleDao.edit(style);
    }

    @Override
    public void insert(StyleModel style) {
        styleDao.insert(style);
    }

    @Override
    public void delete(int id) {
        styleDao.delete(id);
    }
}
