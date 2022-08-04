class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            tmp.add(sb);
        }
        boolean[] colUsed = new boolean[n];
        boolean[] diag1Used= new boolean[2 *n - 1], diag2Used = new boolean[2 * n - 1];
        dfs(res, tmp, n, 0, colUsed, diag1Used, diag2Used);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<StringBuilder> tmp, int n, int row, boolean[] colUsed, boolean[] diag1Used, boolean[] diag2Used) {
        if (row == n) {
            List<String> level = new LinkedList<>();
            for (StringBuilder sb : tmp) {
                level.add(sb.toString());
            }
            res.add(level);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!colUsed[i] && !diag1Used[i + row] && !diag2Used[n - 1 - i + row]) {
                tmp.get(row).setCharAt(i, 'Q');
                colUsed[i] = true;
                diag1Used[i + row] = true;
                diag2Used[n - 1 - i + row] = true;
                dfs(res, tmp, n, row + 1, colUsed, diag1Used, diag2Used);
                colUsed[i] = false;
                diag1Used[i + row] = false;
                diag2Used[n - 1 - i + row] = false;
                tmp.get(row).setCharAt(i, '.');
            }
        }
    }
}