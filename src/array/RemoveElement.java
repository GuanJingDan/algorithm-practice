package array;

/**
 * @ClassName RemoveElement
 * @Description Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * @Author GJD
 * @Date 2022/9/24 20:39
 * @Version 1.0
 **/
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElementV2(new int[]{3,2,2,3}, 3));
    }
    public static int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementV2(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r--];
            } else {
                l++;
            }
        }
        return l;
    }

}
