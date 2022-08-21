/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nl) {
        int maxDepth = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ni : nl) {
            maxDepth = Math.max(maxDepth(ni), maxDepth);
            q.offer(ni);
        }
        int level = 1;
        int depthSum = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                NestedInteger cur = q.poll();
                if (cur.isInteger()) {
                    depthSum += (maxDepth - level + 1) * cur.getInteger();
                } else {
                    for (NestedInteger child : cur.getList()) {
                        q.offer(child);
                    }
                }
            }
            level++;
        }
        return depthSum;
    }
    
    private int maxDepth(NestedInteger ni) {
        if (ni.isInteger()) return 1;
        int max = 1;
        for (NestedInteger child : ni.getList()) {
            max = Math.max(maxDepth(child) + 1, max);
        }
        return max;
    }
}