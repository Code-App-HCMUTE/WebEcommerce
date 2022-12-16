package WebEcommerce.Model;

import java.util.Date;

public class TransactionModel {
    private int _id;
    private int userId;
    private int storeId;
    private boolean isUp;
    private int amount;
    private Date createdAt;
    private Date updatedAt;

    public TransactionModel() {
    }

    public TransactionModel(int _id, int userId, int storeId, boolean isUp, int amount, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.userId = userId;
        this.storeId = storeId;
        this.isUp = isUp;
        this.amount = amount;
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

    public boolean getIsUp() {
        return isUp;
    }

    public void setIsUp(boolean up) {
        isUp = up;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
