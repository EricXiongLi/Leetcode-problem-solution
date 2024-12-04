class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        
        int n = points.length;
        if (n == 0) return 0;
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= prevEnd) {
                prevStart = Math.max(prevStart, points[i][0]);
                prevEnd = Math.min(prevEnd, points[i][1]);
            } else {
                prevStart = points[i][0];
                prevEnd = points[i][1];
                count++;
            }
        }
        count++;
        
        
        return count;
    }
}

//tc: O(n)
//sc: O(1)