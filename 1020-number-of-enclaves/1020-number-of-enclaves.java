class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DSU dsu = new DSU(m * n + 1);
        int totalNum = 0;
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                dsu.union(col, m * n);
                totalNum++;
            }
            if (m != 1 && grid[m - 1][col] == 1) {
                dsu.union((m - 1) * n + col, m * n);
                totalNum++;
            }
        }
        
        
        for (int row = 1; row < m - 1; row++) {
            if (grid[row][0] == 1) {
                dsu.union(row * n, m * n);
                totalNum++;
            }
            if (n != 1 && grid[row][n - 1] == 1) {
                dsu.union (row * n + n -1, m * n);
                totalNum++;
            }
        }
        
        for (int row = 1; row < m - 1; row++) {
            for (int col = 1; col < n - 1; col++) {
                if (grid[row][col] == 1) {
                    totalNum++;
                    //up
                    if (grid[row - 1][col] == 1) {
                        dsu.union((row - 1) * n + col, row * n + col);
                    }
                    
                    if (grid[row + 1][col] == 1) {
                        dsu.union((row + 1) * n + col, row * n + col);
                    }
                    
                    if (grid[row][col + 1] == 1) {
                        dsu.union(row * n + col + 1, row * n + col);
                    } 
                    if (grid[row][col - 1] == 1) {
                        dsu.union(row * n + col - 1, row * n + col);
                    }
                }
                
            }
        }
        
        return totalNum - dsu.size[dsu.find(m * n)] + 1;
    }
}

class DSU {
    int[] parent;
    int[] size;
    
    public DSU(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] <= size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
    
    public int findMax() {
        int max = 0;
        for (int s : size) max = Math.max(s, max);
        return max;
    }
}