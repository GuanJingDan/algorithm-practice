package array;

import java.util.Arrays;

/**
 * @ClassName MoveZeroes
 * @Description 283. Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * @Author GJD
 * @Date 2022/9/23 20:14
 **/
public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{1})));
    }
    public static int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int num = nums[i];
                nums[i] = 0;
                nums[index++] = num;
            }
        }

        return nums;
    }
}
