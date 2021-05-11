package JUCDemo.ForkJoinPack;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();


    }
    public static void test1(){
        long start=System.currentTimeMillis();
        long sum=0;
        for (long i = 0; i <=10_0000_0000L; i++) {
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("test1:sum="+sum+"----Time:"+(end-start));
    }
    public static void test2()throws Exception{
        long start=System.currentTimeMillis();

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinDemo(0l,10_0000_0000L);
//        forkJoinPool.execute(task);//同步计算
        ForkJoinTask<Long> sub=forkJoinPool.submit(task);//提交任务
        long sum=sub.get();//阻塞等待

        long end=System.currentTimeMillis();
        System.out.println("test2:sum="+sum+"----Time:"+(end-start));
    }


    public static void test3(){
        long start=System.currentTimeMillis();

        //Steam并行流 rangeClose左开右闭
        Long sum=LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        long end=System.currentTimeMillis();
         System.out.println("sum="+sum+"----Time:"+(end-start));
    }

}
