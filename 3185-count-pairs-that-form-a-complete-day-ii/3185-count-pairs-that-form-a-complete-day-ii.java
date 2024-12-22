class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long res = 0;
        int[] count = new int[24];

        for (int hour : hours) {
            int remainder = hour % 24;
            int target = (24 - remainder) % 24;
            res += count[target];
            count[remainder]++;
        }
        return res;
    }
}