class Solution1 {
    public int heightChecker(int[] heights) {
        final int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);
        
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                result++;
            }
        }
        
        return result;
    }
}

class Solution2 {
    public int heightChecker(int[] heights) {
        final int[] frequencyCounter = new int[101];
        for (int height : heights) {
            frequencyCounter[height]++;
        }
        
        int index = 0;
        int result = 0;
        for (int height : heights) {
            while (frequencyCounter[index] == 0) {
                index++;
            }
            
            if (height != index) {
                result++;
            }
            
            frequencyCounter[index]--;
        }
        
        return result;    
    }
}
