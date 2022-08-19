class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        DSU dsu = new DSU(m * n + 1);
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dsu.union(i * n, m * n);
            if (board[i][n - 1] == 'O') dsu.union(i * n + n - 1, m * n);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dsu.union(j, m * n);
            if (board[m - 1][j] == 'O') dsu.union((m - 1) * n + j, m * n);
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int[] dir : dirs) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (newRow >= 0 && newRow < m && newCol >=0 && newCol < n && board[newRow][newCol] == 'O') {
                            dsu.union(i * n + j, newRow * n + newCol);
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !dsu.connected(i * n + j, m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class DSU {
    int parent[];
    
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
    
    public boolean connected(int x, int y) {
        return (find(x) == find(y));
    }
}