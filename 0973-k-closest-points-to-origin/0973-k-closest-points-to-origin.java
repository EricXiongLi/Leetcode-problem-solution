class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        quickSort(points, k - 1, 0, n - 1);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    public void quickSort(int[][] points, int k, int start, int end) {
        int partitionIndex = partition(points, k, start, end);
        if (partitionIndex == k) {
            return;
        } else if (partitionIndex > k) {
            quickSort(points, k, start, partitionIndex - 1);
        } else {
            quickSort(points, k, partitionIndex + 1, end);
        } 
    }
    
    public int partition(int[][] points, int k, int start, int end) {
        int wall = start;
        int pivot = start + (int) (Math.random() * (end - start));
        swap(points, pivot, end);
        for (int i = start; i < end; i++) {
            if (dist(points[i]) < dist(points[end])) {
                swap(points, wall, i);
                wall++;
            }
        }
        swap(points, wall, end);
        return wall;
    }
    
    public double dist(int[] point) {
        double x = point[0], y = point[1];

        return x * x + y * y;
    }
    
    public void swap(int[][] points, int x, int y) {
        int[] tmp = points[x];
        points[x] = points[y];
        points[y] = tmp;
    }
}