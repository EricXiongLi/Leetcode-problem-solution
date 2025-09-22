class Solution {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        int opening = 0, closed = 0;

        StringBuilder path = new StringBuilder();
        backtracking(n, opening, closed, path);
        return res;
    }

    public void backtracking(int n, int opening, int closed, StringBuilder path) {
        if (opening == n && closed == n) {
            res.add(path.toString());
            return;
        }

        if (opening > n || closed > n) {
            return;
        }

        if (opening >= closed && opening < n) {
            path.append('(');
            opening++;
            backtracking(n, opening, closed, path);
            path.deleteCharAt(path.length() - 1);
            opening--;

            path.append(')');
            closed++;
            backtracking(n, opening, closed, path);
            path.deleteCharAt(path.length() - 1);
            closed--;
        } else {
            path.append(')');
            closed++;
            backtracking(n, opening, closed, path);
            path.deleteCharAt(path.length() - 1);
            closed--;
        }
        
    }
}