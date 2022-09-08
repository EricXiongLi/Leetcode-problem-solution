public class ZigzagIterator {
    Queue<int[]> q = new LinkedList<>(); //[which list, index in the list]
    int[] sz = new int[2];
    List<List<Integer>> list = new ArrayList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list.add(v1);
        list.add(v2);
        sz[0] = v1.size();
        sz[1] = v2.size();
        if (sz[0] > 0) {
            q.offer(new int[]{0, 0});
        }
        if (sz[1] > 0) {
            q.offer(new int[]{1, 0});
        }
    }

    public int next() {
        if (!hasNext()) return -1;
        int[] cur = q.poll();
        int listNum = cur[0];
        int index = cur[1];
        int nextIndex = cur[1] + 1;
        if (nextIndex < sz[listNum]) {
            q.offer(new int[]{listNum, nextIndex});
        }
        return list.get(listNum).get(index);
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */