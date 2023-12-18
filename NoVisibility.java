package com.ex.multithreading.VisibilityofDatainMultiThreading;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class RedarThread extends Thread {

        public void run() {
            while (!ready)
                Thread.yield();
            for (int i = 0; i < number; i++)
                try {
                    Thread.sleep(500);
                    System.out.println(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        new RedarThread().start();
        number = 10000;
        ready = true;
    }
}
