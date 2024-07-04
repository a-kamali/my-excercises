package ir.maktab;

public class Video {
    private String title;
    private TypeVideo type;
    private int allowCountDate;
    private double price;
    private double penalty;

    public Video(String title, TypeVideo type, double price, double penalty) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.penalty = penalty;
        if(type.equals(TypeVideo.Normal)){
            this.allowCountDate = 2;
        } else if (type.equals(TypeVideo.Children)) {
            this.allowCountDate = 3;
        } else if (type.equals(TypeVideo.New)) {
            this.allowCountDate = 1;
        }
    }

    public double getPenalty() {
        return penalty;
    }

    public int getAllowCountDate() {
        return allowCountDate;
    }

    public double getPrice() {
        return price;
    }
}
