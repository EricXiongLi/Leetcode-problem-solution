class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Deque<Integer> dq = new ArrayDeque<>();
        if (s.charAt(0) != '0' || s.charAt(n - 1) != '0') return false;
        dq.offer(0);
        for (int i = 0; i < n && i != -1; i = s.indexOf('0', i + 1)) {
            while (!dq.isEmpty() && dq.peek() + maxJump < i) dq.poll();
            if (!dq.isEmpty() && dq.peek() + minJump <= i) {
                dq.offer(i);
                if (i == n - 1) return true;
            }
            if (dq.isEmpty()) return false;
        }
        return false;
    }
}