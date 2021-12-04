package gr1_cs3.model;

public class Comment {
    private int id;
    private int memberId;
    private int productId;
    private String content;

    public Comment() {
    }

    public Comment(int id, int memberId, int productId, String content) {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
