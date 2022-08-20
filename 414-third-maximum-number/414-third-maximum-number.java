class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i : nums) {
            ts.add(i);
            if (ts.size() > 3) {
                ts.pollFirst();
            }
        }
        return ts.size() == 3 ? ts.first() : ts.last();
    }
}