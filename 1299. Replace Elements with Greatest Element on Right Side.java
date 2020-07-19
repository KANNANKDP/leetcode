class Solution1 {
    public int[] replaceElements(int[] arr) {
        replace(arr, arr.length - 1, -1);
        return arr;
    }
    
    private void replace(int[] arr, int ind, int max) {
        if (ind < 0) {
            return;
        }
        int temp = arr[ind];
        arr[ind] = max;
        replace(arr, --ind , Math.max(max, temp));
    }
}

class Solution2 {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int i = arr.length - 1;
        while (i >= 0) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
            i--;
        }
        return arr;
    }
}
