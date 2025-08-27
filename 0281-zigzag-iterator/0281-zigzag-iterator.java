public class ZigzagIterator {
    int p0 = -1;
    int p1 = -1;
    int cur;

    List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        cur = v1.size() == 0 ? 1 : 0;
    }

    public int next() {
        if (cur == 0) {
            p0++;
            if (p1 != v2.size() - 1) {
                cur = 1;
            }
            return v1.get(p0);
        } else {
            p1++;
            if (p0 != v1.size() - 1) {
                cur = 0;
            }
            return v2.get(p1);
        }
    }

    public boolean hasNext() {
        return !(p0 == v1.size() -1 && p1 == v2.size() -1) ;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */