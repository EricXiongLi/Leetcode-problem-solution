class Solution {
    public String simplifyPath(String path) {
        //     /, // , ., ..,
        /////
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : arr) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/");
            res.append(stack.pollLast());
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}