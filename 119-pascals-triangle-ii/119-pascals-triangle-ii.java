class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res = pre;
        for (int i = 0; i < rowIndex; i++) {
            res = new ArrayList<Integer>();
            res.add(1);
            for (int j = 1; j <= i; j++) {
                res.add(pre.get(j) + pre.get(j - 1));
            }
            res.add(1);
            pre = res;
        }
        return res;
    }
}