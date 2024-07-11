class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfactionWithoutUse = 0;
        int n = grumpy.length;
        int[] diff = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfactionWithoutUse += customers[i];
            } else {
                diff[i] = customers[i];
            }
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += diff[r];
            if (r - l + 1 > minutes) {
                sum -= diff[l];
                l++;
            }
            
            maxSum = Math.max(sum, maxSum);
        }
        
        return satisfactionWithoutUse + maxSum;
        
    }
}

//tc: O(n)
//sc: O(n), can be optimized by replacing diff[] array, it's not necessary