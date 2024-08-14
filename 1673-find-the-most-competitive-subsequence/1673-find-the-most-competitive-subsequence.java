class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] &&  n - i - 1 >= k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        System.out.println(stack.toString());
        int[] res = new int[k];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = nums[stack.pollLast()];
            i++;
        }
        return res;
    }
}