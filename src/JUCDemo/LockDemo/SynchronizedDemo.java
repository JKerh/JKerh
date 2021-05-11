package JUCDemo.LockDemo;

public class SynchronizedDemo {
    public static void main(String[] args) {
//      在获得msg的锁后会自动获得call的锁，必须等线程A全部执行完释放锁后才能执行线程B
        new Thread(()->{ new SynTest().msg(); },"A").start();

        new Thread(()->{ new SynTest().msg(); },"B").start();
    }
}

class SynTest{
    public synchronized void msg(){
        System.out.println(Thread.currentThread().getName()+"->msg");
        call();
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"->call");
    }
}