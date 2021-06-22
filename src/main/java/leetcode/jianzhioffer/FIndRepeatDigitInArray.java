package leetcode.jianzhioffer;

import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FIndRepeatDigitInArray {

    /**
     * 将数组进行排序，并循环比较相邻两个元素是否相等,若相等则返回
     * @param nums
     */
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 1; i++)
        {
            if (nums[i+1] == nums[i])
                return nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
