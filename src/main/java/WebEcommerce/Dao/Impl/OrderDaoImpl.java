package WebEcommerce.Dao.Impl;

import WebEcommerce.Connection.DBConnection;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Model.OrderModel;
import vn.iotstar.util.Constant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DBConnection implements OrderDao {
    @Override
    public List<OrderModel> findAll() {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        String sql = "SELECT * FROM economies.order";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setId(rs.getInt("_id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setCommissionId(rs.getInt("commissionId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
                order.setAmountFromUser(rs.getInt("amountFromUser"));
                order.setAmountFromStore(rs.getInt("amountFromStore"));
                order.setAmountToStore(rs.getInt("amountToStore"));
                order.setAmountToGD(rs.getInt("amountToGD"));
                order.setCreatedAt(rs.getDate("createdAt"));
                order.setUpdatedAt(rs.getDate("updatedAt"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel get(int id) {
        return null;
    }


    @Override
    public void insert(OrderModel order) {
        String sql = "INSERT INTO `economies`.`order` (`userId`, `storeId`, `deliveryId`, `commissionId`, `address`, `phone`, `status`, `isPaidBefore`, `amountFromUser`, `amountFromStore`, `amountToStore`, `amountToGD`, `createdAt`, `updatedAt`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getStoreId());
            ps.setInt(3, order.getDeliveryId());
            ps.setInt(4, order.getCommissionId());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getPhone());
            ps.setString(7, order.getStatus());
            ps.setBoolean(8, order.getIsPaidBefore());
            ps.setInt(9, order.getAmountFromUser());
            ps.setInt(10, order.getAmountFromStore());
            ps.setInt(11, order.getAmountToStore());
            ps.setInt(12, order.getAmountToGD());
            ps.setDate(13, (Date) order.getCreatedAt());
            ps.setDate(14, (Date) order.getUpdatedAt());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(OrderModel order) {
        String sql = "UPDATE `economies`.`order` SET `userId`=?, `storeId`=?, `deliveryId`=?, `commissionId`=?, `address`=?, `phone`=?, `status`=?, `isPaidBefore`=?, `amountFromUser`=?, `amountFromStore`=?, `amountToStore`=?, `amountToGD`=?, `updatedAt`=? " +
                "WHERE _id = ?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getStoreId());
            ps.setInt(3, order.getDeliveryId());
            ps.setInt(4, order.getCommissionId());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getPhone());
            ps.setString(7, order.getStatus());
            ps.setBoolean(8, order.getIsPaidBefore());
            ps.setInt(9, order.getAmountFromUser());
            ps.setInt(10, order.getAmountFromStore());
            ps.setInt(11, order.getAmountToStore());
            ps.setInt(12, order.getAmountToGD());
            ps.setDate(13, (Date) order.getUpdatedAt());
            ps.setInt(14, order.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<OrderModel> userOrder(int userId) {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        String sql = "SELECT * FROM `economies`.`order` where userId = " + userId;
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setId(rs.getInt("_id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setCommissionId(rs.getInt("commissionId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
                order.setAmountFromUser(rs.getInt("amountFromUser"));
                order.setAmountFromStore(rs.getInt("amountFromStore"));
                order.setAmountToStore(rs.getInt("amountToStore"));
                order.setAmountToGD(rs.getInt("amountToGD"));
                order.setCreatedAt(rs.getDate("createdAt"));
                order.setUpdatedAt(rs.getDate("updatedAt"));

                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public int LastInserted() {
        String sql = "SELECT _id FROM economies.order ORDER BY _id DESC LIMIT 1";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                return rs.getInt("_id");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int CountOrder(int year) {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        int yearF= year;
        int yearL = year + 1;
        String sql = "SELECT * FROM `economies`.`order` WHERE createdAt BETWEEN CAST('"+yearF+"-01-01' AS DATE) AND CAST('"+yearL+"-01-01' AS DATE);";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setId(rs.getInt("_id"));
                order.setUserId(rs.getInt("userId"));
                order.setStoreId(rs.getInt("storeId"));
                order.setDeliveryId(rs.getInt("deliveryId"));
                order.setCommissionId(rs.getInt("commissionId"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setStatus(rs.getString("status"));
                order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
                order.setAmountFromUser(rs.getInt("amountFromUser"));
                order.setAmountFromStore(rs.getInt("amountFromStore"));
                order.setAmountToStore(rs.getInt("amountToStore"));
                order.setAmountToGD(rs.getInt("amountToGD"));
                order.setCreatedAt(rs.getDate("createdAt"));
                order.setUpdatedAt(rs.getDate("updatedAt"));
                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders.size();
    }

    @Override
    public int SumMoneySell(int year) {
        int yearF= year;
        int yearL = year + 1;
        String sql = "SELECT * FROM `economies`.`order` WHERE createdAt BETWEEN CAST('"+yearF+"-01-01' AS DATE) AND CAST('"+yearL+"-01-01' AS DATE)";
        System.out.println(sql);

        int sum = 0;
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum += rs.getInt("amountFromUser");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
	@Override
	public List<OrderModel> getAlLOrder() {
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM economies.order where storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<OrderModel> getAllOrderCancel() {
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM economies.order where economies.order.status = ? and storeId = ? order by _id";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "cancelled");
			ps.setInt(2, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public int countAll() {
		String sql = "SELECT count(*) FROM economies.order where storeId = ?";
		try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
	}

    @Override
    public int countOrderByDate(java.util.Date date) {
        String sql = "SELECT count(*) FROM economies.order where storeId = ? and createdAt = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Constant.idStore);
            ps.setDate(2, (java.sql.Date) date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



	@Override
	public OrderModel getOrderById(int id) {
		String sql = "SELECT * FROM economies.order where economies.order._id = ? and storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, Constant.idStore);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateStatus(String status,int orderId) {
		String sql = "UPDATE economies.order SET status = ?, updatedAt = ? WHERE _id = ? and storeId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(3, orderId);
			ps.setInt(4, Constant.idStore);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
