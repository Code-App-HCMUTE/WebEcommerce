package WebEcommerce.Model;

import java.util.Date;
import java.util.List;

public class CategoryModel {
    private int id;
    private int cartId;
    private int productId;
    private List<String> styleValueIds;
    private int count;
    private Date createdAt;
    private Date updatedAt;


    public CategoryModel() {
    }

    public CategoryModel(int id, int cartId, int productId, List<String> styleValueIds, int count, Date createdAt, Date updatedAt) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.styleValueIds = styleValueIds;
        this.count = count;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<String> getStyleValueIds() {
        return styleValueIds;
    }

    public void setStyleValueIds(List<String> styleValueIds) {
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
