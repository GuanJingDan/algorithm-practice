package array;

import java.util.Arrays;

/**
 * @ClassName RemoveDuplicatesII
 * @Description 80. Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * @Author GJD
 * @Date 2022/9/27 19:54
 **/
public class RemoveDuplicatesII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int fast = 2, slow = 2;
        while (fast < nums.length ) {
            if (nums[fast] != nums[slow-2]) {
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }
}
