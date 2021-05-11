import sun.awt.ConstrainableGraphics;

public class Demo {
    public static void main(String[] args) {

        /**
         * 先执行try代码块中return之前的代码
         * 再执行finall中代码块
         * 最后再执行return返回结果
         */
//        try{
//            System.out.println("运行try代码块");
//            return;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("运行finally代码块");
//        }
        test();
    }

    /**
     *如果由finall代码块，finally代码必然执行，并且是再最后执行
     * 先执行try代码块中return之前的方法
     * 再执行return后面的方法
     * 然后执行finally代码块中的方法
     * 最后把test1()的结果return
     *
     * 如果return一个值，那么这个值的计算逻辑会先执行，也算到return之前的代码中
     * return的作用只负责在最后返回这个值
     * @return
     */
    public static String test(){
        try {
            System.out.println("这是Test的try代码块");
            return Test1();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            System.out.println("这是Test的finally代码块");
        }

    }
    public static String  Test1(){
        System.out.println("Test1");
        return " ";
    }
}
