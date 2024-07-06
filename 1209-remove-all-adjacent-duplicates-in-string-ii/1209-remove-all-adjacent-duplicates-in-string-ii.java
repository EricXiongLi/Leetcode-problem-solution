class Solution {    
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != c) {
                stack.push(new Pair(c, 1));
            } else {
                stack.peek().count++;
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.ch);
            }
        }
        return sb.reverse().toString();
        
    }
}

class Pair {
        char ch;
        int count;
        
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
}

//tc: O(n)
//sc: O(n)