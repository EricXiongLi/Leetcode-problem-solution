class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        int n = heights.length;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || heights[i] > stack.peek()) {
                stack.push(heights[i]);
                res.push(i);
            }
        }
        int[] res2 = res.stream().mapToInt(Integer::intValue).toArray();
        return res2;
    }
}