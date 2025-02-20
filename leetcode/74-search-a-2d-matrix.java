class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix.length;

            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}