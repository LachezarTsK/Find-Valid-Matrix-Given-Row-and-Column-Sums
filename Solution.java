
public class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] columnSum) {
        int numberOfRows = rowSum.length;
        int numberOfColumns = columnSum.length;
        int[][] restoredMatrix = new int[numberOfRows][numberOfColumns];

        int row = 0;
        int column = 0;

        while (row < numberOfRows && column < numberOfColumns) {
            int restoredValue = Math.min(rowSum[row], columnSum[column]);

            restoredMatrix[row][column] = restoredValue;
            rowSum[row] -= restoredValue;
            columnSum[column] -= restoredValue;

            if (rowSum[row] == 0) {
                ++row;
            } else {
                ++column;
            }
        }

        return restoredMatrix;
    }
}
