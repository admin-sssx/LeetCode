package questions.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Solution {
    /**
     * method1
     * O(n^2)
     */
    public int[] twoSum1(int[] nums, int target) {
        int [] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                System.out.println("nums"+i+"+"+"nums"+j+"="+nums[i]+"+"+nums[j]+"="+(nums[i]+nums[j]));
                if(nums[i]+nums[j]==target){
                    System.out.println("yes");
                    result[0]=i;
                    result[1]=j;
                }
            }

        }
        return result;
    }

    /**
     * method2
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
               return new  int[] {i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class Sum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[]={2, 5, 5,11};
        int target = 10;
        System.out.println("method1 the complexity is O(n^2)  "+Arrays.toString(sol.twoSum1(nums,target)));
        System.out.println("method2 the complexity is O(n)  "+Arrays.toString(sol.twoSum1(nums,target)));
    }
}
