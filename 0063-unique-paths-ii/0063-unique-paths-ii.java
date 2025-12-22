class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // Base Case: If the start is blocked, there are 0 paths.
        if (obstacleGrid[0][0] == 1) return 0;

        // Start point
        dp[0][0] = 1;

        // 1. Fill the first Column
        for (int i = 1; i < m; i++) {
            // Can only reach this if previous was reachable AND current is not blocked
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) ? 1 : 0;
        }

        // 2. Fill the first Row
        for (int j = 1; j < n; j++) {
            // Can only reach this if previous was reachable AND current is not blocked
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j-1] == 1) ? 1 : 0;
        }

        // 3. Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0; // Obstacle blocks everything
                }
            }
        }

        return dp[m-1][n-1];
    }
}