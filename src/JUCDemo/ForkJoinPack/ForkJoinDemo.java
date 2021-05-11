package JUCDemo.ForkJoinPack;


import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    private long start;
    private long end;

    private long temp=10000l;



    @Override
    protected Long compute() {
        if ((end-start)<temp){
            long sum=0;
            for (int i = 0; i <=100000; i++) {
                sum+=i;
            }
            return  sum;
        }else{
            long mid=(end+start)/2;
            ForkJoinDemo fork1=new ForkJoinDemo(start,mid);
            fork1.fork();//拆分任务,把任务1压入线程队列
            ForkJoinDemo fork2=new ForkJoinDemo(mid+1,end);
            fork2.fork();

            return fork1.join()+ fork2.join();
        }

    }
}
