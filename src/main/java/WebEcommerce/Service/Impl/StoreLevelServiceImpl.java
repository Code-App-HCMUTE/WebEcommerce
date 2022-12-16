package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.Impl.StoreLevelDaoImpl;
import WebEcommerce.Dao.StoreLevelDao;
import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Service.StoreLevelService;

import java.util.List;

public class StoreLevelServiceImpl implements StoreLevelService {
    StoreLevelDao storeLevelDao = new StoreLevelDaoImpl();

    @Override
    public List<StoreLevelModel> findAll() {
        return storeLevelDao.findAll();
    }

    @Override
    public StoreLevelModel get(int id) {
        return storeLevelDao.get(id);
    }

    @Override
    public void edit(StoreLevelModel storeLevel) {
        storeLevelDao.edit(storeLevel);
    }

    @Override
    public void insert(StoreLevelModel storeLevel) {
        storeLevelDao.insert(storeLevel);
    }

    @Override
    public void delete(int id) {
        storeLevelDao.delete(id);
    }
}
