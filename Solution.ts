
function restoreMatrix(rowSum: number[], columnSum: number[]): number[][] {
    const numberOfRows = rowSum.length;
    const numberOfColumns = columnSum.length;
    const restoredMatrix: number[][] = Array.from(new Array(numberOfRows), () => new Array(numberOfColumns).fill(0));

    let row = 0;
    let column = 0;

    while (row < numberOfRows && column < numberOfColumns) {
        let restoredValue = Math.min(rowSum[row], columnSum[column]);

        restoredMatrix[row][column] = restoredValue;
        rowSum[row] -= restoredValue;
        columnSum[column] -= restoredValue;

        if (rowSum[row] === 0) {
            ++row;
        } else {
            ++column;
        }
    }

    return restoredMatrix;
};
