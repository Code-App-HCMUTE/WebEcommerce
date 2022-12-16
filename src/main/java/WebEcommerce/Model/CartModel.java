package WebEcommerce.Model;

import java.util.Date;

public class CartModel {
    private int _id;

    private int userId;
    private int storeId;
    private int productId;
    private int styleValueIds;
    private int count;
    private Date createdAt;
    private Date updatedAt;

    public CartModel() {
    }

    public CartModel(int _id, int userId, int storeId, int productId, int styleValueIds, int count, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.userId = userId;
        this.storeId = storeId;
        this.productId = productId;
        this.styleValueIds = styleValueIds;
        this.count = count;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStyleValueIds() {
        return styleValueIds;
    }

    public void setStyleValueIds(int styleValueIds) {
        this.styleValueIds = styleValueIds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
