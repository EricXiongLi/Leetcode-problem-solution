class Solution {
    int m, n;
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int res = 0;
        Set<String> set = new HashSet();
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("o");
                    dfs(grid, row, col, sb);
                    if (!set.contains(sb.toString())) {
                        set.add(sb.toString());
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] grid, int row, int col, StringBuilder sb) {
        grid[row][col] = -1;
        //up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            sb.append("u");
            dfs(grid, row - 1, col, sb);
        } else {
            sb.append("nu");
        }
        
        //down
        if (row + 1 < m && grid[row + 1][col] == 1) {
            sb.append("d");
            dfs(grid, row + 1, col, sb);
        } else {
            sb.append("nd");
        }
        //left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            sb.append("l");
            dfs(grid, row, col - 1, sb);
        } else {
            sb.append("nl");
        }
        //right
        if (col + 1 < n && grid[row][col + 1] == 1) {
            sb.append("r");
            dfs(grid, row, col + 1, sb);
        } else {
            sb.append("nr");
        }
        
    }
}