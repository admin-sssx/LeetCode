package questions.question9;

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        boolean result = true;
        String str = String.valueOf(x);
        if(str.length()==0){
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return result;
    }
    public boolean isPalindrome2(int x) {
        boolean result = true;

        return result;
    }


}

public class Test9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(0));
    }


}
