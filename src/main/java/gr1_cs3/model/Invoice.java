package gr1_cs3.model;

public class Invoice {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int categoryId;
    private String image;
    private int brandId;
    private String description;
    private int product_quantity;
    private int re;



    public Invoice(int id, String name, int price, int quantity, int categoryId, String image, int brandId, String description, int product_quantity, int re) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.image = image;
        this.brandId = brandId;
        this.description = description;
        this.product_quantity = product_quantity;
        this.re = re;
    }
    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }
    public Invoice(int id, String name, int price, int quantity, int categoryId, String image, int brandId, String description, int product_quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.image = image;
        this.brandId = brandId;
        this.description = description;
        this.product_quantity = product_quantity;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
}
