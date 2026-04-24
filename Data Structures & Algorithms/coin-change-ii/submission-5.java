class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length]; // Correct DP size
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i][j] = -1; // Initialize DP array with -1
            }
        }
        return solve(amount, coins, 0, dp);
    }

    public static int solve(int amount, int[] coins, int index, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length || amount < 0) {
            return 0;
        }
        if (dp[amount][index] != -1) { // Correct memoization check
            return dp[amount][index];
        }

        int take = solve(amount - coins[index], coins, index, dp); // Take the coin
        int skip = solve(amount, coins, index + 1, dp); // Skip the coin

        return dp[amount][index] = take + skip; // Store the result
    }
}
