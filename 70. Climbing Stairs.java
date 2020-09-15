// Recursion  with memoization
class Solution1 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climbStairsRec(n, dp);
    }
    
    private int climbStairsRec(int n, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (dp[n] > 0) {
            return dp[n];
        }
        
        dp[n] = climbStairsRec(n-1, dp) + climbStairsRec(n-2, dp);
        return dp[n];
    }
}

// Dynamic programming
class Solution2 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

