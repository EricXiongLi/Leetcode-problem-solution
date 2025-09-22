class Solution {
    List<List<Character>> options = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public void generateOptions(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Character> cur = new ArrayList<>();

            if (Character.isLetter(c)) {
                cur.add(c);
            } else if (c == '{') {
                while (s.charAt(i) != '}') {
                    if (Character.isLetter(s.charAt(i))) {
                        cur.add(s.charAt(i));
                    }
                    i++;
                }
            }

            Collections.sort(cur);
            options.add(cur);
        }
    }

    public String[] expand(String s) {
        generateOptions(s);
        StringBuilder path = new StringBuilder();
        backtracking(s, 0, path);
        return res.toArray(new String[0]);
    }

    public void backtracking(String s, int pos, StringBuilder path) {
        if (pos == options.size()) {
            res.add(path.toString());
            return;
        }
        for (char option : options.get(pos)) {
            path.append(option);
            backtracking(s, pos + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
}

//tc: O(exponential)

//sc: O(n)