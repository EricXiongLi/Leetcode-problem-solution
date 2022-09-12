class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 1,  5,  9
        // 10, 11, 13
        // 12, 13, 15
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        int res;
        //true, true,..., true, false, false
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid, matrix, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    public boolean check(int mid, int[][] matrix, int k) {
        int n = matrix.length;
        int startRow = n - 1, startCol = 0;
        int count = 0;
        boolean isExsit = false;
        while (startRow >= 0 && startCol <= n - 1) {
            if (matrix[startRow][startCol] <= mid) {
                if (matrix[startRow][startCol] == mid) isExsit = true;
                count += (startRow + 1);
                startCol++;
            } else {
                startRow--;
            }
        }
        return count < k;
    }
}