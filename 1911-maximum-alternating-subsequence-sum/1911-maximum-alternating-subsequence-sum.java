class Solution {
    public long maxAlternatingSum(int[] nums) {
        //Inspired by lee215
        long odd = 0, even = 0;
        for (int num : nums) {
            odd = Math.max(even + num, odd);
            even = Math.max(even, odd - num);
        }
        
        return Math.max(even, odd);
    }
}

//tc: O(n)
//sc: O(1)