class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> cur = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            cur.add(sb);
        }
        boolean[] colUsed = new boolean[n];
        boolean[] diag1Used = new boolean[2 * n - 1], diag2Used = new boolean[2 * n - 1];
        dfs(res, cur, 0, colUsed, diag1Used, diag2Used, n);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<StringBuilder> cur, int row, boolean[] colUsed, boolean[] diag1Used, boolean[] diag2Used, int n) {
        if (row == n) {
            List<String> curList = new ArrayList<>();
            
            for (StringBuilder sb : cur) {
                curList.add(sb.toString());
            }
            res.add(curList);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!colUsed[col] && !diag1Used[col + row] && !diag2Used[n - 1 - row + col]) {
                cur.get(row).setCharAt(col, 'Q');
                //n - 1, 0 -> 0
                //n - 2, 0 - > 1
                //n - 1, 2 -> 2
                colUsed[col] = true;
                diag1Used[col + row] = true;
                diag2Used[n - 1 - row + col] = true;
                dfs(res, cur, row + 1, colUsed, diag1Used, diag2Used, n);
                cur.get(row).setCharAt(col, '.');
                colUsed[col] = false;
                diag1Used[col + row] = false;
                diag2Used[n - 1 - row + col] = false;
            }
        }
    }
}