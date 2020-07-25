class Solution1 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}

class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                res += map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        return res;
    }
}
