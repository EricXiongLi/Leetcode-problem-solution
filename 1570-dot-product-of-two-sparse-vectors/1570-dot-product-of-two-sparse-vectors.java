class SparseVector {
    
    List<int[]> pairs;
    
    SparseVector(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }
    
//     [[0, 1], [3, 2], [4, 3]]
    
//     {[1, 3],[3, 4]}
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0;
        int res = 0;
        
        while (i < pairs.size() && j < vec.pairs.size()) {
            int[] pair1 = pairs.get(i), pair2 = vec.pairs.get(j);
            if (pair1[0] == pair2[0]) {
                res += pair1[1] * pair2[1];
                i++;
                j++;
            } else if (pair1[0] < pair2[0]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}

//tc: O(n), O(L)
//sc: O(n)

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);