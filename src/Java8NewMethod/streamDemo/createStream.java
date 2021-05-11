package Java8NewMethod.streamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class createStream {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//        System.out.println(list.stream().max((a, b) -> a - b).get());


        String[] str=new String[]{"ab","sds","wawfa","s","22"};
        Stream<String> strs= Stream.of(str);
        Stream<String> strs1= Stream.of(str).parallel();//得到并行流，类似于多线程

//       strs.max((a, b) -> a.length() - b.length());//得到的是Optional的对象，需要get一下

//        collTest(list.stream()).stream().forEach(System.out::println);

        Stream.concat(strs,list.stream()).forEach(System.out::println);
    }
    /**
     * 把数组中的每个元素进行映射，对元素进行一些处理后再将这些元素返回到原来的位置上
     */
    public static void mapTest(Stream<Integer> i){
        i.map(a->a*a).forEach(System.out::println);
    }

    /**
     * mapToInt/mapToDouble/mapToFloat方法
     * @param s
     */
    public static void summaryTest(Stream<Integer> s){
        System.out.println("最大值："+s.mapToInt(x->x).summaryStatistics().getMax());
        System.out.println("最小值："+s.mapToInt(x->x).summaryStatistics().getMin());
        System.out.println("求和："+s.mapToInt(x->x).summaryStatistics().getSum());
        System.out.println("平均值："+s.mapToInt(x->x).summaryStatistics().getAverage());
    }

    /**
     * collect方法
     * @param c
     * @return
     */
    public static  List<Integer> collTest(Stream<Integer> c){
        List<Integer> list=c.filter(m->m%2==0).collect(Collectors.toList());
        return list;
    }
}
