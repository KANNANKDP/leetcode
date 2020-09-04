class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 1; i < points.length; i++) {
            int[] currPoint = points[i];
            int[] prevPoint = points[i-1];
            minTime += Math.max(
                Math.abs(currPoint[0] - prevPoint[0]),
                Math.abs(currPoint[1] - prevPoint[1])
            );
        }
        return minTime;
    }
}

