package WebEcommerce.Model;

import java.util.Date;
import java.util.List;

public class CategoryModel {
    private int id;
    private int cartId;
    private String name;
    private String slug;
    private String image;
    private boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    public CategoryModel() {
    }
    public CategoryModel(int id, int cartId, String name, String slug, String image, boolean isDeleted, Date createdAt, Date updatedAt) {
        this.id = id;
        this.cartId = cartId;
        this.name = name;
        this.slug = slug;
        this.image = image;
        this.isDeleted = isDeleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
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
