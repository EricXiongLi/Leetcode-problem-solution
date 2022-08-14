class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int max = position[n - 1] - position[0];
        int left = 0, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPut(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    //the minimum magnetic force between any two balls is greater or equal than min
    private boolean canPut(int[] position, int m, int min) {
        int pre = 0, ball = 1;
        for (int i = 0; i < position.length; i++) {
            if (position[i] - position[pre] >= min) {
                ball++;
                if (ball >= m) return true;
                pre = i;
            }
        }
        return false;
    }
}