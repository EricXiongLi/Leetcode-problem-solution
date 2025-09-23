class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
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
            size[i] = 1;
        }
    }

    public int find(int x) {
        int parentX = parent[x];
        if (parentX != parent[parentX]) {
            parent[x] = find(parentX);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] <= size[rootY]) {
            size[rootY] += size[rootX];
            parent[rootX] = rootY;
        } else {
            size[rootX] += size[rootY];
            parent[rootY] = rootX;
        }
    }
}