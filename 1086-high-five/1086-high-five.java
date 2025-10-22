class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0], score = item[1];
            map.computeIfAbsent(id, v -> new PriorityQueue<Integer>((a, b) -> b - a)).add(score);
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (int i : map.keySet()) {
            int total = 0;
            PriorityQueue<Integer> q = map.get(i);
            for (int j = 0; j < 5; j++) {
                total += q.poll();
            }

            res[idx][0] = i;
            res[idx][1] = total/5;
            idx++;
        }

        return res;
    }
}