package ir.maktab;

import java.util.*;

public class MyClass {


    public static void main(String[] args) {
        int count = 20;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Sleep Time of Thread in Milli Second");
        int difference = scanner.nextInt();

        Thread clockThread = new Thread();
        while(count > 0){
            java.time.LocalTime currentTime = java.time.LocalTime.now();
            System.out.println(currentTime);
            count--;

            try {
                Thread.sleep(difference);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}









