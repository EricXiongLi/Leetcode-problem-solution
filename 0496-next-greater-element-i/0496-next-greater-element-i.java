class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] nextGreater = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!dq.isEmpty() && nums2[i] >= dq.peek()) {
                dq.pop();
            }
            nextGreater[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(nums2[i]);
        }
        int n1 = nums1.length;
        for (int i = 0; i < n1; i++) {
            nums1[i] = nextGreater[map.get(nums1[i])];
        }
        return nums1;
    }
}