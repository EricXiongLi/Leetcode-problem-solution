class Solution {
    public String removeDuplicates(String s, int k) {
        //[char - 'a', frequency]
        Deque<int[]> stack = new LinkedList<>();

        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(new int[]{c - 'a', 1});
            } else {
                if (stack.peek()[0] == c - 'a') {
                    if (stack.peek()[1] == k - 1) {
                        for (int j = 0; j < k - 1; j++) {
                            stack.pop();
                        }
                    } else {
                        stack.push(new int[]{c - 'a', stack.peek()[1] + 1});
                    }
                } else {
                    stack.push(new int[]{c - 'a', 1});
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append((char) (stack.pollLast()[0] + 'a'));
        }

        return res.toString();
    }
}