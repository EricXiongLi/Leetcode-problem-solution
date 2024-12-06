class Solution {
    public boolean checkPossibility(int[] nums) {
        return LIS(nums) >= nums.length - 1;
    }
    
    public int LIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //find the first value greater than num
        //less, less, equal
        //l,     m       rlm l
        
        for (int num : nums) {
            int l = 0, r = res.size() - 1;
            while (l <= r) {
                int m = l + r >> 1;
                if (res.get(m) <= num) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            
            if (l == res.size()) {
                res.add(num);
            } else {
                res.set(l, num);
            }
        }
        
        return res.size();
    }
}