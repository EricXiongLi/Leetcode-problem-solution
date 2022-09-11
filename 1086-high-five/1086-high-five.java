class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int[] item: items) {
            int id = item[0];
            int score = item[1];
            map.computeIfAbsent(id, v -> new PriorityQueue<Integer>((a, b) -> a - b)).add(score);
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }
        
        List<int[]> res = new ArrayList<>();
        for (int id : map.keySet()) {
            Queue<Integer> scores = map.get(id);
            int scoreSum = 0;
            for (int score : scores) {
                scoreSum += score;
            }
            int average = scoreSum / 5;
            res.add(new int[]{id, average});
        }
        
        int[][] ans = new int[res.size()][];
        return res.toArray(ans);
    }
}