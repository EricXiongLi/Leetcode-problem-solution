import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        // Max-heap to store task frequencies
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>((a, b) -> b - a);
        // Cooldown queue to manage tasks during the cooldown period
        Queue<int[]> cooldownQueue = new LinkedList<>();
        
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        
        // Add all task frequencies to the max-heap
        taskQueue.addAll(freq.values());
        
        int time = 0;
        
        while (!taskQueue.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            
            // Check if any task in cooldown can be re-added to the taskQueue
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] <= time) {
                taskQueue.offer(cooldownQueue.poll()[0]);
            }
            
            // Process the next task if available
            if (!taskQueue.isEmpty()) {
                int remaining = taskQueue.poll();
                if (remaining > 1) {
                    cooldownQueue.offer(new int[]{remaining - 1, time + n + 1});
                }
            }
        }
        
        return time;
    }
}
