class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        int lastNeg = cols - 1;
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] < 0) {
                res += cols;
                continue;
            } 
            if (grid[row][cols - 1] >= 0) {
                continue;
            }
            int left = 0, right = lastNeg;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[row][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res += (cols - left);
            lastNeg = left;
        }
        return res;
    }
}

