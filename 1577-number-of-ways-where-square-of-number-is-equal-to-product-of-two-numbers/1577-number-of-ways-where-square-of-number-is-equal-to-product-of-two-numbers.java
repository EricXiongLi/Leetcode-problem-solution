class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return count(nums1, nums2) + count(nums2, nums1);
    }

    public int count(int[] nums1, int[] nums2) {
        Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums1) {
            long product = (long)num * num;
            map.put(product, map.getOrDefault(product, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num: nums2) {
            for (long product : map.keySet()) {
                if (product % num != 0) continue;
                int target = (int)(product / num);
                res += (map.get(product))* map2.getOrDefault(target, 0);
            }
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}