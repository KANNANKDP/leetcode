class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        for (int i = 0, k = 0; i < n; i++) {
            result[k++] = nums[i];
            result[k++] = nums[i + n];
        }
        return result;
    }
}
