class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hm = new HashMap();
        int[] ans = new int[l1 + l2];
        int index = 0;
        for (int i = 0; i < l1; i++) {
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < l2; i++) {
            int count = hm.getOrDefault(nums2[i], 0);
            if (count > 0) {
                count--;
                if (count > 0) {
                    hm.put(nums2[i], count);
                } else {
                    hm.remove(nums2[i]);
                }
                ans[index] = nums2[i];
                index++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}

//tc: O(n)
