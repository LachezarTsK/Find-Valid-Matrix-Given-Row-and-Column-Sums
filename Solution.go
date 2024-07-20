
package main

import "fmt"

func restoreMatrix(rowSum []int, columnSum []int) [][]int {
    numberOfRows := len(rowSum)
    numberOfColumns := len(columnSum)
    restoredMatrix := make([][]int, numberOfRows)
    for i := 0; i < numberOfRows; i++ {
        restoredMatrix[i] = make([]int, numberOfColumns)
    }

    row := 0
    column := 0

    for row < numberOfRows && column < numberOfColumns {
        restoredValue := min(rowSum[row], columnSum[column])

        restoredMatrix[row][column] = restoredValue
        rowSum[row] -= restoredValue
        columnSum[column] -= restoredValue

        if rowSum[row] == 0 {
            row++
        } else {
            column++
        }
    }

    return restoredMatrix
}
