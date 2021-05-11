package JUCDemo.SingleDemo;

import java.lang.reflect.Constructor;

public enum EnumDemo {
    INSTANCE;

    public EnumDemo getInstance(){
        return  INSTANCE;
    }
}

class  Test{
    public static void main(String[] args) throws Exception{
        EnumDemo enumIns=EnumDemo.INSTANCE;
        Constructor<EnumDemo> constructor=EnumDemo.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumDemo enumIns2=constructor.newInstance();

        System.out.println(enumIns);
        System.out.println(enumIns2);

    }
}
