class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                map.put(mat[r][c], new int[]{r, c});
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int r = map.get(arr[i])[0];
            int c = map.get(arr[i])[1];
            rowCount[r]++;
            colCount[c]++;
            if (rowCount[r] == n || colCount[c] == m) {
                return i;
            }
        }
        
        return -1;
    }
}

//tc: O(m * n)

//sc: O(m + n)