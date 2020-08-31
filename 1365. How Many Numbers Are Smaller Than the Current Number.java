// O(n^2)
class Solution1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res[i] = count;
        }
        
        return res;
    }
}

class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for (int i = 1; i < 101; i++) {
            count[i] += count[i-1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }
        
        return res;
    }
}

class Solution3 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        
        Arrays.sort(nums);
    
        hashMap.put(nums[0], count);
        for (int i = 1; i < nums.length; i++) {
            count++;
            if (nums[i] != nums[i - 1])
                hashMap.put(nums[i], count);
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = hashMap.get(res[i]);
        }
        
        return res;
    }
}

