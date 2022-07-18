class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //bucket sort
        Map<Integer, Integer> hm = new HashMap();
        for (int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        
        
        List<Integer>[] freqBucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            freqBucket[i] = new LinkedList();
        }
        for (Map.Entry<Integer, Integer> e: hm.entrySet()) {
            freqBucket[e.getValue()].add(e.getKey());
        }
        List<Integer> ans = new ArrayList();
        for (int i = nums.length; i >= 1; i--) {
            for (Integer val: freqBucket[i]) {
                ans.add(val);
                if (ans.size() == k) {
                   for (int j = 0; j < k; j++) {
                       res[j] = ans.get(j);
                   }
                    return res;
                }
            }
        }
        return res;
        
    }
}

//tc: O(n) 
//sc: O(n)