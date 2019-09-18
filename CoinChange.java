class CoinChange {
    // 确定使用当前coin，则最小的使用当前coin的组合为 ：
    // 1 + 组成（amount - coin) 的最小组合数
    //不断更新min
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}