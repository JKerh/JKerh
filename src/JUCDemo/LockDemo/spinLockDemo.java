package JUCDemo.LockDemo;


import java.util.concurrent.atomic.AtomicReference;

public class spinLockDemo {
    AtomicReference<Thread> atomicReference=new AtomicReference();
    public  void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"-->myLock");
        while (!atomicReference.compareAndSet(null,thread)){ }
    }

    public void myUnlock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"-->myUnlock");
        while (!atomicReference.compareAndSet(thread,null)){ }
    }
}