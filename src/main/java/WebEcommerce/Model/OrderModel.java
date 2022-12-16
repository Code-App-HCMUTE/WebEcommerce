package WebEcommerce.Model;

import java.util.Date;
import java.util.List;

public class OrderModel {
    private int _id;
    private int userId;
    private int storeId;
    private int deliveryId;
    private int commissionId;
    private String address;
    private String phone;
    private String status;
    private boolean isPaidBefore;
    private int amountFromUser;
    private int amountFromStore;
    private int amountToStore;
    private int amountToGD;
    private List<OrderItemModel> orderItems;

    public List<OrderItemModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemModel> orderItems) {
        this.orderItems = orderItems;
    }

    private Date createdAt;
    private Date updatedAt;

    public OrderModel() {
    }

    public OrderModel(int _id, int userId, int storeId, int deliveryId, int commissionId, String address, String phone, String status, boolean isPaidBefore, int amountFromUser, int amountFromStore, int amountToStore, int amountToGD, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.userId = userId;
        this.storeId = storeId;
        this.deliveryId = deliveryId;
        this.commissionId = commissionId;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.isPaidBefore = isPaidBefore;
        this.amountFromUser = amountFromUser;
        this.amountFromStore = amountFromStore;
        this.amountToStore = amountToStore;
        this.amountToGD = amountToGD;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(int commissionId) {
        this.commissionId = commissionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsPaidBefore() {
        return isPaidBefore;
    }

    public void setIsPaidBefore(boolean isPaidBefore) {
        this.isPaidBefore = isPaidBefore;
    }

    public int getAmountFromUser() {
        return amountFromUser;
    }

    public void setAmountFromUser(int amountFromUser) {
        this.amountFromUser = amountFromUser;
    }

    public int getAmountFromStore() {
        return amountFromStore;
    }

    public void setAmountFromStore(int amountFromStore) {
        this.amountFromStore = amountFromStore;
    }

    public int getAmountToStore() {
        return amountToStore;
    }

    public void setAmountToStore(int amountToStore) {
        this.amountToStore = amountToStore;
    }

    public int getAmountToGD() {
        return amountToGD;
    }

    public void setAmountToGD(int amountToGD) {
        this.amountToGD = amountToGD;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
