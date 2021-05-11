package eightAlgorithms;

public class InsertDemo {
    public static void main(String[] args) {
        int[] list = new int[]{20,12,15,1,5,49,58,24,578,211,20,214,78,35,125,789,11};
        int temp=0;
        for (int i = 0; i < list.length; i++) {
            temp=list[i];
            for (int j =i; j >0 ; j--) {
//                如果前面的数大于当前数，则当前数向前移动一位
                if (list[j-1]>temp) {
                    list[j] = list[j-1];
//                 将第一个数已经移到第二位置，将当前数放到第一个位置
                    if (j == 1) {
                        list[j - 1] = temp;
                        break;
                    }
                }else {
//                    如果不大于则将当前数放到j的位置
                        list[j] = temp;
                        break;
                    }
                }
            }
        for (int t:list) {
            System.out.print(" "+t);
        }
    }
}
