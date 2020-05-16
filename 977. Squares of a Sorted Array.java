class Solution {
    public int[] sortedSquares(int[] A) {
        int negativeIndex = A.length - 1,i = 0;
        for (; i < A.length; i++) {
            if (A[i] >= 0) {
                negativeIndex = i - 1;
                break;
            }
        }
        
        int[] squareArray = new int[A.length];
        i = 0;
        int positiveIndex = negativeIndex + 1;
        while (negativeIndex >= 0 && positiveIndex < A.length) {
            if (A[negativeIndex] * -1 <= A[positiveIndex]) {
                squareArray[i++] = A[negativeIndex] * A[negativeIndex];
                negativeIndex--;
            } else {
                squareArray[i++] = A[positiveIndex] * A[positiveIndex];
                positiveIndex++;
            }
        }
        
        while (negativeIndex >= 0) {
                squareArray[i++] = A[negativeIndex] * A[negativeIndex];
                negativeIndex--;
        }
        
        while (positiveIndex < A.length) {
                squareArray[i++] = A[positiveIndex] * A[positiveIndex];
                positiveIndex++;
        }
        
        return squareArray;
    }
}
