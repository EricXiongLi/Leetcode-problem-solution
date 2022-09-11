class Solution {
    public int[][] kClosest(int[][] points, int k) {
        sort(points, k, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    public void sort(int[][] points, int k, int l, int r) {
        if (l >= r) {
            return;
        }
        int partitionIndex = partition(points, l, r);
        if (partitionIndex == k) {
            return;
        }
        if (partitionIndex < k) {
            sort(points, k, partitionIndex + 1, r);
        } else {
            sort(points, k, l, partitionIndex - 1);
        }
    }
    
    private int partition(int[][] points, int left, int right) {
        int pivot = right;
        int lowerIndex = left;
        int greaterIndex = right - 1;
        int pivotDist = dist(points[pivot]);
        while (true) {
            while (lowerIndex < right && dist(points[lowerIndex]) <= pivotDist) {
                lowerIndex++;
            }
            while (greaterIndex >= left && dist(points[greaterIndex]) > pivotDist) {
                greaterIndex--;
            }
            if (lowerIndex > greaterIndex) {
                swap(points, lowerIndex, pivot);
                break;
            }
            swap(points, lowerIndex, greaterIndex);
        }
        return lowerIndex;
    }
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1]; 
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}