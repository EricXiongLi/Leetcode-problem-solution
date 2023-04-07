class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == '1') {
                            dsu.union(i * n + j, newRow * n + newCol);
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && i * n + j == dsu.find(i * n + j))
                    count++;
            }
        }
        return count;
    }
    
    
}

class DSU {
    int[] parent;
    int[] size;
    
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
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
}

