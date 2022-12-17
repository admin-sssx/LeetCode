package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sort {
    int size ;
    int arr[] = new int[size];

    public static void bubble(int arr[]){
        Srand srand = new Srand();
        System.out.println("----------------source data-------------------");
        System.out.print("|");srand.showArr(arr);
        System.out.println("-----------------------------------------------");
        System.out.println("----------------maopao start-------------------");
        for (int i = 0; i <arr.length-1 ; i++) {

            for (int j = 0; j < arr.length-i-1; j++) {

                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            srand.showArr(arr);

        }
        System.out.println("----------------maopao end-------------------");

    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int arr[],int start ,int end){

        Srand srand = new Srand();
        if(start >= end)/*如果左边索引大于或者等于右边的索引就代表已经整理完成一个组了*/
        {

            return ;
        }
        System.out.println("----------------source data-------------------");
        srand.showArr(arr);

        int key = arr[start];
        int i = start;
        int j = end;
        while (i<j){
            while(arr[j]>=key&&i<j)j--;
            arr[i] = arr[j];
            while (arr[i]<=key&&i<j)i++;
            arr[j] = arr[i];

        }
        arr[i] = key;
        System.out.println("----------------quick end-------------------");
        srand.showArr(arr);
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }

    /**
     * 此写法易于理解分治法
     * @param a
     * @return
     */
    public static List<Integer> quickSort(List<Integer> a){
        if(a.size()<=1) {
            return a;
        }
        List l =  new ArrayList();
        List r =  new ArrayList();
        int pIndex = (a.size())/2;
        int p = a.get(pIndex);
        for (int i = 0; i < a.size() ; i++) {
            if(pIndex !=i ) {
                if(a.get(i)<=p) {
                    l.add(a.get(i));
                } else {
                    r.add(a.get(i));
                }
            }
        }
        List result = new ArrayList();
        List resultL =quickSort(l);
        List resultR =quickSort(r);

        result.addAll(resultL);
        result.add(p);
        result.addAll(resultR);
        return result;
    }

    /**
     * 直接插入排序  递增
     * @param arr
     */
    public static void insertSort(int arr[]){

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int k = i;
                for (int j = i-1; j >=0 &&arr[j]>temp ; j--) {
                    arr[j+1] = arr[j];
                    k--;
                }
                arr[k] = temp;
            }

        }
    }

    /**
     * 简单选择排序
     * @param arr
     */
    public static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;

                }
            }
            if(minIndex!=i){
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
            Srand srand = new Srand();
            srand.showArr(arr);
        }
    }

    public static void heapsort(){

    }
}
