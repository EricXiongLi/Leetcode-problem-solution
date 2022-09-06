class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int n = pushed.length;
        int p = 0;
        Deque<Integer> pushedStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            pushedStack.push(pushed[i]);
            while (!pushedStack.isEmpty() && p < n && pushedStack.peek() == popped[p]) {
                pushedStack.pop();
                p++;
            }
        }
        
        return pushedStack.isEmpty();
    }
}