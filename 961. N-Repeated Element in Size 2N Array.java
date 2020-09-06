class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}

