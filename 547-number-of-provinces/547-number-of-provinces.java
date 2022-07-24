class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isConnected[row][col] == 1) {
                    dsu.union(row, col);
                }
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                ans++;
            }
        }
        
        return ans;
    }
}

class DSU {
    int[] parent;
    
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
    
}

//tc: O( alpha(n) * n ^ 2 )
//sc: O(n)