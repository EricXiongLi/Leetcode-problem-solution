class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    //up
                    if(row == 0 || grid[row - 1][col] == 0) {
                        res++;
                    }
                    //bottom
                    if (row == m - 1 || grid[row + 1][col] == 0) {
                        res++;
                    }
                    //left
                    if (col == 0 || grid[row][col - 1] == 0) {
                        res++;
                    }
                    //right
                    if (col == n - 1 || grid[row][col + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}