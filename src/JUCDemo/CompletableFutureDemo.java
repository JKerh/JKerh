package JUCDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        //没有返回值的异步回调
        CompletableFuture<Void> com=CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"=>runAsync");
        });
        System.out.println("1");
        com.get();//获取阻塞的执行结果


        //有返回值的异步回调
        CompletableFuture<Integer> com2=CompletableFuture.supplyAsync(()->{
            int a=10/0;
            return 111;
        });
        System.out.println(com2.whenCompleteAsync(
                (t,u)->{
                    System.out.println("t->"+t);
                    System.out.println("u->"+u);
                }
        ).exceptionally(
                (e)->{
                    e.printStackTrace();
                    System.out.println("e->"+e);
                    return 123;
                }
        ).get());
    }
}
