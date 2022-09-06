class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            d.addLast(pushed[i]);
            while (!d.isEmpty() && d.peekLast() == popped[j] && ++j >= 0) d.pollLast(); 
        }
        return d.isEmpty();
    }
}

