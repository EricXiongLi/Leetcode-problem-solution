class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        //(2, 4): (remaing task number of this type, the nearest time for handling)
        PriorityQueue<Integer> tasksQueue = new PriorityQueue<>((a, b) -> b - a);
        //(remaining number, the nearest time for handling)
        Queue<int[]> q = new LinkedList<>();
        
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        tasksQueue.addAll(freq.values());
        
        int time = 0;
        while (!q.isEmpty() || !tasksQueue.isEmpty()) {
            time++;
            if (!q.isEmpty() && q.peek()[1] <= time) {
                tasksQueue.offer(q.poll()[0]);
            }
            
            if (!tasksQueue.isEmpty()) {
                int cur = tasksQueue.poll();
                if (cur > 1) {
                    q.offer(new int[]{cur - 1, time + 1 + n});
                }
            }
        }
        
        return time;
    }
}

//0, 1, 2, 3, 4, 5, 6
//q: [2, 1]

//cool: [(2, 6), (1, 7), (1, 8),]

