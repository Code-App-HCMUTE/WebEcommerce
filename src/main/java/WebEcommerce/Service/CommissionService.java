package WebEcommerce.Service;
import WebEcommerce.Model.CommissionModel;

import java.util.List;

public interface CommissionService {
    List<CommissionModel> findAll();
    CommissionModel get(int id);
}
