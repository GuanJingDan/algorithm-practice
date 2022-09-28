package array;

/**
 * @ClassName BestTimeToBuyAndSellStock
 * @Description 121. You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * @Author GJD
 * @Date 2022/9/28 19:53
 **/
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfitV3(new int[]{7,1,5,3,6,4}));
    }

    /**
     * 超时
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int j = i+1;
            while (j < prices.length) {
                if (prices[j] - prices[i] > maxProfit ) {
                    maxProfit = prices[j] - prices[i];
                }
                j++;
            }
        }
        return maxProfit;
    }

    /**
     * 慢指针指的数大于之前的，不再与快指针比较，下一个数比当前小的，当前不再与后面的比较(--还是超时，非根本解决方法)
     * @param prices
     * @return
     */
    public static int maxProfitV2(int[] prices) {
        int maxProfit = 0;
        int minSlow = 0;
        Boolean isStart = false;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] > prices[i+1]) {
                continue;
            }
            if (!isStart) {
                minSlow = prices[i];
                isStart = true;
            } else {
                if (minSlow <= prices[i]) {
                    continue;
                }
            }

            int j = i+1;
            while (j < prices.length) {
                if (prices[j] - prices[i] > maxProfit ) {
                    maxProfit = prices[j] - prices[i];
                }
                j++;
            }
        }
        return maxProfit;
    }

    /**
     * 最低点与最大收益
     * @param prices
     * @return
     */
    public static int maxProfitV3(int[] prices) {
        int maxProfit = 0;
        int minPoint = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPoint) {
                minPoint = prices[i];
            } else if (prices[i] - minPoint > maxProfit) {
                maxProfit = prices[i] - minPoint;
            }
        }
        return maxProfit;
    }
}
