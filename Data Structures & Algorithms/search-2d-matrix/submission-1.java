class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int left = 0;
        int right = (rowCount*columnCount)-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            int rowPos = (mid/columnCount);
            int columnPos = (mid%columnCount);

            if (matrix[rowPos][columnPos] == target) {
                return true;
            }

            if (matrix[rowPos][columnPos] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;

    }
}
