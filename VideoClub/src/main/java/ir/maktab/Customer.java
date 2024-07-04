package ir.maktab;

public class Customer {
    private String  name;
    private Video[] rentedVideo;
    private int count;

    public Customer(String name, int maxVideo) {
        this.name = name;
        rentedVideo = new Video[maxVideo];
        count = 0;
    }
    public void rentVideo(Video video){
        if(count < rentedVideo.length){
            rentedVideo[count] = video;
            count++;
        }
    }
    public double calBill(){
        double total = 0;
        for (int i = 0; i < count; i++) {
            double rentPrice = rentedVideo[i].getPrice();
            int rentDays = rentedVideo[i].getAllowCountDate();
            total += rentPrice;
            if(rentDays > 0){
                total += rentedVideo[i].getPenalty()*rentDays;
            }
        }
        return total;
    }
}
