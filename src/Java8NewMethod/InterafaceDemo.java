package Java8NewMethod;

public class InterafaceDemo {
    public static void main(String[] args) {
        interfaceTest it=new interfaceTestImpl();
        it.test();
//       接口的默认方法，没有被实现类重写也可以直接调用
        it.test2();
//        接口的静态方法
        interfaceTest.test3();
    }
}
interface interfaceTest{
    void  test();
    default  void test2(){
        System.out.println("这是接口的默认方法");
    }

    static void test3(){
        System.out.println("这是接口的静态方法");
    }
}

class interfaceTestImpl implements  interfaceTest{

    @Override
    public void test() {
        System.out.println("这是接口的实现类的方法");
    }
}