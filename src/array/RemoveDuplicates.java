package array;

import java.util.Arrays;

/**
 * @ClassName RemoveDuplicates
 * @Description 26. Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * @Author GJD
 * @Date 2022/9/26 11:21
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
//        System.out.println(removeDuplicatesFromSortedArrayV2(new int[]{0,0,1,1,1,2,2,3,3,4,4}));
        System.out.println(removeDuplicatesFromSortedArrayV2(new int[]{1,2}));
    }
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int k = 1;
        int i = 1;
        int cur = nums[0];
        while (i < n) {
            if (nums[i] != cur) {
                nums[k] = nums[i];
                cur = nums[i];
                k++;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    /**
     * 只需跟前一个对比，若快慢指针相等 无需赋值
     * @param nums
     * @return
     */
    public static int removeDuplicatesFromSortedArrayV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int fast = 1,slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast-1]) {
                if(fast > slow ) {
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
