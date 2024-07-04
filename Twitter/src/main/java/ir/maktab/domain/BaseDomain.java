package ir.maktab.domain;

public abstract class BaseDomain {

    private int id;

    public BaseDomain() {
    }

    public BaseDomain(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
