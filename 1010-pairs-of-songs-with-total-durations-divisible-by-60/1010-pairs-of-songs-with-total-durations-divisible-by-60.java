class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        
        for (int i = 0; i < time.length; i++) {
            int remainder = time[i] % 60;
            int target = (60 - remainder) % 60;
            res += count[target];
            count[remainder]++;
        }
        
        return res;
        
    }
}