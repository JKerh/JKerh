package JUCDemo.SingleDemo;

public class Lazy {
    private volatile static Lazy lazy;
    private Lazy(){
    }
    // DCL懒汉式
    public  static  Lazy getInstance(){
        if (lazy==null){
            synchronized (Lazy.class){
                if(lazy==null){
                    lazy=new Lazy();//不是一个原子性的操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法
                     * 3.把这个对象指向这个空间
                     *
                     * 线程执行不一定会严格按照123的顺序执行
                     * A和B同时操作，B线程进入的时候lazy！=null，会直接返回lazy
                     */
                }
            }
        }
        return  lazy;//
    }
}
