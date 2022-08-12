class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int firstIndex = 0, first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] <= second) {
                if (grid[0][i] <= first) {
                    firstIndex = i;
                    second = first;
                    first = grid[0][i];
                } else {
                    second = grid[0][i];
                }
            }
        }
        int res = grid[0][0];
        for (int i = 1; i < m; i++) {
            int newFirstIndex = 0;
            int newFirst = Integer.MAX_VALUE, newSecond = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int cur = 0;
                if (j != firstIndex) {
                    cur = grid[i][j] + first;
                    if (cur <= newSecond) {
                        if (cur <= newFirst) {
                            newFirstIndex = j;
                            newSecond = newFirst;
                            res = cur;
                            newFirst = cur;
                        } else {
                            newSecond = cur;
                        }    
                    }
                } else {
                    cur = grid[i][j] + second;
                    if (cur <= newSecond) {
                        if (cur <= newFirst) {
                            res = cur;
                            newSecond = newFirst;
                            newFirst = cur;
                            newFirstIndex = j;
                        } else {
                            newSecond = cur;
                        }
                        
                    }
                }
            }
            first = newFirst;
            second = newSecond;
            firstIndex = newFirstIndex;
        }
        return res;
    }
}