class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //0, maxVal
        //canEat(speed): is it possible to eat all bananas within h hours
        
        //[f, t, t, t]
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean canEat(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            int currentTime = (pile + speed - 1)/ speed;
            time += currentTime;
        }
        return time <= h;
    }
}