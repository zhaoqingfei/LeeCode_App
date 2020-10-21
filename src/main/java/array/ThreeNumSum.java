package array;


import java.lang.reflect.Array;
import java.util.*;

/**
 * 15.三数之和
 * <p>
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeNumSum {


    // 1.暴力法:超出时间限制  O(n^3)
    public List<List<Integer>> threeSumA(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);  // 方便判重复
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();  // set里不会有重复的
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // 采用两层循环+hash缓存  O(n^2)
    public List<List<Integer>> threeSumB(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }


        Set<List<Integer>> result = new LinkedHashSet<>();

        Arrays.sort(nums);  // 排序
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];  // a + b = -c
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int other = target - nums[j];  // b = -c - a;
                Integer exist = map.get(other);  // 先取map缓存
                if (exist != null) {
                    result.add(Arrays.asList(nums[i], exist, nums[j]));
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }


    // 采用双指针夹逼法  O(n)
    public List<List<Integer>> threeSumC(int[] nums) {
        if (nums == null | nums.length <= 2) {
            return Collections.emptyList();
        }

        ArrayList<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);  // 首先进行排序
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;  // 因为是从小到大排序的，第i大于0时，和一定大于0
            }

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;  // 去重
            }
            int i = k + 1, j = nums.length - 1;


            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // while (i < j && nums[i] == nums[++i]) ;   这句的效率低
                    i++;
                } else if (sum > 0) {
                    // while (i < j && nums[j] == nums[--j]) ;
                    j--;
                } else {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }

        }


        return result;
    }

}
