package gr1_cs3.model;

public class Invoice {
    private int idMember;
    private int idOrder;
    private int status;
    private int productQuantity;
    private int idProduct;
    private int price;

    public int getPrice() {
        return price;
    }

    public Invoice(int idMember, int status, int productQuantity, int price) {
        this.idMember = idMember;
        this.status = status;
        this.productQuantity = productQuantity;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Invoice(int idMember) {
        this.idMember = idMember;
    }

    public Invoice() {
    }

    public Invoice(int idMember, int idOrder, int status, int productQuantity, int idProduct) {
        this.idMember = idMember;
        this.idOrder = idOrder;
        this.status = status;
        this.productQuantity = productQuantity;
        this.idProduct = idProduct;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
