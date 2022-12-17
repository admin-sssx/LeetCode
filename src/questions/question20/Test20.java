package questions.question20;


import java.util.ArrayList;
import java.util.Stack;

class Solution {
    int h = 0;
    ArrayList <ArrayList> results = new ArrayList<>();
    ArrayList list =new ArrayList();
    public int climbStairs(int n){
        //动态规划
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        //遍历二叉结果树，暴力破解。
//        if(n>0){
//            if(n>=1){
//                climbStairs(n-1);
//                if(n-1<=0){
//                    h++;
//                }
//            }
//            if(n>=2){
//                climbStairs(n-2);
//                if(n-2<=0){
//                    h++;
//                }
//            }
//        }
//        return h;
    }



//    public int climbStairs(int n) {
//        System.out.println("in="+n);
//        if(n>0){
//            if(n>=1){
//                System.out.println(">1 , n = "+ n);
//                list.add(1);
//
//                System.out.println("put--1"+list);
//                climbStairs(n-1);
//
//                System.out.println("pop--1"+list);
//                if(n-1<=0){
//                    h++;
//                    System.out.println("n="+n+"success1-------"+list);
//
//
//                }
//                if(list.size()>0)
//                    list.remove(list.size()-1);
//
//            }
//            if(n>=2){
//                System.out.println(">2 , n = "+ n);
//                list.add(2);
//
//                System.out.println("put--2"+list);
//                climbStairs(n-2);
//
//                System.out.println("pop--2"+list);
//                if(n-2<=0){
//                    h++;
//                    System.out.println("success2-------"+list);
//
//
//                }
//                if(list.size()>0)
//                    list.remove(list.size()-1);
//
//            }
//        }
//        else{
//
//        }
//        return h;
//    }


//    public int climbStairs(int n) {
//
//
//        System.out.println("this is "+n);
////        System.out.println("n="+n);
//        if(list.size()>0) {
////        System.out.println("before");
////            System.out.println(list);
//        }
//        if(n>0){
//            if(n>=1){
//                list.add(1);
////                System.out.println("into - 1");
//                n--;
//                if(n==0){
//                    results.add(list);
//                    h++;
//                    System.out.println(list);
//
//                }
//
//                climbStairs(n);
//
////                System.out.println("back - 1");
//            }
//            if(n>=2){
//                list.add(2);
//                n=n-2;
//                if(n == 0){
//                    results.add(list);
//                    System.out.println(list);
//                    h++;
//                }
//                    climbStairs(n);
//
//
//
//            }
//
//        }
//        if(list.size()>0){
//
//            list.remove(list.size()-1);
////            System.out.println("after");
//            if(list.size()>0){}
//
////            System.out.println(list);
//        }
//        System.out.println("this is "+n);
//        return h;
//    }
}

public class Test20 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Solution solution = new Solution();
        long st = System.currentTimeMillis();
        System.out.println(solution.climbStairs(5));
        long et = System.currentTimeMillis();
        System.out.println( et - st);

    }
}
