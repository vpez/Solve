public class Solution_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }

            if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        var solve = new Solution_BestTimeToBuyAndSellStock();
        solve.test(new int[]{7, 1, 5, 3, 6, 4}, 5);
        solve.test(new int[]{7, 6, 4, 3, 1}, 0);
    }

    void test(int[] prices, int maxProfit) {
        if (maxProfit == maxProfit(prices)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
