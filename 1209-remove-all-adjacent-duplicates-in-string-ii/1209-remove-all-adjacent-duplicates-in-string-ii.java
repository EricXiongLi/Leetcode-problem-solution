class Solution {
    //d,e,e,e,d,b,b,c,c,c,b,d,a,a. k = 3
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty() || stack.peekFirst().c != cur) {
                stack.push(new Pair(cur, 1));
            } else {
                int curIndex = stack.peekFirst().index + 1;
                stack.push(new Pair(cur, curIndex));
                if (curIndex == k) {
                    for (int j = 0; j < k; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast().c);
        }
        return res.toString();
    }
    
    
}

class Pair {
    char c;
    int index;
    
    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}