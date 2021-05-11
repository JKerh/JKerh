package JUCDemo.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {

        new Thread(()->{ new LockTest().msg(); },"A").start();

        new Thread(()->{ new LockTest().msg(); },"B").start();
    }
}

class LockTest{
    Lock lock=new ReentrantLock();

    public  void msg(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"->msg");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"->call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
