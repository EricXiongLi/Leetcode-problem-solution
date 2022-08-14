class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isMakable(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == max + 1 ? -1 : left;
    }
    
    //wether makable in day th day
    private boolean isMakable(int[] bloomDay, int m, int k, int day) {
        int bouquet = 0, curFlower = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                curFlower++;
                if (curFlower == k) {
                    bouquet++;
                    curFlower = 0;
                    if (bouquet == m) return true;
                }
            } else {
                curFlower = 0;
            }
        }
        return false;
    }
}