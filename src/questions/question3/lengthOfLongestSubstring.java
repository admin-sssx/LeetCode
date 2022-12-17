package questions.question3;

import util.Srand;

import java.util.HashSet;
import java.util.Set;

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
    public int method1(String s){
        int maxlen = 0;
        int ln = s.length();
        if("".equals(s)){
            return 1;
        }
        for (int i = 0; i < s.length() ; i++) {
            String temps = new String();

            for (int j = i+1; j < s.length()+1; j++) {
                char sj = (char)s.charAt(j-1);
                if(temps.indexOf(sj)==-1){
                    temps = s.substring(i,j);
//                    System.out.println(temps);
                }else{

                    break;
                }

            }
            if(maxlen<temps.length()){
                maxlen = temps.length();
            }
        }
        return maxlen;
    }

    /**
     * hashSet存储
     * @param s
     * @return
     */
    public int method2(String s ){
        int maxlen = 0;
        char array[] = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            HashSet<Character> set = new HashSet();
            set.add(array[i]);
            if(set.size()>maxlen) {
                maxlen = set.size();
            }
            for (int j = i+1; j < array.length; j++) {
                if(set.contains(array[j])) {
                    if(set.size()>maxlen) {
                        maxlen = set.size();
                    }
                    break;
                } else {
                    set.add(array[j]);
                    if(set.size()>maxlen) {
                        maxlen = set.size();
                    }
                }
            }
        }
        return  maxlen;
    }
}

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Srand srand = new Srand();
        String s = srand.srandStrLower(6);
        s = "au";
        System.out.println(s);
        System.out.println(sol.method1(s));
        System.out.println(sol.method2(s));

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println(sol.lengthOfLongestSubstring(s));

    }
}
