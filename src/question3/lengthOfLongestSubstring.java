package question3;

import java.util.Scanner;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        String temp = "";
       s =  s.replace(" ","");
       System.out.println("s.length= "+s.length()+" s="+s);
//        if(s==""){
//            maxlen=1;
//        }
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.println(i + "----------------" + "the string length is : " + s.length() + "------------------------------");
            temp = "";

            if(s.charAt(i)==' '){
                break;
            }
            for (int j = i + 1; j < s.length(); j++) {

                temp = s.substring(i, j);
                System.out.println(temp);
                if (temp.indexOf(s.charAt(j)) != -1) {
//                    System.out.print("  i=" + i + "  char=" + s.charAt(i));
                    if (maxlen < temp.length())
                        maxlen = temp.length();
                    System.out.println(s.charAt(j) + " is in " + temp + " and this is max=" + maxlen + " and this is tempmax=" + temp.length());
//                    System.out.println();
                    break;
                } else {
                    if (maxlen < temp.length()+1)
                        maxlen = temp.length()+1;

                    System.out.println(s.charAt(j) + " not in " + temp + " and this is max=" + maxlen+ " and this is tempmax=" + temp.length());
//                    System.out.println("temp[" + i + "," + j + "]=" + temp);
//                    System.out.println();
                }

            }
            System.out.println("max=" + maxlen);
//            System.out.println();
        }

        return maxlen;
    }
}

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
