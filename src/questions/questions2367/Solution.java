package questions.questions2367;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
//
//        i < j < k ，
//        nums[j] - nums[i] == diff 且
//        nums[k] - nums[j] == diff
//        返回不同 算术三元组 的数目。
//        示例 1：
//
//        输入：nums = [0,1,4,6,7,10], diff = 3
//        输出：2
//        解释：
//        (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
//        (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
//        示例 2：
//
//        输入：nums = [4,5,6,7,8,9], diff = 2
//        输出：2
//        解释：
//        (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
//        (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
public class Solution {
    /**
     * 暴力破解 时间复杂度为O(n^3)
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int a = nums[j] - nums[i];
                    int b = nums[k] - nums[j];
                    if(a == diff && b == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 考虑到暴力破解中 实际是在找i,i+1,i+2下标满足的元素，
     * 那么是否只遍历一遍i就能解决呢？
     * nums[j] - nums[i] = diff => nums[j] = nums[i] + diff
     * nums[k] - nums[j] = diff => nums[k] - (nums[i] + diff ) = diff => nums[k] = nums[i] + 2 * diff
     * 题目提到 nums严格有序，那么此题可化为求：第i个下标后存在，nums[i]，nums[i]， nums[i] + 2 * diff
     * @param nums
     * @param diff
     * @return
     */


    public int arithmeticTriplets2(int[] nums, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int i = 0; i < nums.length-2; i++) {
            if(set.contains(nums[i]+diff)&&set.contains(nums[i]+diff+diff)) {
                count++;
            }
        }
        for (int num : nums) {
            
        }
        return count;
    }
    @Test
    public void test() {
        int[] nums = {1,3,56};
        arithmeticTriplets2(nums,5);
    }
}
