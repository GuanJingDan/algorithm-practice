package array;

import java.util.Arrays;

/**
 * @ClassName PlusOne
 * @Description You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * e.g.
 * 1. Input: digits = [1,2,3] Output: [1,2,4]
 * 2. Input: digits = [9] Output: [1,0]
 * @Author GJD
 * @Date 2022/9/8 15:06
 **/
public class PlusOne {
    public static void main(String[] args) {
//        int[] output = plusOne1(new int[]{1,0,0,0,0});
        int[] output = plusOne2(new int[]{9,9,9});
        System.out.println(Arrays.toString(output));
    }
    public static int[] plusOne1(int[] digits) {
        int length = digits.length;
        int[] output = new int[length];
        int a = 1;
        for (int i = length - 1; i >= 0; i--) {
            int temp = digits[i] + a;
            if (temp < 10) {
                a = 0;
                output[i] = temp;
            } else {
                a = 1;
                output[i] = 0;
            }
            if (i == 0) {
                if (a == 1) {
                    output = new int[length + 1];
                    output[0] = 1;
                }
            }
        }
        return output;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] ++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }
}
