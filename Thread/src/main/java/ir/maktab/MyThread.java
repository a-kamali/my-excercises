package ir.maktab;

public class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // توقف اجرای Thread برای 1 ثانیه
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
