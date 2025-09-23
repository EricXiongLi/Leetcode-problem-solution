/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<int[]> events = new ArrayList<>();

        for (List<Interval> employee : schedule) {
            for (Interval avail : employee) {
                //[time, add a busy employee or remove a busy employee]
                events.add(new int[]{avail.start, 1});
                events.add(new int[]{avail.end, -1});
            }
        }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int prev = -1;
        int curBusy = 0;
        List<Interval> ans = new ArrayList<>();

        for (int[] event : events) {
            if (curBusy == 0 && prev > 0) {
                ans.add(new Interval(prev, event[0]));
            }
            curBusy += event[1];
            prev = event[0];
        }

        return ans;
    }
}