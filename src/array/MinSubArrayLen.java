package array;

import java.util.Arrays;

/**
 * @ClassName MinSubArrayLen
 * @Description 209. Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * @Author GJD
 * @Date 2022/9/21 12:29
 **/
public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(minSubArrayLenV3(7, new int[]{2,3,1,2,4,3}));
    }

    /**
     * 超时
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i], j = i + 1;
            while (sum < target && j < nums.length) {
                sum += nums[j++];
            }
            if (sum >= target && (minLength == 0 || minLength > j - i)) {
                minLength = j - i;
            }
            if (minLength == 1) {
                break;
            }
        }
        return minLength;
    }

    /**
     * 超时
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLenV2(int target, int[] nums) {
        int minLength = 1;
        while (minLength <= nums.length) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i];
                for (int j = 1; j < minLength && i + minLength <= nums.length; j++) {
                    sum += nums[i+j];
                }
                if (sum >= target) {
                    break;
                }
            }
            if (sum >= target) {
                break;
            } else if (minLength == nums.length) {
                minLength = 0;
                break;
            } else {
                minLength ++;
            }

        }
        return minLength;
    }

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLenV3(int target, int[] nums) {
        int minLength = 0;
        int start = 0, end = 0, sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                minLength = minLength == 0 || minLength > (end - start + 1) ? (end - start + 1) : minLength;
                sum -= nums[start++];
            }
            end ++;
        }
        return minLength;
    }
}
