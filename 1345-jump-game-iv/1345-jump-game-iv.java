class Solution {
    public int minJumps(int[] nums) {
        Queue<Integer> head = new LinkedList<>();
        Queue<Integer> tail = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // <val, all the index with the val>
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<Integer>()).add(i);
        }
        head.offer(0);
        tail.offer(nums.length - 1);
        boolean[] visited = new boolean[nums.length];
        int step = 0;
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                Queue<Integer> temp = head;
                head = tail;
                tail = temp;
            }
            int sz = head.size();
            for (int i = 0; i < sz; i++) {
                int cur = head.poll();
                int left = cur - 1;
                int right = cur + 1;
                if (tail.contains(left) || tail.contains(right)) {
                    return step + 1;
                }
                if (left >= 0 && !visited[left]) {
                    head.offer(left);
                    visited[left] = true;
                }
                if (right < nums.length && !visited[right]) {
                    head.offer(right);
                    visited[right] = true;
                }
                for (int j : map.get(nums[cur])) {
                    if (j != cur && tail.contains(j)) return step + 1;
                    if (j != cur && !visited[j]) {
                        head.offer(j);
                        visited[j] = true;
                    }
                }
                map.get(nums[cur]).clear();
            }
            step++;
        }
        return 0;
    }
}