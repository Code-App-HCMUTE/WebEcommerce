package WebEcommerce.Model;

import java.util.Date;

public class ProductModel {
    private int id;
    private String name;
    private String slug;
    private String description;
    private int price;
    private int promotionalPrice;
    private int quantity;
    private int sold;
    private boolean isActive;
    private boolean isSelling;
	private String listImages;
    private int categoryId;
    private String styleValueIds;
    private int storeId;
    private int rating;
    private Date createdAt;
    private Date updatedAt;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductModel() {
    }

    public ProductModel(int id, String name, String slug, String description, int price, int promotionalPrice, int quantity, int sold, boolean isActive, boolean isSelling, String listImages, int categoryId, String styleValueIds, int storeId, int rating, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.quantity = quantity;
        this.sold = sold;
        this.isActive = isActive;
        this.isSelling = isSelling;
        this.listImages = listImages;
        this.categoryId = categoryId;
        this.styleValueIds = styleValueIds;
        this.storeId = storeId;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(int promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean IsActive) {
        isActive = IsActive;
    }

    public boolean getIsSelling() {
        return isSelling;
    }
    public void setIsSelling(boolean IsSelling) {
        isSelling = IsSelling;
    }

    public String getListImages() {
        return listImages;
    }

    public void setListImages(String listImages) {
        this.listImages = listImages;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getStyleValueIds() {
        return styleValueIds;
    }

    public void setStyleValueIds(String styleValueIds) {
        this.styleValueIds = styleValueIds;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
