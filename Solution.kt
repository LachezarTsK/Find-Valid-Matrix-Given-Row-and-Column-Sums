
import kotlin.math.min

class Solution {

    fun restoreMatrix(rowSum: IntArray, columnSum: IntArray): Array<IntArray> {
        val numberOfRows = rowSum.size
        val numberOfColumns = columnSum.size
        val restoredMatrix = Array<IntArray>(numberOfRows) { IntArray(numberOfColumns) }

        var row = 0
        var column = 0

        while (row < numberOfRows && column < numberOfColumns) {
            val restoredValue = min(rowSum[row], columnSum[column])

            restoredMatrix[row][column] = restoredValue
            rowSum[row] -= restoredValue
            columnSum[column] -= restoredValue

            if (rowSum[row] == 0) {
                ++row
            } else {
                ++column
            }
        }

        return restoredMatrix
    }
}
