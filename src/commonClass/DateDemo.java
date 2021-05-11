package commonClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date=new Date();//创建对象，获取运行new出对象设备的的当前时间
        System.out.println(date.toString());//输出的是格林威治时间(GTM)，国际标准时

        DateFormat df=new SimpleDateFormat("yyyy-MM-dd,HH:MM:ss");//创建格式化日期对象
        System.out.println(df.format(date).toString());//按照之前的格式输出日期
//         年月日时分秒可以自由组合

        Calendar calendar=Calendar.getInstance();//创建一个Calender对象
        calendar.setTime(date);

        calendar.get(calendar.get(Calendar.YEAR));//得到当前的年份

        calendar.set(calendar.YEAR,2022);//日历时间
        //calendar.set(field,int time);field设置日期的具体部分，time具体的值
        calendar.add(calendar.YEAR,10);//add对日期的某一部分做加减操作
    }
}
