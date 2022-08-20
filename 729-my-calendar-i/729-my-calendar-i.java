class MyCalendar {
    TreeSet<int[]> ts;
    public MyCalendar() {
        ts = new TreeSet<>((a, b) -> Integer.compare(a[0], b[0]));
    }
    
    public boolean book(int start, int end) {
        if (ts.isEmpty()) {
            ts.add(new int[]{start, end});
            return true;
        }
        int[] tmp = new int[]{end, 0};
        int[] firstGreater = ts.ceiling(tmp);
        int[] prev = firstGreater == null ? ts.last() : ts.lower(firstGreater);
        if ((prev == null && firstGreater[0] >= end) || (firstGreater == null && prev[1] <= start) || (prev[1] <= start && firstGreater[0] >= end)) {
            ts.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */