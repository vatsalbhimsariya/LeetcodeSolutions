class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        // Base case
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    if (i == 0 && j == 0) continue;

                    int val = grid[i][j];
                    int prev = (r - val % k + k) % k;

                    if (i > 0) {
                        dp[i][j][r] = (dp[i][j][r] + dp[i - 1][j][prev]) % MOD;
                    }
                    if (j > 0) {
                        dp[i][j][r] = (dp[i][j][r] + dp[i][j - 1][prev]) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
