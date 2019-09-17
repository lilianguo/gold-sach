/*
746. Min Cost Climbing Stairs
经典的动态规划问题
状态转移方程 dp[i] = min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2])
*/

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i- 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}