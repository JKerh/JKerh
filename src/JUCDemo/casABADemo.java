package JUCDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class casABADemo {
    public static void main(String[] args) {
        /**
         * Integer使用了缓存机制，默认范围-127~128，可以使用静态工厂的valueof获取实例对象
         * 不使用new方法，因为new方法必然会创建新的对象分配新的空间；valueof使用的是缓存
         */

        //通常的业务泛型使用的是一个具体的对象，不是包装类(使用注意对象的引用问题)
        AtomicStampedReference<Integer> atomicReference=new AtomicStampedReference(1,1);

        new Thread(()->{
            System.out.println("a1->"+atomicReference.getStamp());
            System.out.println(atomicReference.compareAndSet(1, 2,
                    atomicReference.getStamp(), atomicReference.getStamp() + 1));

            System.out.println("a2->"+atomicReference.getStamp());
            System.out.println(atomicReference.compareAndSet(2, 1,
                    atomicReference.getStamp(), atomicReference.getStamp() + 1));

            System.out.println("a3->"+atomicReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        ,"A").start();

        new Thread(()->{
            int stamp=atomicReference.getStamp();
            System.out.println("b1->"+stamp);
            System.out.println(atomicReference.compareAndSet(1, 6,
                    atomicReference.getStamp(), atomicReference.getStamp() + 1));
            System.out.println("b2->"+atomicReference.getStamp());

        },"B").start();
    }
}
