package JUCDemo.ForkJoinPack;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
//    private volatile  static  int num=0;
//    public synchronized static void add(){//加锁解决问题
//        num++;//不是原子性的操作
//    }
//    使用原子类
    private  volatile  static AtomicInteger num=new AtomicInteger();
    private static void add(){
        num.getAndIncrement();//从底层修改内存的值
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <=10000 ; j++) {
                    new VolatileDemo().add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){//去掉main和gc线程
            Thread.yield();
        }
        System.out.println("num:"+num);
    }
}
