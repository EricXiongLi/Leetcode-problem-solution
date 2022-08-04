class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums2.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> valToPos = new HashMap<>(); // <Val, position>
        for (int i = nums2.length - 1; i >=0; i--) {
            valToPos.put(nums2[i], i);
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            tmp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = tmp[valToPos.get(nums1[i])];
        }
        return res;
    }
}