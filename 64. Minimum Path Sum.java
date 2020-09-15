// Iterative
class Solution1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minCostPath = new int[m][n];
        
        minCostPath[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            minCostPath[i][0] = minCostPath[i-1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            minCostPath[0][j] = minCostPath[0][j-1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minCostPath[i][j] = grid[i][j] +
                    Math.min(minCostPath[i-1][j], minCostPath[i][j-1]);
            }
        }
        return minCostPath[m-1][n-1];
    }
}

// Recursive
class Solution2 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPathSumRec(grid, dp, 0, 0);
    }
    
    private int minPathSumRec(int[][] grid, int[][] dp, int i, int j) {
        int result;
        int m = grid.length;
        int n = grid[0].length;
        if (i + 1 >= m && j + 1 >= n) {
            result = grid[i][j];
        } else if (dp[i][j] > 0) {
            return dp[i][j];
        } else if (i + 1 >= m) {
            result = grid[i][j] + minPathSumRec(grid, dp, i, j + 1);
        } else if (j + 1 >= n) {
            result = grid[i][j] + minPathSumRec(grid, dp, i + 1, j);
        } else {
            result = grid[i][j] +
                Math.min(minPathSumRec(grid, dp, i, j + 1),minPathSumRec(grid, dp, i + 1, j));
        }
        
        dp[i][j] = result;
        return result;
    }
}
