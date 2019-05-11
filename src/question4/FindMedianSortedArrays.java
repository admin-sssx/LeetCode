package question4;

import java.lang.reflect.Array;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int i = 0, j = 0, k = 0;
        int arrlen;
//0 1 2 3 4 5   1 2    len=6   /2 = 3
//0 1 2 3 4 5 6   2    len=7   /2 = 3...1

        int mediIndex = (nums1.length + nums2.length) / 2;
        int nums3[] = new int[mediIndex + 1];
        if ((nums1.length + nums2.length) % 2 == 0) {
            arrlen = 2;
        } else {
            arrlen = 1;
        }
        int arr[] = new int[arrlen];
        while (i < nums1.length || j < nums2.length) {
            if (nums3.length < k + 1) {
                break;
            }
            if (i < nums1.length) {
                if (j < nums2.length) {
                    if (nums1[i] <= nums2[j]) {
                        nums3[k] = nums1[i];
                        k++;
                        i++;
                    } else  {

                        nums3[k] = nums2[j];
                        k++;
                        j++;
                    }
                }
                else{
                    nums3[k] = nums1[i];
                    k++;
                    i++;
                }

            } else {

                if (j < nums2.length) {
                    nums3[k] = nums2[j];
                    k++;
                    j++;
                }
            }

        }
        if (arrlen == 2) {
            median = (nums3[nums3.length - 1] + nums3[nums3.length - 2]) / 2;
        } else if (arrlen == 1) {
            median = nums3[nums3.length - 1];
        }
        return median;
    }
}

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

    }
}
