
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& columnSum) const {
        size_t numberOfRows = rowSum.size();
        size_t numberOfColumns = columnSum.size();
        vector<vector<int>> restoredMatrix(numberOfRows, vector<int>(numberOfColumns));

        int row = 0;
        int column = 0;

        while (row < numberOfRows && column < numberOfColumns) {
            int restoredValue = min(rowSum[row], columnSum[column]);

            restoredMatrix[row][column] = restoredValue;
            rowSum[row] -= restoredValue;
            columnSum[column] -= restoredValue;

            if (rowSum[row] == 0) {
                ++row;
            }
            else {
                ++column;
            }
        }

        return restoredMatrix;
    }
};
