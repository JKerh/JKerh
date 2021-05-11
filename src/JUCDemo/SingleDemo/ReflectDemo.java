package JUCDemo.SingleDemo;

import java.lang.reflect.Constructor;

public class ReflectDemo {
    private static  boolean flag=false;

    private volatile static ReflectDemo lazy;
    private ReflectDemo(){
        synchronized (ReflectDemo.class) {
            if (flag == false) {
                flag = true;//都用反射创建两个对象的应对措施
            } else {
                throw new RuntimeException("Dont use Reflect！");
            }
        }
    }
    // DCL懒汉式
    public  static  ReflectDemo getInstance() {
        if (lazy == null) {
            synchronized (ReflectDemo.class) {
                if (lazy == null) {
                    lazy = new ReflectDemo();//不是一个原子性的操作
                }
            }
        }
        return lazy;//
    }

    public static void main(String[] args)throws Exception {
        ReflectDemo instance1=ReflectDemo.getInstance();
        Constructor<ReflectDemo> constructor=ReflectDemo.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        ReflectDemo rd=constructor.newInstance();
        ReflectDemo rd2=constructor.newInstance();

        System.out.println(instance1);
        System.out.println(rd);
        System.out.println(rd2);
    }
}
