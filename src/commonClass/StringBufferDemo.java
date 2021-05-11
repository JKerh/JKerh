package commonClass;

public class StringBufferDemo {
    public static void main(String[] args) {
        String str=new String("hello");//创建一个String类的新对象
        String str1=str+"world";//在内存中重新创建另一个String类的对象

        StringBuffer strb=new StringBuffer("hello");//构建一个StringBuffer对象，并将其初始化
        strb.append(",world!");//改变strb对象的内容，并不会创建新对象，减少内存的浪费

        //三种构造方法
        StringBuffer stringBuffer=new StringBuffer();//构建一个空的StringBuffer对象，随着内容扩展其内存空间
        StringBuffer stringBuffer1=new StringBuffer(1024);//构建一个空的StringBuffer对象，固定内存空间的大小
        StringBuffer stringBuffer2=new StringBuffer("hello world");//构建一个StringBuffer对象，并将其初始化

        StringBuilder stringBuilder=new StringBuilder();
        stringBuffer2.append(true).append("!!!");
        stringBuffer2.replace(1,3,"niu");
        System.out.println(stringBuffer2.toString());

        /**
         * toString()方法，字符串输出
         * append() 追加
         * charAt(int index) 获取指定位置的字符
         * setcharAt(int index,char ch) 在指定位置插入字符
         * insert(int index,String str) 在指定位置插入字符串
         * delete(int start,int end) 删除指定区间元素[start,end)
         * reverse()反转字符串
         * replace(int start, int end,String str)替换指定区间字符[start,end)
         */


    }
}
