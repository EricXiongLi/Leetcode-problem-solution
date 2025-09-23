class MyCalendar {
    //start time, end time
    TreeMap<Integer, Integer> schedules;
    public MyCalendar() {
        schedules = new TreeMap<>();
    }
    //  --------prev         next---------
    //.           ....
    public boolean book(int startTime, int endTime) {
        Integer prev = schedules.floorKey(startTime), next = schedules.ceilingKey(startTime);

        if ((prev == null || schedules.get(prev) <= startTime) && (next == null || next >= endTime)) {
            schedules.put(startTime, endTime);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

 //(10, 20), (15, 25)