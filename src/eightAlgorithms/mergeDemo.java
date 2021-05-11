package eightAlgorithms;

import java.util.Arrays;

public class mergeDemo {
    public static void main(String[] args) {
        int[] list = new int[]{20,12,15,1,5,49,58,24,578,211,20,214,78,35,125,789,11};
        merge(list,0,list.length-1);
        System.out.println(Arrays.toString(list));

    }

    public static void merge(int[] arr,int low,int high){
        int center=(low+high)/2;
        if(low<high){
//            递归，直到low==high，就是数组不能再分
            merge(arr,low,center);
            merge(arr,center+1,high);

//            当数组已经分到不能再分，开始归并排序
            mergeSort(arr,low,center,high);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr,int low,int center, int high){
//       用于暂存排序后的数组
        int[] temp=new int[high-low+1];

        int i=low,j=center+1;

//        临时数组下标
        int index=0;
//        循环遍历两个数组的值，将小的插入到临时数组里面
        while (i<=center&&j<=high){
//            左边数组小，插入到新数组里面
            if(arr[i]<arr[j]){
                temp[index++]=arr[i++];
            }else {
                temp[index++]=arr[j++];
            }
        }
//        将左半边多余的数组插入到临时数组的后面
        while (i<=center){
            temp[index++]=arr[i++];
        }
        while (j<=high){
            temp[index++]=arr[j++];
        }
//        将临时数组重新放回到原数组
        for (int m= 0; m < index; m++) {
            arr[m+low]=temp[m];
        }
    }
}
