package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.CommissionDao;
import WebEcommerce.Dao.Impl.CommissionDaoImpl;
import WebEcommerce.Model.CommissionModel;
import WebEcommerce.Service.CommissionService;

import java.util.List;

public class CommissionServiceImpl implements CommissionService {
    CommissionDao commissionDao = new CommissionDaoImpl();
    @Override
    public List<CommissionModel> findAll() {
        return commissionDao.findAll();
    }

    @Override
    public CommissionModel get(int id) {
        return commissionDao.get(id);
    }

    @Override
    public void edit(CommissionModel commission) {
        commissionDao.edit(commission);
    }

    @Override
    public void insert(CommissionModel commission) {
        commissionDao.insert(commission);
    }

    @Override
    public void delete(int id) {
        commissionDao.delete(id);
    }
}
