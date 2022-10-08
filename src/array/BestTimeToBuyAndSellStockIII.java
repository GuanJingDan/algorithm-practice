package array;

import java.util.LinkedList;

/**
 * @ClassName BestTimeToBuyAndSellStockIII
 * @Description 123. You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * @Author GJD
 * @Date 2022/10/8 20:21
 **/
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,4,0,0,3,1,4}));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length < 2) {
            return 0;
        }
        return maxProfit;
    }
}
