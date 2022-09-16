class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        //start: [1, 9 - k], [k, 9]
        //
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, k, i, res);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void dfs(int n, int k, int num,  List<Integer> res) {
        if (n == 0) {
            res.add(num);
            return;
        }
        int lastDigit = num % 10;
        List<Integer> q = new ArrayList<>();
        if (lastDigit + k >= 0 && lastDigit + k <= 9) {
            q.add(lastDigit + k);
        }
        if (k != 0 && lastDigit - k >= 0 && lastDigit - k <= 9) {
            q.add(lastDigit - k);
        }
        for (int val : q) {
            int newVal = num * 10 + val;
            dfs(n - 1, k, newVal, res);
        }
    }
}