class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                while (!dq.isEmpty() && dq.peek() > 0 && dq.peek() + asteroids[i] < 0) {
                    dq.pop();
                }
                
                if (dq.isEmpty() || dq.peek() < 0) {
                    dq.push(asteroids[i]);
                } else if (!dq.isEmpty() & dq.peek() > 0 && dq.peek() + asteroids[i] == 0) {
                    dq.pop();
                }
            } else {
                dq.push(asteroids[i]);
            }
        }

        int[] res = new int[dq.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = dq.pollLast();
        }

        return res;
    }
}