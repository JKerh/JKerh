package Java8NewMethod.Lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodImport {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(MethodImport::printDemo);
        System.out.println("==================");
        list.forEach(new MethodImport()::printCommon);
    }

//  使用静态方法，类名::方法
    public static void printDemo(int i){
        System.out.println(i);
    }

//    对普通方法，对象::方法
    public void printCommon(int i){
        System.out.println(i);
    }
}
