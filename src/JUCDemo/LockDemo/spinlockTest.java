package JUCDemo.LockDemo;

import java.util.concurrent.TimeUnit;

public class spinlockTest {
    public static void main(String[] args) {
        spinLockDemo lock=new spinLockDemo();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T1").start();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T2").start();

    }
}
