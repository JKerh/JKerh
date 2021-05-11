package commonClass;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
//        BigDecimal bg=new BigDecimal(0.2);//不建议直接放入一个double类型的数
        BigDecimal bg=new BigDecimal(Double.toString(0.2));//如果必须要使用数字类型
        BigDecimal bd=new BigDecimal(Double.toString(0.1));//如果必须要使用数字类型
        bg.multiply(bd);

        System.out.println(bg.divide(bd, 2, BigDecimal.ROUND_CEILING));
        /**
         * public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
         * BigDecimal divisor被除数
         * scale保留的小数位
         * roundingmode 舍入的方式
         *
         */

        /**
         *add()加方法
         * substract()减
         * multiple乘
         * 无论加减乘除都是生成一个新的对象，不会改变原有对象的值
         */
    }
}
