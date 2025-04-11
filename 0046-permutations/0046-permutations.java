class Solution {
    List<List<Integer>> res ;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();

        backtracking(nums, visited, new LinkedList<Integer>());

        return res;
    }

    public void backtracking(int[] nums, Set<Integer> visited, Deque<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                cur.push(nums[i]);
                backtracking(nums, visited, cur);
                visited.remove(i);
                cur.pop();
            }
        }

    }
}