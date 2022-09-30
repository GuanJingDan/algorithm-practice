package array;

/**
 * @ClassName BestTimeToBuyAndSellStockII
 * @Description 122. You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 * @Author GJD
 * @Date 2022/9/29 20:28
 **/
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
//        7,1,5,3,6,4
//        1,2,3,4,5
//        7,6,4,3,1
//        3,2,6,5,0,3
//        5,2,3,2,6,6,2,9,1,0,7,4,5,0
        System.out.println(maxProfitV2(new int[]{5,2,3,2,6,6,2,9,1,0,7,4,5,0}));
    }

    /**
     * Runtime: 12 ms, faster than 5.73% of Java online submissions
     * Memory Usage: 43.7 MB, less than 79.31% of Java online submissions
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int sumProfit = 0;
        int maxProfit = 0;
        int minPoint = prices[0];
        int i = 0;
        while (i < prices.length) {
            if (prices[i] < minPoint) {
                minPoint = prices[i];
            } else if (prices[i] - minPoint >= maxProfit) {
                maxProfit = prices[i] - minPoint;
                if (i+1 < prices.length && prices[i] > prices[i+1]) {
                    // 卖了
                    sumProfit += maxProfit;
                    maxProfit = 0;
                    minPoint = prices[i+1];
                } else if(i+1 == prices.length) {
                    // 卖了
                    sumProfit += maxProfit;
                }
            }
            i++;
        }
        return sumProfit;
    }

    /**
     * 贪心算法：只要今天比昨天高就卖
     * @param prices
     * @return
     */
    public static int maxProfitV2(int[] prices) {
        int sumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                sumProfit += prices[i] - prices[i-1];
            }
        }
        return sumProfit;
    }

}
