package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 生成随机测试
 */
public class Srand {
    /**
     * ArrayList<Integer> 生成长度为size，start-end范围内的随机整数。
     * @param size ArrayList长度
     * @param start 开始范围
     * @param end   结束范围
     * @return
     */
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

    /**
     *
     * @param arr
     */
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

    /**
     * 生成长度为length的小写字母字符串
     * @param length
     * @return
     */
   public String srandStrLower(int length){
       StringBuilder stringBuilder = new StringBuilder();
       Random random = new Random();
       for (int i = 0; i < length; i++) {
           int rand = random.nextInt(26)+97;
           stringBuilder.append((char)rand);
       }
       String str = ""+stringBuilder;
       return  str;
   }
}

class Test{
    public static void main(String[] args) {
        Srand srand = new Srand();
        int arr [] = srand.srandArr(10,1,100);

//        srand.showArr(arr);
//        Sort.quickSort(arr,0,arr.length-1);
//        System.out.println(srand.srandStrLower(26));
        Sort.bubble(arr);
        System.out.println("----------------end data-------------------");
        srand.showArr(arr);
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1,3);

        List list2 = new LinkedList(list);
        list.add(list2);
        list2.clear();
        list2.add(5);
//        list.subList(2,4);
        System.out.println(list);
        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";
        str2 = str1.concat(str2);
        System.out.println(str3.concat(str1));

    }
}

