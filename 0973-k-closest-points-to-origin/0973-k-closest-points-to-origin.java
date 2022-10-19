class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
        }
        quickSort(points, 0, n - 1, k - 1);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
    
    void quickSort(int[][] points, int l, int r, int k) {
        int partitionIndex = partition(points, l, r);
        if (partitionIndex == k) return;
        else if (partitionIndex > k) {
            quickSort(points, l, partitionIndex - 1, k);
        } else {
            quickSort(points, partitionIndex + 1, r, k);
        }
    }
    
    int partition(int[][] points, int l, int r) {
        int pivot = dist(points, r);
        int wall = l;
        for (int i = l; i < r; i++) {
            if (dist(points, i) < pivot) {
                swap(points, i, wall);
                wall++;
            }
        }
        swap(points, wall, r);
        return wall;
    }
    
    int dist(int[][] points, int i) {
        return (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
    }
    
    void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}