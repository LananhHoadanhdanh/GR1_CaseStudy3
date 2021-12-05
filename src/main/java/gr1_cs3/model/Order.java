package gr1_cs3.model;

public class Order {
    private int id;
    private int memberId;
    private int status;

    public Order() {
    }

    public Order(int id, int memberId, int status) {
        this.id = id;
        this.memberId = memberId;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
