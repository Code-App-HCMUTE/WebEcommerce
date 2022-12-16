package WebEcommerce.Model;

import java.util.Arrays;
import java.util.Date;

public class OrderItemModel {
    private int _id;
    private int orderId;
    private  int productId;
    private Arrays styleValueIds;
    private int count;
    private Date createdAt;
    private Date updatedAt;
    private ProductModel product;

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public OrderItemModel() {
    }

    public OrderItemModel(int _id, int orderId, int productId, Arrays styleValueIds, int count, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.orderId = orderId;
        this.productId = productId;
        this.styleValueIds = styleValueIds;
        this.count = count;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Arrays getStyleValueIds() {
        return styleValueIds;
    }

    public void setStyleValueIds(Arrays styleValueIds) {
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
