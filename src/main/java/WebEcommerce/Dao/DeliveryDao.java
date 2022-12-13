package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.DeliveryModel;

import java.util.List;

public interface DeliveryDao {
    List<DeliveryModel> findAll();

    DeliveryModel get(int id);

    void edit(DeliveryModel delivery);

    void insert(DeliveryModel delivery);

    void delete(int id);
}
