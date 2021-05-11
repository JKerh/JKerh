package JUCDemo.SingleDemo;

public class HolderDemo {

    private   HolderDemo(){
    }

    public static  class  Test{
        private final static HolderDemo INSTANCE=new HolderDemo();
    }

    public static final HolderDemo getInstance(){
        return Test.INSTANCE;
    }
}
