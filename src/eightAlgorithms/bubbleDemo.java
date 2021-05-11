package eightAlgorithms;

public class bubbleDemo {
    public static void main(String[] args) {
        int[] list=new int[]{4,13,2,24,25,18,11};
        int temp=0;
        for (int i = 0; i <list.length-1; i++) {
            for (int j = 0; j<list.length-1; j++) {
                if (list[j]>list[j+1]){
                    temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        for (int t:list) {
            System.out.println(t);
        }
    }
}
