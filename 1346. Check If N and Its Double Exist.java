// Linear search solution : O(n^2)

class Solution1 {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}


// Hashing solution : O(n)

class Solution2 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> hashMap = new HashSet<>();

        for (int value : arr) {
            if ((value % 2 == 0 && hashMap.contains(value / 2)) || hashMap.contains(value * 2)) {
                return true;
            }
            hashMap.add(value);
        }
        return false;
    }
}
