package commonClass;

public class StringDemo {
    public static void main(String[] args) {
//        构建字符串的方式
//        1.字面量的方式构建
        String s1="hello";

//        2.调用构造方法
        String s2=new String("hello");
//        3.使用字符数组赋值
        char[] a=new char[]{'h','e','l','l','o'};
//        String string =new String(char[],offset,count);
        String s3=new String(a,0,5);

        System.out.println("abcdebfd".indexOf("b",2));//return 5
        System.out.println("abcdebfd".lastIndexOf("b"));//return 5
        System.out.println("abcdebfd".indexOf("bc"));//return 1

        System.out.println("  abcdebfd  ".trim());//return 1

        System.out.println("abcdebfd".replace("bc","ff"));

        String c="10";
        int i=Integer.parseInt(c);

        System.out.println("Hello,world,!!".split(","));



    }
}
