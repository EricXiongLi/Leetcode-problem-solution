class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 0, m *n - 1
        //t, t,..., true, false
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r == -1) return false;
        int row = r / n;
        int col = r % n;
        return matrix[row][col] == target;
        
    }
}

//