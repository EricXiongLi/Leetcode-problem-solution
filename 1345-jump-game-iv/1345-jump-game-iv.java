class Solution {
    public int minJumps(int[] nums) {
        Set<Integer> head = new HashSet<>();
        Set<Integer> tail = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<Integer>()).add(i);
        }
        head.add(0);
        tail.add(nums.length - 1);
        boolean[] visited = new boolean[nums.length];
        int step = 0;
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                Set<Integer> temp = head;
                head = tail;
                tail = temp;
            }
            Set<Integer> next = new HashSet<>();
            for (int cur : head) {
                int left = cur - 1;
                int right = cur + 1;
                if (tail.contains(left) || tail.contains(right)) {
                    return step + 1;
                }
                if (left >= 0 && !visited[left]) {
                    next.add(left);
                    visited[left] = true;
                }
                if (right < nums.length && !visited[right]) {
                    next.add(right);
                    visited[right] = true;
                }
                for (int nei : map.get(nums[cur])) {
                    if (nei != cur && tail.contains(nei)) return step + 1;
                    if (nei != cur && !visited[nei])  {
                        next.add(nei);
                        visited[nei] = true;
                    }
                }
            }
            step++;
            head = next;
        }
        return 0;
    }
}