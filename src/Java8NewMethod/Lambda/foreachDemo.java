package Java8NewMethod.Lambda;

import java.security.Key;
import java.util.*;

public class foreachDemo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        new foreachDemo().ListDemo(list);
        new foreachDemo().ListForeachDemo(list);

        Map<String,Integer> map=new HashMap<>();

        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        new foreachDemo().MapForeachDemo(map);

    }
    int count=0;
//  一般方法遍历集合
    public void ListDemo(List l){
        List<Integer> list=new ArrayList<>(l);
        for (int i = 0; i <=list.size() ; i++) {
            count+=i;
        }
        System.out.println(count);
    }

    public void MapDemo(Map<String,Integer> map){
        Set<String > set=map.keySet();
        for (String key:set){
            int val=map.get(key);
            System.out.println(set+":"+val);
        }

    }
//Lambda+foreach遍历集合
    public void ListForeachDemo(List<Integer> l){//List集合
       l.forEach(i->count+=i);
        System.out.println(count);
    }

    public void MapForeachDemo(Map<String,Integer> map){
        map.forEach((key,value)->{
            System.out.println(key+":"+value);
        } );
    }
}
