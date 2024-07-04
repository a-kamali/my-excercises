package ir.maktab;

public class MyTheread extends Thread{

    int count = 0;
    @Override
    public void run() {
//        for (int i = 0; i < 5; i++) {
//        System.out.println("Hello World! " +
//                "Thread Name: " +currentThread().getName() +
//                " Thread ID:" + "  " +currentThread().getId()+
//                "State "+ currentThread().getState());
//        }
        count++;
        System.out.println(count);
    }
}
