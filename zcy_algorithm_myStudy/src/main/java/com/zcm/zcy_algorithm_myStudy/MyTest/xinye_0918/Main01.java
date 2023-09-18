package com.zcm.zcy_algorithm_myStudy.MyTest.xinye_0918;

import java.util.concurrent.Semaphore;

public class Main01 {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        Thread a = new Thread(new PrintTask('A', semaphoreA, semaphoreB));
        Thread b = new Thread(new PrintTask('B', semaphoreB, semaphoreC));
        Thread c = new Thread(new PrintTask('C', semaphoreC, semaphoreA));

        a.start();;
        b.start();
        c.start();

    }

    public static class PrintTask implements Runnable{

        private char charToPrint;
        private Semaphore currentSemaphore;
        private Semaphore nextSemaphore;

        public PrintTask(char charToPrint, Semaphore currentSemaphore, Semaphore nextSemaphore) {
            this.charToPrint = charToPrint;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run() {
            try {
                for(int i=0;i<10;i++){
                    currentSemaphore.acquire();;
                    System.out.print(charToPrint);
                    nextSemaphore.release();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
