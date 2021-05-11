package eightAlgorithms;

public class ChooseDemo {
    public static void main(String[] args) {
        int[] list=new int[]{4,13,2,24,25,18,11};
        int index=-1;
        int temp=-1;

        for (int i = 0; i <list.length-1; i++) {
            index=i;
            for (int j = i+1; j < list.length; j++) {
                //如果后面的数小于当前数，交换下标
                if(list[index]>list[j]){
                    index=j;
                }
            }
            if(index>0){
                temp=list[i];
                list[i]=list[index];
                list[index]=temp;
            }
        }
        for (int t:list) {
            System.out.println(t);
        }
    }
}
