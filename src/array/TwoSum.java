package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName TwoSum
 * @Description Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * @Author GJD
 * @Date 2022/9/19 19:55
 **/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumV2(new int[]{3,2,4}, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length-1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (indexMap.containsKey(needNum)) {
                return new int[]{indexMap.get(needNum), i};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }
}
