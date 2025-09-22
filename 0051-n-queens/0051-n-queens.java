class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //diagnoal1: r + c
        //diagonal2: c-  r
        Set<Integer> diag1 = new HashSet<>(), diag2 = new HashSet<>();
        boolean[] fulfilledRow = new boolean[n], fulfilledCol = new boolean[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        List<StringBuilder> path = new ArrayList<StringBuilder>();

        for (int i = 0; i < n; i++) {
            path.add(new StringBuilder(sb));
        }
        
        backtracking(0, n, path, diag1, diag2, fulfilledCol);
        return res;
    }

    public void backtracking(int row, int n, List<StringBuilder> path, Set<Integer> diag1, Set<Integer> diag2, boolean[] fulfilledCol) {
        if (row == n) {
            List<String> cur = new LinkedList<>();

            for (StringBuilder sb : path) {
                cur.add(sb.toString());
            }

            res.add(cur);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!diag1.contains(row + col) && !diag2.contains(col - row) && !fulfilledCol[col]) {
                path.get(row).setCharAt(col, 'Q');
                fulfilledCol[col] = true;
                diag1.add(row + col);
                diag2.add(col - row);
                backtracking(row + 1, n, path, diag1, diag2, fulfilledCol);
                fulfilledCol[col] = false;
                diag1.remove(row + col);
                diag2.remove(col - row);
                path.get(row).setCharAt(col, '.');
            }
        }

    }
}