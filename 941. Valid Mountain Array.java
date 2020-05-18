class Solution1 {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) {
            return false;
        }
        
        int i = 0;
	//walk up
        while(i + 1 < A.length && A[i] < A[i+1]) {
            i++;
        }
        
        if(i == 0 || i == A.length - 1) {
            return false;
        }
        
	//walk down
        while(i + 1 < A.length && A[i] > A[i+1]) {
            i++;
        }
        
        return i == A.length - 1;
    }
}


// Meet in the middle
class Solution2 {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) {
            return false;
        }
        
        int i = 0, j = A.length - 1;
        while (i + 1 < A.length && A[i] < A[i+1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        
        return i > 0 && i == j && j < A.length - 1;
    }
}

