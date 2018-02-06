package com.jackzhang.btrace;

public class TreadMain {

    public static void main(String args[]) throws InterruptedException {
        int i = 0;
        while (true) {
            i ++;
            newRun(i + "");
            Thread.sleep(5000);
        }

    }

    private static String newRun(String name) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("hello btrace");
                return ;
            }
        }, name);
        t1.start();
        return name;
    }
}
