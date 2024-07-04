package ir.maktab.thredPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Inside Runnable");
                String name = Thread.currentThread().getName();
                System.out.println(name);
            }

        };
        pool.execute(runnable);
        String name = Thread.currentThread().getName();
        System.out.println(name);
        pool.shutdown();
    }
}

