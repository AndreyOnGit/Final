package lock.gb.ru;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long counter = 0L;
    private Lock lock = new ReentrantLock();

    public void increaseCounter() {
        lock.lock();
        counter++;
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread() + "_counter: " + counter);
        lock.unlock();
    }
}

