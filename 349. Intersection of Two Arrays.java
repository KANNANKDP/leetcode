// Using HashSet O(m + n) time, O(m + n) space
class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) 
            set1.add(num);
        
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) 
            set2.add(num);
        
        set1.retainAll(set2);
        int[] output = new int[set1.size()];
        int i = 0;
        for (int num : set1)
            output[i++] = num;
        return output;
    }
}

// Using sorting O(Max(mlogm, nlogn)) time, O(1) space
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> output = new ArrayList<>();
        int i = 0, j = 0;
        while (i != nums1.length && j != nums2.length) {
            int left = nums1[i];
            int right = nums2[j];
            if (left == right) {
                output.add(left);
                while (i < nums1.length && left == nums1[i]) {
                    i++;
                }
                while (j < nums2.length && right == nums2[j]) {
                    j++;
                }
            } else if (left < right) {
                while (i < nums1.length && left == nums1[i]) {
                    i++;
                }
            } else {
                while (j < nums2.length && right == nums2[j]) {
                    j++;
                }
            }
        }
        
        int[] res = new int[output.size()];
        for (i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res;
    }
}

