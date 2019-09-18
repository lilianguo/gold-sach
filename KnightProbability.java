/*
动态规划：
用个二维数组来存储马跳到每个格子的概率。
首先，开一个二维数组来存初始状态，即马的初始状态的位置概率为1，其他位置概率都为0。
接下来我们按步一次一次更新二维数组每个位置的概率:
我们可以通过当前位置来知道上一轮有哪些地方（在棋盘内合法的位置）的马跳一次可以到达该位置，
这样我们把这些地方的概率x0.125（因为这些地方每一个都有八种选择路线，选择到该位置的概率自然是1/8）加到当前的位置上即完成更新。
该次棋盘更新完成要把该棋盘作为上一轮的状态棋盘以便下次循环来使用。
Time: O(K*N^2)
Spae: O(N^2)
*/
class KnightProbability {
    // 688. Knight Probability in Chessboard
    private int[][] dir = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
     
    public double knightProbability(int N, int K, int r, int c) {
        // Write your code here.
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for (int step = 1; step <= K; step++) {
            double[][] dpTemp = new double[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    for (int[] direction : dir) {
                        int lastR = i - direction[0];
                        int lastC = j - direction[1];
                        if (lastR >= 0 && lastR < N && lastC >= 0 && lastC < N)
                            dpTemp[i][j] += dp[lastR][lastC] * 0.125;
                    }
            dp = dpTemp;
        }
        double res = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                res += dp[i][j];
    
        return res;
    }
}