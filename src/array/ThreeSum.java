package array;

import java.util.*;

/**
 * @ClassName ThreeSum
 * @Description Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * @Author GJD
 * @Date 2022/9/20 14:39
 **/
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSumV2(new int[]{-1,0,1,2,-1,-4}));
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return new ArrayList<>();
        }
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        HashMap<Integer, List<Integer>> needNums = new HashMap<>();
        for (int i = 0; i < nums.length-2; i++) {
            Integer left = nums[i];
            needNums.clear();
            if (left > 0) {
                break;
            }
            // 重复跳过
            if (i>0 && left == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                Integer right = nums[j];
                if (needNums.containsKey(right)) {
                    List<Integer> triplet = needNums.get(right);
                    output.add(triplet);
                    needNums.remove(right);
                } else {
                    // 放这里考虑 0,0,0的情况
                    if (j > i+1 && right == nums[j-1]) {
                        continue;
                    }
                    int needNum = -(left + right);
                    List<Integer> list = Arrays.asList(left, right, needNum);
                    Collections.sort(list);
                    needNums.put(needNum, list);
                }
            }
        }
        return output;
    }

    public static List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        // 不满足三数 返回空list；
        if (Objects.isNull(nums) || nums.length < 3) {
            return output;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果大于零 后面的三数相加不可能等于0
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int m = i+1;
            int n = nums.length -1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                if (sum > 0) { // 减小n
                    while (m<n && nums[n] == nums[--n]);
                } else if(sum < 0) { // 增加m
                    while (m<n && nums[m] == nums[++m]);
                } else {
                    output.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m<n && nums[n] == nums[--n]);
                    while (m<n && nums[m] == nums[++m]);
                }
            }
        }
        return output;
    }
}
