//TreeMap Solution
class Solution1 {
    public int[] findRightInterval(int[][] intervals) {
        //TreeMap preserves the order of insertion
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        //Maintain mapping of key:start of interval, value: index
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0], i);
        }
        
        /*
            Iterate and use ceilingEntry() to find the key,value pair with key
            greater than or equal to the end of interval
        */
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Integer entryKey = treeMap.ceilingKey(intervals[i][1]);
            result[i] = entryKey != null ? treeMap.get(entryKey) : -1;
        }
        
        return result;
    }
}

// Binary Search
class Solution2 {
    public int[] findRightInterval(int[][] intervals) {
        // Store the start of each interval
        List<Integer> starts = new ArrayList<>();
        
        // Maintain mapping between start of each interval
        // and it's index
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        
        for (int i = 0; i < intervals.length; i++) {
            starts.add(intervals[i][0]);
            startIndexMap.put(intervals[i][0], i);
        }
        
        //sort the starts array in non-decreasing order
        Collections.sort(starts);
        
        int[] res = new int[intervals.length];
        
        /* 
            Get the end of each interval
            search for the next interval
            with start greater than or equal to end.
        */
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int nextGreatestStart = binarySearch(starts, end);
            if (nextGreatestStart < end) {
                res[i] = -1;
            } else {
                res[i] = startIndexMap.get(nextGreatestStart);
            }
        }
        return res;
    }
    
    private int binarySearch(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target) { 
                return arr.get(mid);
            } else if (arr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr.get(start);
    }
}
