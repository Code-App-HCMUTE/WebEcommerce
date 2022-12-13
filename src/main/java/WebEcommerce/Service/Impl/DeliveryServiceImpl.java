package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.DeliveryDao;
import WebEcommerce.Dao.Impl.DeliveryDaoImpl;
import WebEcommerce.Model.DeliveryModel;
import WebEcommerce.Service.DeliveryService;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    DeliveryDao deliveryDao = new DeliveryDaoImpl();

    @Override
    public List<DeliveryModel> findAll() {
        return deliveryDao.findAll();
    }

    @Override
    public DeliveryModel get(int id) {
        return null;
    }

    @Override
    public void edit(DeliveryModel delivery) {

    }

    @Override
    public void insert(DeliveryModel delivery) {
        deliveryDao.insert(delivery);
    }

    @Override
    public void delete(int id) {

    }
}
