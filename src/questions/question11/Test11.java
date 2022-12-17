package questions.question11;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int tmpmax = 0;
        int minHeight = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            if(height[left]<height[right]){
                minHeight = height[left];

                tmpmax = (right-left)*minHeight;
                if(tmpmax>max){
                    max = tmpmax;
                }
                left++;
            }
            else {
                minHeight = height[right];
                tmpmax = (right-left)*minHeight;
                if(tmpmax>max){
                    max = tmpmax;
                }
                right--;
            }


        }
        return max;
    }
}

public class Test11 {

    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        int temp;
        while (i<j) {
            while ((i<j)&&(arr[j]>=pivot)) {
                j--;

            }

            arr[i] = arr[j];


            while ((i<j)&&(arr[i]<=pivot)) {
                i++;
            }

            arr[j] = arr[i];


        }

        arr[i] = pivot;/*当在当组内找完一遍以后就把中间数key回归*/
        return (arr);
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int a[] = {5,7,6,4,8};
        System.out.println(solution.maxArea(a));
        int b [] = qsort(a,0,a.length-1);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }

    }
}