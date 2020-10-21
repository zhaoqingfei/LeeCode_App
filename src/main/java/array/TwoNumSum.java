package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumSum {


    // 1. 暴力求解 O(n^2)
    public int[] twoSumA(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            //注意index2 = index + 1，数字不能重复使用
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return new int[0];
    }


    // 2.假设给定的数组大小不大于2048 则用数组来缓存值  O(n)
    public int[] towSumB(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Integer[] temp = new Integer[2048];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            Integer index = temp[other & 2047];
            if (index != null) {
                return new int[]{index, i};
            }

            temp[nums[i] & 2047] = i;
        }

        return null;
    }

    // 采用hashMap缓存  O(n)
    public int[] twoSum(int[] nums, int target) {
        if (nums == null | nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }







}
