class FirstUnique {
    Map<Integer, Integer> count = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            q.offer(num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && count.get(q.peek()) != 1) {
                q.poll();
        }

        if (q.isEmpty()) return -1;
        return q.peek();
    }
    
    public void add(int value) {
        q.offer(value);
        count.put(value, count.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */