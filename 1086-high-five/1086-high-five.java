class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            //O(n)
            int id = item[0];
            int score = item[1];
            map.computeIfAbsent(id, v -> new PriorityQueue<Integer>()).add(score);
            //O(logN)
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
            res.add(new int[]{id, scoreSum / 5});
        }
        
        int[][] ans = new int[res.size()][];
        return res.toArray(ans);
    }
}

//time complexity:O(n logN)
//space : O(n);