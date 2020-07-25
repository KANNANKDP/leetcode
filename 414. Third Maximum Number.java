class Solution1 {
    public int thirdMax(int[] nums) {
        int index = 0;
        long[] result = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > result[0]) {
                result[2] = result[1];
                result[1] = result[0];
                result[0] = nums[i];
                index++;
            } else if (nums[i] > result[1] && nums[i] < result[0]) {
                result[2] = result[1];
                result[1] = nums[i];
                index++;
            } else if (nums[i] > result[2] && nums[i] < result[1]) {
                result[2] = nums[i];
                index++;
            }
        }
        return index > 2 ? (int)result[2] : (int)result[0];
    }
}


class Solution2 {
    public int thirdMax(int[] nums) {
        
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;
        
        for(int i:nums) {
            if(i>first) {
                third=second;
                second=first;
                first=i;
            }
            else if(i==first) 
                continue;
            else if(i>second) {
                third=second;
                second=i;
            }
            else if(i==second)
                continue;
            else if(i>third) 
                third=i;
        }
        return third==Long.MIN_VALUE ? (int)first : (int) third;
    }
}
