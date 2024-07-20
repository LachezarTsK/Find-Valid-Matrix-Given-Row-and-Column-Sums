
using System;

public class Solution
{
    public int[][] RestoreMatrix(int[] rowSum, int[] columnSum)
    {
        int numberOfRows = rowSum.Length;
        int numberOfColumns = columnSum.Length;
        int[][] restoredMatrix = new int[numberOfRows][];
        for (int r = 0; r < numberOfRows; ++r)
        {
            restoredMatrix[r] = new int[numberOfColumns];
        }

        int row = 0;
        int column = 0;

        while (row < numberOfRows && column < numberOfColumns)
        {
            int restoredValue = Math.Min(rowSum[row], columnSum[column]);

            restoredMatrix[row][column] = restoredValue;
            rowSum[row] -= restoredValue;
            columnSum[column] -= restoredValue;

            if (rowSum[row] == 0)
            {
                ++row;
            }
            else
            {
                ++column;
            }
        }

        return restoredMatrix;
    }
}
