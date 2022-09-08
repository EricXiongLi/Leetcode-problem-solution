class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }
}