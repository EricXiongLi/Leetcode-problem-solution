class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k1) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.clear();
                set.add(0);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += matrix[k][j] - (i == 0 ? 0 : matrix[k][i - 1]);
                    int target = sum - k1;
                    if (set.contains(target)) {
                        return k1;
                    }
                    if (set.higher(target) != null) {
                        res = Math.max(res, sum - set.higher(target));
                    }
                    set.add(sum);
                }
            }
        }
        return res;
    }
}