package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName FourSum
 * @Description Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n .
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * @Author GJD
 * @Date 2022/9/20 20:23
 **/
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
    }

    /**
     * 参考三数之和，包括4数、5数……n数 都是一样的方法，且无最优解了
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, Integer target) {
        List<List<Integer>> output = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length<4) {
            return output;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (target >= 0 && nums[i] > target) {
                break;
            } else if (target < 0 && nums[i] > 0){
                break;
            }
            // 重复跳过
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 四数双循环
            for (int j = i+1; j < nums.length - 2; j++) {
                // 重复跳过
                if (j> i +1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int m = j + 1;
                int n = nums.length - 1;
                while (m<n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum>target) { // 减n
                        while (m<n && nums[n] == nums[--n]);
                    } else if (sum < target) { // 加m
                        while (m<n && nums[m] == nums[++m]);
                    } else {
                        output.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        // 去重
                        while (m<n && nums[n] == nums[--n]);
                        while (m<n && nums[m] == nums[++m]);
                    }
                }
            }
        }
        return output;
    }
}
