class CoinChangeII {
    // 相同coin可无限次使用
    // time O(mn);
    // space O(n)
    // 思想： 固定当前硬币，改变当前硬币使用的次数，由此dp[j]可以由前面的dp得到
    // 它是由二维dp转化成一维节省空间得到的转移方程
    // dp[i][j] 表示由前i种硬币组成j的最小的硬币数
    /*
    f[i][j] = sum(f[i-1][j],               // use coins[i-1] 0 times
             f[i-1][j-coins[i-1]],     // use coins[i-1] 1 time
             f[i-1][j-coins[i-1]*2],   // use coins[i-1] 2 times
             f[i-1][j-coins[i-1]*3],   // use coins[i-1] 3 times
             ...)

    where f[i][j - coins[i - 1]] = f[i-1][j-coins[i-1]] +
                                    f[i-1][j-coins[i-1]*2] +
                                    f[i-1][j-coins[i-1]*3] +
                                    ...

    then: f[j][j] = f[i - 1][j] + f[i][j - coins[i - 1]];
    然后再压缩空间： dp[j] += dp[j - coins[i]]; 

    */
    public int change(int amount, int[] coins) {
        // https://www.youtube.com/watch?time_continue=78&v=jaNZ83Q3QGc
        // https://zhuanlan.zhihu.com/p/36210712
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]]; 
            }
        }
        return dp[amount];
    }
}