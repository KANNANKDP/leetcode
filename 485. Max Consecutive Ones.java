class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (maxLength < count) {
                    maxLength = count;
                }
            } else {
                count = 0;
            }
        }
        return maxLength;
    }
}
