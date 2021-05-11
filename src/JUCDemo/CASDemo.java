package JUCDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2020);
        /**CAS:compareAndSet
         * 如果期望值达到了就更新，否则就不更新
         *    public final boolean compareAndSet(int expect, int update) {
         *         return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
         *     }
         */
        atomicInteger.compareAndSet(2020, 2021);
        System.out.println(atomicInteger);

        atomicInteger.compareAndSet(2021, 2020);
        System.out.println(atomicInteger);

        atomicInteger.compareAndSet(2020, 1999);
        System.out.println(atomicInteger);
    }
}
