class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];
        return solve(prices, 0, 0, memo);
    }

    public int solve(int[] prices, int index, int holding, Integer[][] memo) {
        if (index == prices.length) return 0;
        if (memo[index][holding] != null) return memo[index][holding];

        int result;
        if (holding == 0) {
            // Choose to buy or skip
            int buy = -prices[index] + solve(prices, index + 1, 1, memo);
            int skip = solve(prices, index + 1, 0, memo);
            result = Math.max(buy, skip);
        } else {
            // Choose to sell or hold
            int sell = prices[index] + solve(prices, index + 1, 0, memo);
            int hold = solve(prices, index + 1, 1, memo);
            result = Math.max(sell, hold);
        }

        return memo[index][holding] = result;
    }
}
