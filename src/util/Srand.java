package util;

import java.util.ArrayList;
import java.util.Random;

public class Srand {
   public ArrayList<Integer> srandList(int size,int start, int end){
       ArrayList <Integer> arrayList = new ArrayList<>();
       Random random = new Random();
       for (int i = 0; i < size; i++) {
           int rand = random.nextInt(end-start+1)+start;
           arrayList.add(i,rand);
       }
       return  arrayList;
   }
   public int [] srandArr(int size,int start, int end){
       int arr [] = new int[size];
       Random random = new Random();
       for (int i = 0; i < size; i++) {
           int rand = random.nextInt(end-start+1)+start;
           arr[i] = rand;
       }
       return arr;
   }

   public void showArr(int [] arr){
       System.out.print("[");
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]);
           if(i<10-1){
               System.out.print(",");
           }
       }
       System.out.print("]");
       System.out.println();
   }

}

class Test{
    public static void main(String[] args) {
        Srand srand = new Srand();
        int arr [] = srand.srandArr(10,1,100);
        System.out.println("----------------source data-------------------");
        srand.showArr(arr);

        for (int i = 0; i <arr.length-1 ; i++) {
//            System.out.println("----------------start-------------------");
            for (int j = 0; j < arr.length-i-1; j++) {

                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            srand.showArr(arr);
//            System.out.println("----------------end-------------------");
        }


    }
}

