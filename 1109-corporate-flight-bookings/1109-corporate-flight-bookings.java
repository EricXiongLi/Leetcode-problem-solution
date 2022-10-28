class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] count = new int[n];
        for (int[] b : bookings) {
            int start = b[0] - 1, end = b[1] - 1;
            count[start] += b[2];
            if (end + 1 < n) count[end + 1] -= b[2];
        }
        int prefix = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            prefix += count[i];
            count[i] = prefix;
        }
        return count;
    }
}