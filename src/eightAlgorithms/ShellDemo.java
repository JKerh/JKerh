package eightAlgorithms;

import java.util.Arrays;

public class ShellDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{20,12,15,1,5,49,58,24,578,211,20,214,78,35,125,789,11};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void shellSort(int[] arr){
        int temp;
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int j=gap;j<arr.length;j++){
                int i=j;
               while (i-gap>=0&&arr[i]<arr[i-gap]){
                        temp=arr[i];
                        arr[i]=arr[i-gap];
                        arr[i-gap]=temp;
                }
            }
        }
    }
}
