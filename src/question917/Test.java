package question917;

import java.util.Scanner;

class Solution {
    public String reverseOnlyLetters(String s) {
//        int maxlen=0;
//        String temp="";
//        for(int i=0;i<s.length()-1;i++){
//            for(int j=i+1;j<s.length();j++)
//            {
//
//                if(temp.indexOf(s.charAt(i)) != -1 ){
//                    maxlen = temp.length();
//                    continue;
//                }
//                temp=s.substring(i,j);
//
//            }
//        }
//
        return s;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(sol.reverseOnlyLetters(s));
//        for(int i=0;i<s.length();i++){
//            if(s.contains("a")){
//                System.out.println("s is contains : a ");
//            }
//            if(s.contains("b")){
//                System.out.println("s is contains : a ");
//            }
//        }
    }
}
