package test;

public class Test {
    public static void main(String[] args) {
        String  s="ccc";
        String[] strArr = s.split("");
        String result = "" ;
        for (int i = 0; i < strArr.length; i++) {
            String temp = "" ;
            int start = i;
            int end = i;
            while(start>=0&&end<strArr.length&&strArr[start].equals(strArr[end])) {
                if(start == end) {
                    temp = strArr[i];
                }
                else {
                    temp = strArr[start]+temp+strArr[end];
                }
                start--;
                end++;
            }
            if(temp.length()>result.length()) {
                result = temp;
            }
            start = i;
            end = i+1;
            while(start>=0&&end<strArr.length&&strArr[start].equals(strArr[end])) {
                if(start+1 == end) {
                    temp = strArr[start]+strArr[end];
                }
                else {
                    temp = strArr[start]+temp+strArr[end];
                }
                start--;
                end++;
            }

            if(temp.length()>result.length()) {
                result = temp;
            }
            System.out.println(temp);
        }
        System.out.println("result="+result);
    }
}
